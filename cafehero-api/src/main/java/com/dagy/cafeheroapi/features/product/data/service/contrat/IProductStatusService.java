package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.features.product.data.request.ProductStatusRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductStatusService {
    ResponseEntity<List<ProductStatusRequest>> findAll();

    ResponseEntity<Optional<ProductStatusRequest>> save(ProductStatusRequest request);

    ResponseEntity<Optional<Boolean>> remove(Long id);

    ResponseEntity<Optional<ProductStatusRequest>> find(Long id);

    ResponseEntity<Optional<ProductStatusRequest>> update(ProductStatusRequest request);
}
