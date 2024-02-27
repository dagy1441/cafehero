package com.dagy.cafeheroapi.features.product.presenter.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductTaxRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductTaxService;
import com.dagy.cafeheroapi.features.product.presenter.api.ProductTaxApi;
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
public class ProductTaxController implements ProductTaxApi {
    private IProductTaxService taxService;
    @Override
    public ResponseEntity<Optional<ProductTaxRequest>>
    find(@PathVariable Long id) {
        return taxService.find(id);
    }

    @Override
    public ResponseEntity<List<ProductTaxRequest>>
    findMany() {
        return taxService.findAll();
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>>
    save(@Valid @RequestBody ProductTaxRequest dto) {
        return taxService.save(dto);
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>>
    update(@Valid @RequestBody ProductTaxRequest request) {
        return taxService.update(request);
    }

    @Override
    public ResponseEntity<Optional<Boolean>>
    remove(@PathVariable Long id) {
        return taxService.remove(id);
    }

    @Override
    public ResponseEntity<Optional<Boolean>>
    toggleIsActiveStatus(@PathVariable Long id) {
        return taxService.toggleActiveStatus(id);
    }
}
