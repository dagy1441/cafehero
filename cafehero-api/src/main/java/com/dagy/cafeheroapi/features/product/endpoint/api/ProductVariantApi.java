package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductVariantRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/product-variant")
public interface ProductVariantApi {
    @GetMapping("/{id}")
    public ResponseEntity<ProductVariantRequest> findOne(@PathVariable Long id);
    @PostMapping
    public ResponseEntity<ProductVariantRequest> save(@RequestBody @Valid ProductVariantRequest request);
    @GetMapping
    public ResponseEntity<List<ProductVariantRequest>> findAll();
    @PutMapping
    public ResponseEntity<ProductVariantRequest> update(@RequestBody @Valid ProductVariantRequest request);
}
