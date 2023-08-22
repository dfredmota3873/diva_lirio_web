package com.divalirio.api.controller.impl;

import com.divalirio.api.controller.doc.IProductController;
import com.divalirio.api.dto.CreateProductDTORequest;
import com.divalirio.api.dto.ProductDTO;
import com.divalirio.mapper.ProductConverter;
import com.divalirio.model.Product;
import com.divalirio.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final ProductService service;

    private final ProductConverter converter;

    @Override
    public ResponseEntity<ProductDTO> create(CreateProductDTORequest dtoRequest) {

        Product product = service.create(converter.convertDTOtoModel(dtoRequest));

        return ResponseEntity.ok(converter.convertModelToDTO(product));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(converter.convertListModelToDTO(service.findAll()));
    }

    @Override
    public ResponseEntity<ProductDTO> update(UUID id, CreateProductDTORequest productRequest) {
        Product product = service.update(id, converter.convertDTOtoModel(productRequest));
        return ResponseEntity.ok(converter.convertModelToDTO(product));
    }

    @Override
    public ResponseEntity<ProductDTO> findById(UUID id) {
        return ResponseEntity.ok(converter.convertModelToDTO(service.findById(id)));
    }

    @Override
    public ResponseEntity<String> deleteById(UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok("Produto excluído com sucesso");
    }
}
