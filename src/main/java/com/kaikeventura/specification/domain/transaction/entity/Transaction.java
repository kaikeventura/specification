package com.kaikeventura.specification.domain.transaction.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authCode;

    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "ecommerce_id", nullable = false)
    private Ecommerce ecommerce;

    private LocalDateTime createdAt;

    public Transaction() {
    }

    public Transaction(String authCode, BigDecimal value, Ecommerce ecommerce) {
        this.authCode = authCode;
        this.value = value;
        this.ecommerce = ecommerce;
        this.createdAt = LocalDateTime.now();
    }

    public String getAuthCode() {
        return authCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Ecommerce getEcommerce() {
        return ecommerce;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
