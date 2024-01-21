package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.features.product.data.request.ProductVariantRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductVariantService {
    ResponseEntity<ProductVariantRequest> save(ProductVariantRequest variant);

    ResponseEntity<List<ProductVariantRequest>> findAll();

    ResponseEntity<ProductVariantRequest> findOne(Long id);

    ResponseEntity<ProductVariantRequest> update(ProductVariantRequest request);
}
