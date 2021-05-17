package com.kaikeventura.specification.domain.transaction.infra.repository;

import com.kaikeventura.specification.domain.transaction.entity.Ecommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceRepository extends JpaRepository<Ecommerce, Long> {
}
