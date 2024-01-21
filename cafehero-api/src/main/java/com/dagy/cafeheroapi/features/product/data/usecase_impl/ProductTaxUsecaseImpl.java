package com.dagy.cafeheroapi.features.product.data.usecase_impl;

import com.dagy.cafeheroapi.core.annotations.Usecase;
import com.dagy.cafeheroapi.features.product.data.repository.ProductTaxRepository;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductTax;
import com.dagy.cafeheroapi.features.product.domain.usecase.IProductTaxUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import static java.util.Optional.of;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Usecase
@RequiredArgsConstructor
public class ProductTaxUsecaseImpl implements IProductTaxUsecase {
    private static final String DUPLICATE_RECORD = "DUPLICATE RECORD, SIMILAR RECORD EXIST";
    private final ProductTaxRepository repository;
    @Override
    public List<ProductTax> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<ProductTax> save(ProductTax productTax) {
        this.throwIfDuplicateExist(productTax);
        return of(this.repository.save(productTax));
    }

    @Override
    public Optional<Boolean> remove(Long id) {
        Optional<ProductTax> optional = this.findOne(id);
        return this.removeIfPresentAndHasNoProduct(optional);
    }

    @Override
    public Optional<ProductTax> findOne(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<ProductTax> findOne(String name) {
        return this.repository.findByTitleEqualsIgnoreCase(name);
    }

    @Override
    public Boolean toggleStatus(boolean status, Long id) {
        int count = this.repository.updateIsActiveStatus(status ? Boolean.TRUE : Boolean.FALSE, id);
        return count == 1;
    }

    private void throwIfDuplicateExist(ProductTax model) {
        if (isEmpty(model.getId())) {
            Optional<ProductTax> optional = this.repository.findByTitleEqualsIgnoreCaseAndPercent(
                    model.getTitle(), model.getPercent());

            optional.ifPresent(e -> {
                throw new ResponseStatusException(CONFLICT, DUPLICATE_RECORD);
            });
        }
    }

    private Optional<Boolean> removeIfPresentAndHasNoProduct(Optional<ProductTax> optional) {
        return optional.map(this::removeIfNoProducts).orElse(of(Boolean.FALSE));
    }

    private Optional<Boolean> removeIfNoProducts(ProductTax model) {
        // todo:: implement soft delete
        return this.delete(model);
    }

    private Optional<Boolean> delete(ProductTax model) {
        try {
            this.repository.delete(model);
            return Optional.of(Boolean.TRUE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.of(Boolean.FALSE);
        }
    }
}
