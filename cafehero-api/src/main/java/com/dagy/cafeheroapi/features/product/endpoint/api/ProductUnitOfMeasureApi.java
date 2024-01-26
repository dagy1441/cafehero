package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductUnitOfMeasureRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/product/unit-of-measurement")
public interface ProductUnitOfMeasureApi {
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> find(@PathVariable Long id);
    @GetMapping("/all")
    public ResponseEntity<List<ProductUnitOfMeasureRequest>> findMany();
    @PostMapping("/create")
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> save(
            @RequestBody @Valid ProductUnitOfMeasureRequest dto
    );
    @PutMapping("/update")
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> update(
            @RequestBody @Valid ProductUnitOfMeasureRequest dto
    );
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id);
}
