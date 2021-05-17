package com.kaikeventura.specification;

import com.kaikeventura.specification.domain.transaction.entity.Ecommerce;
import com.kaikeventura.specification.domain.transaction.entity.Transaction;
import com.kaikeventura.specification.domain.transaction.infra.repository.EcommerceRepository;
import com.kaikeventura.specification.domain.transaction.infra.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class SpecificationApplication {

	@Autowired
	private EcommerceRepository ecommerceRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpecificationApplication.class, args);
	}

	@PostConstruct
	void start() {
		var ecommerceGroup = Arrays.asList(
				new Ecommerce("56980255000112", "Americanas"),
				new Ecommerce("63852466000215", "Submarino"),
				new Ecommerce("69852654000156", "Casas Bahia")
		);
		ecommerceRepository.saveAll(ecommerceGroup);

		var transactions = Arrays.asList(
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(10.00), ecommerceGroup.get(0)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(25.00), ecommerceGroup.get(1)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(10.50), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(36.20), ecommerceGroup.get(0)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(89.50), ecommerceGroup.get(1)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(12.20), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(12.20), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(12.20), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(12.20), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(12.20), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(12.20), ecommerceGroup.get(2)),
				new Transaction(UUID.randomUUID().toString(), BigDecimal.valueOf(150.05), ecommerceGroup.get(2))
		);
		transactionRepository.saveAll(transactions);
	}

}
