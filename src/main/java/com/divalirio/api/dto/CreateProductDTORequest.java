package com.divalirio.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateProductDTORequest {

    private String name;

    private String description;

    private String size;

    private BigDecimal value;

    private Integer stock;


}
