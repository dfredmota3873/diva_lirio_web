package com.divalirio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductDTO {

    private UUID id;

    private String name;

    private String description;

    private String size;

    private BigDecimal value;

    private Integer stock;


}
