package com.divalirio.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateAddressDTORequest {

    private String street;
    private String number;
    private String neighborhood;
    private String state;
    private String zipCode;
    private String complement;
    private UUID   usuario;
}
