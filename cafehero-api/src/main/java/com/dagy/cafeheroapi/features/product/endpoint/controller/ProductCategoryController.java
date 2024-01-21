package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductCategoryApi;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductCategoryController implements ProductCategoryApi {
    @Override
    public ResponseEntity<ProductCategoryRequest> find(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductCategoryRequest>> findMany() {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductCategoryRequest>> save(ProductCategoryRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductCategoryRequest>> update(ProductCategoryRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductCategoryRequest>> search(String term) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Boolean>> toggleIsActiveStatus(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Resource> downloadFile() throws IOException {
        return null;
    }

    @Override
    public ResponseEntity<?> uploadBatchCategories(MultipartFile file) {
        return null;
    }
}
