package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.product.data.request.ProductDiscountRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductSearchRequest;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    ResponseEntity<ProductRequest> save(ProductRequest request);

    ResponseEntity<PageSearchResult<List<ProductRequest>>> search(PageSearchRequest<ProductSearchRequest> request);

    ResponseEntity<List<ProductRequest>> search(String term);

    //ResponseEntity<Optional<ProductRequest>> setPrice(Long productId, StockPriceRequest priceRequest);

    ResponseEntity<Optional<ProductRequest>> setQuantity(Long id, Integer quantity);

    ResponseEntity<PageSearchResult<List<ProductRequest>>> searchSalesProduct(PageSearchRequest<ProductSearchRequest> request);

    ResponseEntity<Boolean> setDiscount(ProductDiscountRequest discountRequest);

    //    ResponseEntity<Map<String, Object>> uploadTemplate(MultipartFile file);
    ResponseEntity<?> uploadTemplate(MultipartFile file);

    ResponseEntity<Resource> downloadTemplate() throws IOException;
}
