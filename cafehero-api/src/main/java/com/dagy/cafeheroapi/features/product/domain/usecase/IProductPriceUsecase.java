package com.dagy.cafeheroapi.features.product.domain.usecase;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductDiscountDuration;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductPrice;

import java.util.Optional;

public interface IProductPriceUsecase {
    ProductPrice save(ProductPrice price);

    Optional<ProductPrice> updateProductPrice(ProductPrice price);

    ProductDiscountDuration updateDiscountDuration(ProductDiscountDuration duration);
}
