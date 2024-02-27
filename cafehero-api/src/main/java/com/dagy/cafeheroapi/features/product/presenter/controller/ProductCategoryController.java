package com.dagy.cafeheroapi.features.product.presenter.controller;

import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductCategoryService;
import com.dagy.cafeheroapi.features.product.presenter.api.ProductCategoryApi;
import org.springframework.core.io.Resource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductCategoryController implements ProductCategoryApi {
    private final IProductCategoryService categoryService;

    @Override
    public ResponseEntity<ProductCategoryRequest> find(@PathVariable Long id) {
        return this.categoryService.find(id);
    }

    @Override
    public ResponseEntity<List<ProductCategoryRequest>> findMany() {
        return categoryService.findMany();
    }

    @Override
    public ResponseEntity<Optional<ProductCategoryRequest>> save(@RequestBody @Valid ProductCategoryRequest dto) {
        return categoryService.save(dto);
    }

    @Override
    public ResponseEntity<Optional<ProductCategoryRequest>> update(ProductCategoryRequest dto) {
        return this.categoryService.update(dto);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id) {
        return this.categoryService.remove(id);
    }

    @Override
    public ResponseEntity<List<ProductCategoryRequest>> search(@RequestParam(value = "term")String term) {
        return this.categoryService.search(term);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> toggleIsActiveStatus(@PathVariable Long id) {

        return this.categoryService.toggleActiveStatus(id);
    }

    @Override
    public ResponseEntity<Resource> downloadFile() throws IOException {
        return this.categoryService.downloadTemplate();
    }

    @Override
    public ResponseEntity<?> uploadBatchCategories(@RequestParam("file") MultipartFile file) {
        return this.categoryService.uploadTemplate(file);
    }
}
