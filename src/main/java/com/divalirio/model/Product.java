package com.divalirio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    private UUID id;

    private String name;

    private String description;

    private String size;

    private BigDecimal value;

    private Integer stock;

    @OneToMany(mappedBy = "product", targetEntity = ProductImage.class, fetch = FetchType.LAZY)
    private List<ProductImage> images;
}
