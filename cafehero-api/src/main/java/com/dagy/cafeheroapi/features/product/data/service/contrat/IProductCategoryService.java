package com.dagy.cafeheroapi.features.product.data.service.contrat;

import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IProductCategoryService {
    ResponseEntity<ProductCategoryRequest> find(Long id);

    ResponseEntity<List<ProductCategoryRequest>> findMany();

    ResponseEntity<Optional<ProductCategoryRequest>> save(ProductCategoryRequest request);

    ResponseEntity<Optional<ProductCategoryRequest>> update(ProductCategoryRequest request);

    ResponseEntity<Optional<Boolean>> remove(Long id);

    ResponseEntity<List<ProductCategoryRequest>> search(String term);

    ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id);

    ResponseEntity<Resource> downloadTemplate() throws IOException;

    ResponseEntity<?> uploadTemplate(MultipartFile file);
}
