package com.kaikeventura.specification.domain.transaction.infra.specification;

import com.kaikeventura.specification.domain.transaction.entity.Transaction;
import com.kaikeventura.specification.domain.transaction.infra.dto.TransactionDTO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class TransactionSpecification implements Specification<Transaction> {

    private static final String AUTH_CODE_FIELD = "authCode";
    private static final String VALUE_FIELD = "value";
    private static final String ECOMMERCE_FIELD = "ecommerce";
    private static final String CNPJ_FIELD = "cnpj";
    private static final String NAME_FIELD = "NAME";

    private final transient TransactionDTO queryParams;
    private final transient List<Predicate> predicates;

    public static TransactionSpecification build(final TransactionDTO params) {
        return new TransactionSpecification(params);
    }

    protected TransactionSpecification(final TransactionDTO params) {
        this.queryParams = params;
        this.predicates = new ArrayList<>();
    }

    @Override
    public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        this.addAuthCodePredicate(this.queryParams.authCode, root);
        this.addValuePredicate(this.queryParams.value, root);
        this.addEcommerceCnpjPredicate(this.queryParams.ecommerceDTO.cnpj, root);
        this.addEcommerceNamePredicate(this.queryParams.ecommerceDTO.name, root);

        criteriaQuery.distinct(true);

        return !this.predicates.isEmpty() ? criteriaBuilder.and(this.buildPredicateInArray()) : null;
    }

    private void addAuthCodePredicate(final String authCode, final Root<Transaction> root) {
        if (authCode != null) {
            var authCodePredicate = root.get(AUTH_CODE_FIELD).in(authCode);
            this.predicates.add(authCodePredicate);
        }
    }

    private void addValuePredicate(final BigDecimal value, final Root<Transaction> root) {
        if (value != null) {
            var valuePredicate = root.get(VALUE_FIELD).in(value);
            this.predicates.add(valuePredicate);
        }
    }

    private void addEcommerceCnpjPredicate(final String ecommerceCnpj, final Root<Transaction> root) {
        if (ecommerceCnpj != null) {
            var ecommerceCnpjPredicate = root.get(ECOMMERCE_FIELD).get(CNPJ_FIELD).in(ecommerceCnpj);
            this.predicates.add(ecommerceCnpjPredicate);
        }
    }

    private void addEcommerceNamePredicate(final String ecommerceName, final Root<Transaction> root) {
        if (ecommerceName != null) {
            var ecommerceNamePredicate = root.get(ECOMMERCE_FIELD).get(NAME_FIELD).in(ecommerceName);
            this.predicates.add(ecommerceNamePredicate);
        }
    }

    private Predicate[] buildPredicateInArray() {
        return this.predicates.toArray(new Predicate[0]);
    }
}
