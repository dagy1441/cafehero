package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.features.product.data.request.ProductTaxRequest;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductTax;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductTaxService {
    ResponseEntity<List<ProductTaxRequest>> findAll();

    ResponseEntity<Optional<ProductTaxRequest>> save(ProductTaxRequest request);

    ResponseEntity<Optional<Boolean>> remove(Long id);

    ResponseEntity<Optional<ProductTaxRequest>> find(Long id);

    ResponseEntity<Optional<ProductTaxRequest>> update(ProductTaxRequest request);

    ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id);

    List<ProductTax> mapRequestListToModelList(List<ProductTaxRequest> requests);
}
