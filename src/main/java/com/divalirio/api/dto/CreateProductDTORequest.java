package com.divalirio.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateProductDTORequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    private String description;

    @NotBlank(message = "Tamanho é obrigatório.")
    private String size;

    @NotNull(message = "Valor é obrigatório.")
    private BigDecimal value;

    @NotNull(message = "Estoque é obrigatório.")
    private Integer stock;


}
