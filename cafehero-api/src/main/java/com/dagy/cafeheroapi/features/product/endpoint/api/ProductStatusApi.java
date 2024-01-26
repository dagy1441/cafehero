package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductStatusRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/product-status")
public interface ProductStatusApi {
    @GetMapping(value = "get/{id}")
    public ResponseEntity<Optional<ProductStatusRequest>> find(@PathVariable Long id);
    @GetMapping("all")
    public ResponseEntity<List<ProductStatusRequest>> findMany();
    @PostMapping("create")
    public ResponseEntity<Optional<ProductStatusRequest>> save(@RequestBody @Valid ProductStatusRequest dto);

    @PutMapping("update")
    public ResponseEntity<Optional<ProductStatusRequest>> update(@RequestBody @Valid ProductStatusRequest request);

}
