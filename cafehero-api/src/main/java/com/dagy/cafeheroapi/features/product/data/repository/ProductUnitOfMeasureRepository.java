package com.dagy.cafeheroapi.features.product.data.repository;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductUnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductUnitOfMeasureRepository extends JpaRepository<ProductUnitOfMeasure, Long> {
    Optional<ProductUnitOfMeasure> findByTitleEqualsIgnoreCaseAndUnitEqualsIgnoreCase(String type, String unit);

    Optional<ProductUnitOfMeasure> findByTitleEqualsIgnoreCase(String title);
}