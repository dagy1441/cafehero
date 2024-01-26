package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductUnitOfMeasureRequest;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductUnitOfMeasureService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductUnitOfMeasureApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductUnitOfMeasureController implements ProductUnitOfMeasureApi {

    private final ProductUnitOfMeasureService unitOfMeasureService;
    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> find(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductUnitOfMeasureRequest>> findMany() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> save(ProductUnitOfMeasureRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> update(ProductUnitOfMeasureRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        return null;
    }
}
