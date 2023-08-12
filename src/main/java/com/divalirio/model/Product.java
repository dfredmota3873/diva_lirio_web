package com.divalirio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Product {

    @Id
    private UUID id;

    private String name;

    private String description;

    private String size;

    private BigDecimal value;
}
