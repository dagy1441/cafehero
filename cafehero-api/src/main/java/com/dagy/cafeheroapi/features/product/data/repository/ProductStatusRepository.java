package com.dagy.cafeheroapi.features.product.data.repository;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  ProductStatusRepository extends JpaRepository<ProductStatus, Long> {
    Optional<ProductStatus> findByTitleEqualsIgnoreCase(String title);
}
