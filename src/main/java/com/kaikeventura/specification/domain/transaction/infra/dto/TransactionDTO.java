package com.kaikeventura.specification.domain.transaction.infra.dto;

import java.math.BigDecimal;

public class TransactionDTO {

    public final String authCode;
    public final BigDecimal value;
    public final EcommerceDTO ecommerceDTO;

    public TransactionDTO(String authCode, BigDecimal value, EcommerceDTO ecommerceDTO) {
        this.authCode = authCode;
        this.value = value;
        this.ecommerceDTO = ecommerceDTO;
    }
}
