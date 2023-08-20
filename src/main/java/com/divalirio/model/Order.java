package com.divalirio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private UUID          id;

    private BigDecimal    totalValue;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dtOrderCreated;

    private BigDecimal freight;

    private String observations;

}
