package com.divalirio.mapper;

import com.divalirio.api.dto.CreateProductDTORequest;
import com.divalirio.api.dto.CreateUserDTORequest;
import com.divalirio.api.dto.ProductDTO;
import com.divalirio.api.dto.UserDTO;
import com.divalirio.model.Product;
import com.divalirio.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    public ProductDTO convertModelToDTO(Product product){

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .size(product.getSize())
                .value(product.getValue())
                .stock(product.getStock())
                .build();
    }

    public Product convertDTOtoModel(CreateProductDTORequest request){

        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .size(request.getSize())
                .value(request.getValue())
                .stock(request.getStock())
                .build();
    }

    public List<ProductDTO> convertListModelToDTO(List<Product> list){
        return list.stream().map(from -> convertModelToDTO(from)).collect(Collectors.toList());
    }

}
