package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.annotations.Interactor;
import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductTaxRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductTaxService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductTax;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductTaxUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Slf4j
@Interactor
@RequiredArgsConstructor
public class ProductTaxService implements IProductTaxService, Mapper<ProductTaxRequest, ProductTax> {

    private final IProductTaxUsecase usecase;
    private final ModelMapper mapper;
    @Override
    public ProductTaxRequest toRequest(ProductTax model) {
        return null;
    }

    @Override
    public ProductTax toModel(ProductTaxRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductTaxRequest>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>> save(ProductTaxRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>> find(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductTaxRequest>> update(ProductTaxRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id) {
        return null;
    }

    @Override
    public List<ProductTax> mapRequestListToModelList(List<ProductTaxRequest> requests) {
        return null;
    }
}
