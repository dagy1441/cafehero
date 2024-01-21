package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.features.product.data.request.ProductBasicRequest;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductBasic;

public interface IProductBasicService {
    ProductBasic save(ProductBasicRequest request);

    ProductBasic update(ProductBasic basic);

    ProductBasic update(ProductBasicRequest basic);
}
