package com.divalirio.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTORequest {

    private String email;
    private String password;
    private String name;
    private String phone;
}
