package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.product.data.request.ProductDiscountRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductSearchRequest;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductApi;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements ProductApi {
    @Override
    public ResponseEntity<ProductRequest> create(ProductRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchProducts(PageSearchRequest<ProductSearchRequest> request) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> setDiscount(ProductDiscountRequest discountRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<ProductRequest>> setQuantity(Long id, Integer quantity) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductRequest>> search(String term) {
        return null;
    }

    @Override
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchSalesProducts(PageSearchRequest<ProductSearchRequest> request) {
        return null;
    }

    @Override
    public ResponseEntity<?> uploadBatchService(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public ResponseEntity<Resource> downloadFile() throws IOException {
        return null;
    }
}
