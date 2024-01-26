package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductStatusRequest;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductStatusService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductStatusApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductStatusController implements ProductStatusApi {
    private final ProductStatusService statusService;
    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> find(@PathVariable Long id) {
        return this.statusService.find(id);
    }

    @Override
    public ResponseEntity<List<ProductStatusRequest>> findMany() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> save(ProductStatusRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> update(ProductStatusRequest request) {
        return null;
    }
}
