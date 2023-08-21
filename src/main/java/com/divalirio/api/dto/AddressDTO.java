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
public class AddressDTO {

    private UUID id;
    private String street;
    private String number;
    private String neighborhood;
    private String state;
    private String zipCode;
    private String complement;

    private UUID userId;
}
