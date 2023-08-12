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
public class UserDTO {

    private UUID id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String phone;
}
