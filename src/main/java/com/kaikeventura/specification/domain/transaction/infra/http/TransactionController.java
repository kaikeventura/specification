package com.kaikeventura.specification.domain.transaction.infra.http;

import com.kaikeventura.specification.domain.transaction.infra.dto.EcommerceDTO;
import com.kaikeventura.specification.domain.transaction.infra.dto.TransactionDTO;
import com.kaikeventura.specification.domain.transaction.service.TransactionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> fetchTransactions(
            @RequestParam(name = "authCode", required = false) final String authCode,
            @RequestParam(name = "value", required = false) final BigDecimal value,
            @RequestParam(name = "ecommerceCnpj", required = false) final String ecommerceCnpj,
            @RequestParam(name = "ecommerceName", required = false) final String ecommerce,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "limit", required = false, defaultValue = "5") int limit,
            @SortDefault(value = "order", sort = "createdAt") Sort order
    ) {
        var transactionQueryParams = new TransactionDTO(
                authCode,
                value,
                new EcommerceDTO(
                        ecommerceCnpj,
                        ecommerce
                )
        );
        var pageable = PageRequest.of(page, limit, order);

        return ResponseEntity.ok(transactionService.fetchTransactions(transactionQueryParams, pageable));
    }
}
