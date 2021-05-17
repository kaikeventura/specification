package com.kaikeventura.specification.domain.transaction.infra.specification;

import com.kaikeventura.specification.domain.transaction.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class TransactionSpecification {

    private TransactionSpecification() {}

    public static Specification<Transaction> authCode(final String authCode) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("authCode"), authCode);
    }

    public static Specification<Transaction> value(final BigDecimal value) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("value"), value);
    }

    public static Specification<Transaction> ecommerceCnpj(final String cnpj) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ecommerce").get("cnpj"), cnpj);
    }

    public static Specification<Transaction> ecommerceName(final String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ecommerce").get("name"), name);
    }
}
