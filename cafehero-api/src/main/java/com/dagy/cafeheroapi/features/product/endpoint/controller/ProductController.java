package com.dagy.cafeheroapi.features.product.endpoint.controller;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.product.data.request.ProductDiscountRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductSearchRequest;
import com.dagy.cafeheroapi.features.product.data.service.contrat.IProductService;
import com.dagy.cafeheroapi.features.product.data.service.implementation.ProductService;
import com.dagy.cafeheroapi.features.product.endpoint.api.ProductApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {
    private final IProductService productService;
    @Override
    public ResponseEntity<ProductRequest> create(@Valid @RequestBody ProductRequest request) {
        return productService.save(request);
    }

    @Override
    public ResponseEntity<PageSearchResult<List<ProductRequest>>>
    searchProducts(@Valid @RequestBody PageSearchRequest<ProductSearchRequest> request) {
        return productService.search(request);
    }

//    @Override
//    public ResponseEntity<Optional<ProductRequest>> setPrice(
//            @PathVariable Long id, @RequestBody StockPriceRequest price
//    ) {
//        return this.productService.setPrice(id, price);
//    }

    @Override
    public ResponseEntity<Boolean>
    setDiscount(@RequestBody ProductDiscountRequest discountRequest) {
        return productService.setDiscount(discountRequest);
    }

    @Override
    public ResponseEntity<Optional<ProductRequest>>
    setQuantity(
            @PathVariable Long id,
            @PathVariable Integer quantity
    ) {
        return productService.setQuantity(id, quantity);
    }

    @Override
    public ResponseEntity<List<ProductRequest>>
    search(@RequestParam(value = "term") String term) {
        return productService.search(term);
    }

    @Override
    public ResponseEntity<PageSearchResult<List<ProductRequest>>>
    searchSalesProducts(@Valid @RequestBody PageSearchRequest<ProductSearchRequest> request) {
        return productService.searchSalesProduct(request);
    }

    @Override
    public ResponseEntity<?> uploadBatchService(@RequestParam("file") MultipartFile file) throws IOException {
        return productService.uploadTemplate(file);
    }

    @Override
    public ResponseEntity<Resource> downloadFile() throws IOException {
        return productService.downloadTemplate();
    }
}
