package com.dagy.cafeheroapi.features.product.data.repository;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
