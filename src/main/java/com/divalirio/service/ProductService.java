package com.divalirio.service;

import com.divalirio.exception.BusinessException;
import com.divalirio.model.Product;
import com.divalirio.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService extends  BaseService{

    private final ProductRepository repository;

    public Product create(Product product) {

        return repository.save(product);

    }

    public Product findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(getMessage("product.notfound")));
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product update(UUID id, Product product) {

        Product productDB = findById(id);

        productDB.setDescription(product.getDescription());
        productDB.setSize(product.getSize());
        productDB.setName(product.getName());
        productDB.setStock(product.getStock());
        productDB.setValue(product.getValue());

        return repository.save(productDB);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
