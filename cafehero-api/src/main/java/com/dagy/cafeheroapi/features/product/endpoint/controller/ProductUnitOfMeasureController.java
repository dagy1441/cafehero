package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductUnitOfMeasureRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductUnitOfMeasureService;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductUnitOfMeasureService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductUnitOfMeasureApi;
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
public class ProductUnitOfMeasureController implements ProductUnitOfMeasureApi {

    private final IProductUnitOfMeasureService unitOfMeasureService;
    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>>
    find(@PathVariable Long id) {
        return unitOfMeasureService.find(id);
    }

    @Override
    public ResponseEntity<List<ProductUnitOfMeasureRequest>>
    findMany() {
        return unitOfMeasureService.findAll();
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>>
    save(@Valid @RequestBody ProductUnitOfMeasureRequest dto) {
        return unitOfMeasureService.save(dto);
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>>
    update(@Valid @RequestBody ProductUnitOfMeasureRequest dto) {
        return unitOfMeasureService.update(dto);
    }

    @Override
    public ResponseEntity<Optional<Boolean>>
    remove(@PathVariable Long id) {
        return unitOfMeasureService.remove(id);
    }
}
