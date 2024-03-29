package com.kaikeventura.specification.domain.transaction.service;

import com.kaikeventura.specification.domain.transaction.infra.dto.EcommerceDTO;
import com.kaikeventura.specification.domain.transaction.infra.dto.TransactionDTO;
import com.kaikeventura.specification.domain.transaction.infra.repository.TransactionRepository;
import com.kaikeventura.specification.domain.transaction.infra.specification.TransactionSpecification;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDTO> fetchTransactions(final TransactionDTO transactionQueryParams, final Pageable pageable) {
        var specification =TransactionSpecification.build(transactionQueryParams);
        var transactions = transactionRepository.findAll(specification, pageable).getContent();

        return transactions.stream().map(
                transaction -> new TransactionDTO(
                        transaction.getAuthCode(),
                        transaction.getValue(),
                        new EcommerceDTO(
                                transaction.getEcommerce().getCnpj(),
                                transaction.getEcommerce().getName()
                        )
            )
        ).collect(Collectors.toList());
    }

}
