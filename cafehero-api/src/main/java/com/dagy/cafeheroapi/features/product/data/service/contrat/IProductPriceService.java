package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.features.product.data.request.ProductDiscountRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductPriceRequest;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductPrice;

public interface IProductPriceService {
    ProductPrice save(ProductPriceRequest request);

    ProductPrice update(ProductPrice price);

    Boolean applyDiscount(ProductPrice price, ProductDiscountRequest request);

    ProductPrice update(ProductPriceRequest price);
}
