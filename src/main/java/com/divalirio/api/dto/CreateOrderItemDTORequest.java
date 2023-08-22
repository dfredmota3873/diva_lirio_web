package com.divalirio.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateOrderItemDTORequest {

    private UUID product;

    private Integer quantity;

    private String observation;
}
