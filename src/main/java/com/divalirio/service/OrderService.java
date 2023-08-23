package com.divalirio.service;

import com.divalirio.exception.BusinessException;
import com.divalirio.exception.EntityNotFoundException;
import com.divalirio.model.Order;
import com.divalirio.model.OrderItem;
import com.divalirio.model.Product;
import com.divalirio.model.User;
import com.divalirio.model.enums.OrderStatus;
import com.divalirio.repository.OrderItemRepository;
import com.divalirio.repository.OrderRepository;
import com.divalirio.repository.ProductRepository;
import com.divalirio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService extends BaseService{

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Transactional
    public Order create(Order order){

        // validate if user exists
        User user = userRepository.findById(order.getUser().getId()).orElseThrow(() -> new EntityNotFoundException(getMessage("user.notfound")));

        order.setUser(user);

        order.setStatus(OrderStatus.WAITING_PAYMENT);

        if(order.getItens().isEmpty()){
            throw  new BusinessException("itens.empty");
        }

        order.getItens().stream().forEach( o -> o.setProduct(populateProduct(o.getProduct().getId())));


        BigDecimal totalValue = order.getItens().stream()
                .map(x -> x.getProduct().getValue().multiply(new BigDecimal(x.getQuantity())))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalValue(totalValue);

        // calculate total price for order
       // order.getItens().stream().forEach( o -> calculateTotalValueOrder(o, totalValue));

        order = orderRepository.save(order);

        Order finalOrder = order;

        // set order saved to itens
        order.getItens().stream().forEach(item -> item.setOrder(finalOrder));

        orderItemRepository.saveAll(order.getItens());

        // update stock product
        order.getItens().stream().forEach( item -> updateStockProduct(item.getProduct(), item.getQuantity()));

        return  order;

    }

    public Order findById(UUID id){
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(getMessage("order.notfound")));
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    // logical deleted
    public void deleteById(UUID uuid){
        Order orderDB = findById(uuid);
        orderDB.setStatus(OrderStatus.CANCELLED);
        orderDB.setDeletedAt(LocalDateTime.now());
        orderRepository.save(orderDB);
    }

    private BigDecimal calculateTotalValueOrder(OrderItem item , BigDecimal totalValue){

        BigDecimal valueItem = ( item.getProduct().getValue().multiply(new BigDecimal(item.getQuantity())));

        totalValue = totalValue.add(valueItem);

        return  totalValue;
    }

    private void updateStockProduct(Product product, Integer quantityDecrease) {

        Product productDB = productRepository.findById(product.getId()).orElseThrow(() -> new EntityNotFoundException(getMessage("product.notfound")));

        productDB.setStock(productDB.getStock() - quantityDecrease);

        productRepository.save(productDB);

    }

    private Product populateProduct(UUID product){
        return productRepository.findById(product).orElseThrow(() -> new EntityNotFoundException(getMessage("product.notfound")));
    }
}
