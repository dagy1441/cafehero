package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductTaxRequest;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductTaxService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductTaxApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductTaxController implements ProductTaxApi {
    private ProductTaxService taxService;
    @Override
    public ResponseEntity<Optional<ProductTaxRequest>> find(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductTaxRequest>> findMany() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>> save(ProductTaxRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>> update(ProductTaxRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> toggleIsActiveStatus(Long id) {
        return null;
    }
}
