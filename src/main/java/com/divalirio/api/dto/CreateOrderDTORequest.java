package com.divalirio.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CreateOrderDTORequest {

    private BigDecimal totalValue;

    private BigDecimal freight;

    private String observations;

    private UUID user;

    private List<CreateOrderItemDTORequest> itens;
}
