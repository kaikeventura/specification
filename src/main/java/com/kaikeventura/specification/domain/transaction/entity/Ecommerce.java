package com.kaikeventura.specification.domain.transaction.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Ecommerce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String name;

    @OneToMany(mappedBy = "ecommerce")
    private Set<Transaction> transactions;

    public Ecommerce() {
    }

    public Ecommerce(String cnpj, String name) {
        this.cnpj = cnpj;
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }
}
