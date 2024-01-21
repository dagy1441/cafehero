package com.dagy.cafeheroapi.features.product.data.repository;

import com.dagy.cafeheroapi.features.product.domain.entity.Product;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    Optional<ProductPrice> findProductPriceByProduct(Product product);
}
