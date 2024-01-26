package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductTaxRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/product/tax")
public interface ProductTaxApi {
    @GetMapping(value = "get/{id}")
    public ResponseEntity<Optional<ProductTaxRequest>> find(@PathVariable Long id);
    @GetMapping("all")
    public ResponseEntity<List<ProductTaxRequest>> findMany();
    @PostMapping("create")
    public ResponseEntity<Optional<ProductTaxRequest>> save(
            @RequestBody @Valid ProductTaxRequest dto
    );
    @PutMapping("update")
    public ResponseEntity<Optional<ProductTaxRequest>> update(
            @RequestBody @Valid ProductTaxRequest request
    );
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id);
    @PutMapping("status/{id}")
    public ResponseEntity<Optional<Boolean>> toggleIsActiveStatus(@PathVariable Long id);
}
