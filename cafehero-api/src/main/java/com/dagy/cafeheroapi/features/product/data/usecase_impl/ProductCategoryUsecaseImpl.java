package com.dagy.cafeheroapi.features.product.data.usecase_impl;

import com.dagy.cafeheroapi.core.annotations.Usecase;
import com.dagy.cafeheroapi.core.constants.enums.Template;
import com.dagy.cafeheroapi.features.product.data.repository.ProductCategoryRepository;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductCategoryUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Usecase
@RequiredArgsConstructor
public class ProductCategoryUsecaseImpl implements IProductCategoryUsecase {
    public static final String DUPLICATE = "CATEGORY WITH SAME TITLE ALREADY EXIST";
    private final ProductCategoryRepository repository;
    @Override
    public Resource downloadTemplate(Template template) {
        return null;
    }

    @Override
    public Map<String, String> uploadTemplate(MultipartFile input) {
        return null;
    }

    @Override
    public Optional<ProductCategory> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductCategory> findOne(String name) {
        return Optional.empty();
    }

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public Optional<ProductCategory> save(ProductCategory category) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> remove(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductCategory> search(String term) {
        return null;
    }

    @Override
    public Boolean toggleStatus(boolean b, Long id) {
        return null;
    }
}
