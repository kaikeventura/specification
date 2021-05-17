package com.kaikeventura.specification.domain.transaction.infra.dto;

public class EcommerceDTO {

    public final String cnpj;
    public final String name;

    public EcommerceDTO(String cnpj, String name) {
        this.cnpj = cnpj;
        this.name = name;
    }
}
