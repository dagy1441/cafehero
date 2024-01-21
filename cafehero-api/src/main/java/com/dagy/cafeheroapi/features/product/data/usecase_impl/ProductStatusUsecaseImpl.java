package com.dagy.cafeheroapi.features.product.data.usecase_impl;

import com.dagy.cafeheroapi.core.annotations.Usecase;
import com.dagy.cafeheroapi.features.product.data.repository.ProductStatusRepository;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductStatus;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductStatusUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.of;
import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@Usecase
@RequiredArgsConstructor
public class ProductStatusUsecaseImpl implements IProductStatusUsecase {
    private static final String DUPLICATE_RECORD = "DUPLICATE RECORD, SIMILAR RECORD EXIST";
    private final ProductStatusRepository repository;
    @Override
    public List<ProductStatus> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<ProductStatus> save(ProductStatus model) {
        this.throwIfDuplicateExist(model);
        return of(this.repository.save(model));
    }

    @Override
    public Optional<Boolean> remove(Long id) {
        Optional<ProductStatus> optional = this.findOne(id);
        return this.removeIfPresentAndHasNoProduct(optional);
    }

    @Override
    public Optional<ProductStatus> findOne(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<ProductStatus> findOne(String name) {
        return this.repository.findByTitleEqualsIgnoreCase(name);
    }

    private void throwIfDuplicateExist(ProductStatus model) {
        Optional<ProductStatus> optional = this.repository.findByTitleEqualsIgnoreCase(
                model.getTitle()
        );

        optional.ifPresent(e -> {
            throw new ResponseStatusException(CONFLICT, DUPLICATE_RECORD);
        });
    }

    private Optional<Boolean> removeIfPresentAndHasNoProduct(Optional<ProductStatus> optional) {
        return optional.map(this::removeIfNoProducts).orElse(of(Boolean.FALSE));
    }

    private Optional<Boolean> removeIfNoProducts(ProductStatus model) {
        // todo:: implement soft delete
		/*
		if (model.getProducts().size() > 0) {
			return of(Boolean.FALSE);
		}
		 */
        return this.delete(model);
    }

    private Optional<Boolean> delete(ProductStatus model) {
        try {
            this.repository.delete(model);
            return Optional.of(Boolean.TRUE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.of(Boolean.FALSE);
        }
    }
}
