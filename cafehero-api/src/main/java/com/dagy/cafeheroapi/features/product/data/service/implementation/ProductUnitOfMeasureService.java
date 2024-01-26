package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductUnitOfMeasureRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductUnitOfMeasureService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductUnitOfMeasure;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductUnitOfMeasureUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dagy.cafeheroapi.core.constants.Exception.RECORD_NOT_FOUND;
import static com.dagy.cafeheroapi.core.constants.Exception.REQUIRED_ID;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
//@Interactor
@Service
@RequiredArgsConstructor
public class ProductUnitOfMeasureService implements IProductUnitOfMeasureService, Mapper<ProductUnitOfMeasureRequest, ProductUnitOfMeasure> {

    private final IProductUnitOfMeasureUsecase usecase;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<List<ProductUnitOfMeasureRequest>> findAll() {
        List<ProductUnitOfMeasure> modelList = usecase.findAll();
        List<ProductUnitOfMeasureRequest> requestList = modelList.stream().map(this::toRequest).collect(Collectors.toList());
        return ok(requestList);
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> save(ProductUnitOfMeasureRequest request) {
        Optional<ProductUnitOfMeasure> save = this.usecase.save(toModel(request));
        return ok(save.map(this::toRequest));
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        return ok(this.usecase.remove(id));
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> find(Long id) {
        Optional<ProductUnitOfMeasure> optional = this.usecase.findOne(id);
        return ok(optional.map(this::toRequest));
    }

    @Override
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> update(ProductUnitOfMeasureRequest request) {
        this.throwIfRequestNotValid(request);
        return this.save(request);
    }

    @Override
    public ProductUnitOfMeasureRequest toRequest(ProductUnitOfMeasure model) {
        return this.mapper.map(model, ProductUnitOfMeasureRequest.class);
    }

    @Override
    public ProductUnitOfMeasure toModel(ProductUnitOfMeasureRequest request) {
        return this.mapper.map(request, ProductUnitOfMeasure.class);
    }

    private void throwIfRequestNotValid(ProductUnitOfMeasureRequest request) {
        if (ObjectUtils.isEmpty(request.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, REQUIRED_ID);
        }

        if (!this.find(request.getId()).getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(NOT_FOUND, RECORD_NOT_FOUND);
        }
    }
}
