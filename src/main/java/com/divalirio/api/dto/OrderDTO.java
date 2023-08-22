package com.divalirio.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDTO {

    private UUID id;

    private String status;
    private BigDecimal totalValue;

    private BigDecimal freight;

    private String observations;

    private UserDTO user;

    private List<OrderItemDTO> itens;

}
