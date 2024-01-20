package com.dagy.cafeheroapi.features.product.domain.usecase;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductVariant;

import java.util.List;
import java.util.Optional;

public interface IProductVariantUsecase {
    ProductVariant save(ProductVariant variant);

    List<ProductVariant> findAll();

    Optional<ProductVariant> findOne(Long id);
}
