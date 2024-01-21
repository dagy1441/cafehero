package com.dagy.cafeheroapi.features.product.data.request;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCategoryRequest {
    private Long id;

    @NotNull(message = "Title cannot be empty")
    private String title;
    private String description;
    private ProductCategoryRequest parent;
    private Boolean isActiveStatus;
    private String createdAt;

    public ProductCategory toModel() {
        return new ProductCategory(this.id);
    }
}
