package com.dagy.cafeheroapi.features.product.data.request.specification;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCategorySpecification {
    public static Specification<ProductCategory> byTitle(final String term) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
