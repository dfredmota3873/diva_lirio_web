package com.divalirio.model;


import jakarta.persistence.*;
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
@Table(name = "address")
public class Address {

    @Id
    private UUID id;
    private String street;
    private String number;
    private String neighborhood;
    private String state;
    private String zipCode;
    private String complement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
