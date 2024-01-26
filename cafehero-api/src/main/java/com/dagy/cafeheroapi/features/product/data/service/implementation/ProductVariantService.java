package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductVariantRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductVariantService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductVariant;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductVariantUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.dagy.cafeheroapi.core.constants.Exception.RECORD_NOT_FOUND;
import static com.dagy.cafeheroapi.core.constants.Exception.REQUIRED_ID;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
//@Interactor
@Service
@RequiredArgsConstructor
public class ProductVariantService implements IProductVariantService, Mapper<ProductVariantRequest, ProductVariant> {

    private final IProductVariantUsecase usecase;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<ProductVariantRequest> save(ProductVariantRequest request) {
        var model = this.usecase.save(toModel(request));
        return ResponseEntity.ok().body(toRequest(model));
    }

    @Override
    public ResponseEntity<List<ProductVariantRequest>> findAll() {
        var all = this.usecase.findAll();
        var requestList = all.stream().map(this::toRequest).collect(Collectors.toList());
        return ResponseEntity.ok().body(requestList);
    }

    @Override
    public ResponseEntity<ProductVariantRequest> findOne(Long id) {
        var optional = this.usecase.findOne(id);
        return optional
                .map(model -> ResponseEntity.ok(toRequest(model)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ProductVariantRequest> update(ProductVariantRequest request) {
        this.throwIfRequestNotValid(request);
        return this.save(request);
    }

    @Override
    public ProductVariantRequest toRequest(ProductVariant model) {
        return mapper.map(model, ProductVariantRequest.class);
    }

    @Override
    public ProductVariant toModel(ProductVariantRequest request) {
        return mapper.map(request, ProductVariant.class);
    }

    private void throwIfRequestNotValid(ProductVariantRequest request) {
        if (ObjectUtils.isEmpty(request.getId())) {
            throw new ResponseStatusException(BAD_REQUEST, REQUIRED_ID);
        }

        if (!this.findOne(request.getId()).getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(NOT_FOUND, RECORD_NOT_FOUND);
        }
    }
}
