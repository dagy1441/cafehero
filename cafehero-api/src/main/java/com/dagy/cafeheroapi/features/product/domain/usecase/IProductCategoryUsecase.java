package com.dagy.cafeheroapi.features.product.domain.usecase;

import com.dagy.cafeheroapi.core.params.files.FileHandler;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductCategoryUsecase extends FileHandler<Map<String, String>, MultipartFile> {
    Optional<ProductCategory> findOne(Long id);

    Optional<ProductCategory> findOne(String name);

    List<ProductCategory> findAll();

    Optional<ProductCategory> save(ProductCategory category);

    Optional<Boolean> remove(Long id);

    List<ProductCategory> search(String term);

    Boolean toggleStatus(boolean b, Long id);


}
