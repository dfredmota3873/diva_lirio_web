package com.divalirio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    private UUID id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String phone;
}
