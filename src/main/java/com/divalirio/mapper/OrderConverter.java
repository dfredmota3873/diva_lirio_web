package com.divalirio.mapper;

import com.divalirio.api.dto.*;
import com.divalirio.model.Order;
import com.divalirio.model.OrderItem;
import com.divalirio.model.Product;
import com.divalirio.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    public OrderDTO convertModelToDTO(Order order){

        return OrderDTO.builder()
                .id(order.getId())
                .status(order.getStatus().getDescription())
                .totalValue(order.getTotalValue())
                .freight(order.getFreight())
                .observations(order.getObservations())
                .user(UserDTO.builder()
                        .id(order.getUser().getId())
                        .name(order.getUser().getName())
                        .email(order.getUser().getEmail())
                        .phone(order.getUser().getPhone())
                        .build())
                .itens(order.getItens().stream().map( i -> OrderItemDTO.builder()
                        .product(ProductDTO.builder()
                                .id(i.getProduct().getId())
                                .name(i.getProduct().getName())
                                .stock(i.getProduct().getStock())
                                .description(i.getProduct().getDescription())
                                .size(i.getProduct().getSize())
                                .build())
                        .id(i.getId())
                        .quantity(i.getQuantity())
                        .order(i.getOrder().getId())
                        .observation(i.getObservation())
                        .build()).collect(Collectors.toList()))
                .build();
    }

    public Order convertDTOtoModel(CreateOrderDTORequest request){

        return Order.builder()
                .freight(request.getFreight())
                .user(User.builder()
                        .id(request.getUser())
                        .build())
                .totalValue(request.getTotalValue())
                .observations(request.getObservations())
                .itens(request.getItens().stream().map( i -> OrderItem.builder()
                        .product(Product.builder()
                                .id(i.getProduct())
                                .build())
                        .quantity(i.getQuantity())
                        .observation(i.getObservation())
                        .build()).collect(Collectors.toList()))
                .build();
    }

    public List<OrderDTO> convertListModelToDTO(List<Order> list){
        return list.stream().map(from -> convertModelToDTO(from)).collect(Collectors.toList());
    }
}
