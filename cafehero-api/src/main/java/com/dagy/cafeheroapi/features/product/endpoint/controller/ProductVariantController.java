package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductVariantRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductVariantService;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductVariantService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductVariantApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductVariantController implements ProductVariantApi {

    private final IProductVariantService variantService;
    @Override
    public ResponseEntity<ProductVariantRequest>
    findOne(@PathVariable Long id) {
        return variantService.findOne(id);
    }

    @Override
    public ResponseEntity<ProductVariantRequest>
    save(@Valid @RequestBody ProductVariantRequest request) {
        return variantService.save(request);
    }

    @Override
    public ResponseEntity<List<ProductVariantRequest>>
    findAll() {
        return variantService.findAll();
    }

    @Override
    public ResponseEntity<ProductVariantRequest>
    update(@Valid @RequestBody ProductVariantRequest request) {
        return variantService.update(request);
    }
}
