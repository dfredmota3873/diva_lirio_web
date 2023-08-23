package com.divalirio.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTORequest {

    @Email
    private String email;
    @NotBlank(message = "a senha é obrigatória.")
    private String password;

    @NotBlank(message = "o nome é obrigatório.")
    private String name;

    @NotBlank
    private String phone;
}
