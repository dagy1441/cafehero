package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductVariantRequest;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductVariantService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductVariantApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductVariantController implements ProductVariantApi {

    private final ProductVariantService variantService;
    @Override
    public ResponseEntity<ProductVariantRequest> findOne(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductVariantRequest> save(ProductVariantRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductVariantRequest>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<ProductVariantRequest> update(ProductVariantRequest request) {
        return null;
    }
}
