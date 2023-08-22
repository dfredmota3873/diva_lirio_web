package com.divalirio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderItemDTO {

    private UUID id;
    private ProductDTO product;
    private UUID order;
    private Integer quantity;
    private String observation;
}
