package com.kaikeventura.specification.domain.transaction.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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

    public Transaction() {
    }

    public Transaction(String authCode, BigDecimal value, Ecommerce ecommerce) {
        this.authCode = authCode;
        this.value = value;
        this.ecommerce = ecommerce;
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

}
