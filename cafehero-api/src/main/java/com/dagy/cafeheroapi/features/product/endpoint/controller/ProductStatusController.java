package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductStatusRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductStatusService;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductStatusService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductStatusApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductStatusController implements ProductStatusApi {
    private final IProductStatusService statusService;
    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> find(@PathVariable Long id) {
        return this.statusService.find(id);
    }

    @Override
    public ResponseEntity<List<ProductStatusRequest>> findMany() {
        return statusService.findAll();
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>>
    save(@Valid @RequestBody ProductStatusRequest dto) {
        return statusService.save(dto);
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>>
    update(@Valid @RequestBody ProductStatusRequest request) {
        return statusService.update(request);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id) {
        return statusService.remove(id);
    }
}
