package com.dagy.cafeheroapi.features.product.data.repository;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductDiscountDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDiscountDurationRepository extends JpaRepository<ProductDiscountDuration, Long> {

    Optional<ProductDiscountDuration> findProductDiscountDurationByPriceId(Long price);
}