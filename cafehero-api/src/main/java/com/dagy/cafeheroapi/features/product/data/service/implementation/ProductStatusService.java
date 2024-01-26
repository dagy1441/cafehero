package com.dagy.cafeheroapi.features.product.data.service.implementation;

import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.product.data.request.ProductStatusRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductStatusService;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductStatus;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductStatusUsecase;
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
public class ProductStatusService implements IProductStatusService, Mapper<ProductStatusRequest, ProductStatus> {

    private final IProductStatusUsecase usecase;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<List<ProductStatusRequest>> findAll() {
        List<ProductStatus> modelList = usecase.findAll();
        List<ProductStatusRequest> requestList = modelList.stream().map(this::toRequest).collect(Collectors.toList());
        return ok(requestList);
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> save(ProductStatusRequest request) {
        Optional<ProductStatus> save = this.usecase.save(toModel(request));
        return ok(save.map(this::toRequest));
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        return ok(this.usecase.remove(id));
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> find(Long id) {
        Optional<ProductStatus> optional = this.usecase.findOne(id);
        return ok(optional.map(this::toRequest));
    }

    @Override
    public ResponseEntity<Optional<ProductStatusRequest>> update(ProductStatusRequest request) {
        this.throwIfRequestNotValid(request);
        return this.save(request);
    }

    @Override
    public ProductStatusRequest toRequest(ProductStatus model) {
        return this.mapper.map(model, ProductStatusRequest.class);
    }

    @Override
    public ProductStatus toModel(ProductStatusRequest request) {
        return this.mapper.map(request, ProductStatus.class);
    }

    private void throwIfRequestNotValid(ProductStatusRequest request) {
        if (ObjectUtils.isEmpty(request.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, REQUIRED_ID);
        }

        if (!this.find(request.getId()).getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(NOT_FOUND, RECORD_NOT_FOUND);
        }
    }
}
