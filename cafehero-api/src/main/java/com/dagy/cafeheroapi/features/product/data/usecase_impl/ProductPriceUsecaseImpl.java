package com.dagy.cafeheroapi.features.product.data.usecase_impl;

import com.dagy.cafeheroapi.core.annotations.Usecase;
import com.dagy.cafeheroapi.features.product.data.repository.ProductDiscountDurationRepository;
import com.dagy.cafeheroapi.features.product.data.repository.ProductPriceRepository;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductDiscountDuration;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductPrice;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductPriceUsecase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class ProductPriceUsecaseImpl implements IProductPriceUsecase {
    private final ProductPriceRepository repository;
    private final ProductDiscountDurationRepository discountDurationRepository;
    @Override
    public ProductPrice save(ProductPrice price) {
        return this.repository.save(price);
    }

    @Override
    public Optional<ProductPrice> updateProductPrice(ProductPrice price) {
        // TODO To implement
        return Optional.empty();
    }

    @Override
    public ProductDiscountDuration updateDiscountDuration(ProductDiscountDuration duration) {
        Optional<ProductDiscountDuration> optional = this.discountDurationRepository.findProductDiscountDurationByPriceId(duration.getPriceId());
        return optional.map(discount -> {
            duration.setId(discount.getId());
            return this.discountDurationRepository.save(duration);
        }).orElseGet(() -> this.discountDurationRepository.save(duration));
    }
}
