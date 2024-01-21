package com.dagy.cafeheroapi.features.product.data.request;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductTax;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTaxRequest {
    private Long id;
    private String title;
    private String description;
    private Double percent;
    private Boolean isActiveStatus;

    public static ProductTax toModel(ProductTaxRequest request) {
        ProductTax productTax = new ProductTax();
        productTax.setId(request.getId());
        productTax.setTitle(request.getTitle());
        productTax.setPercent(request.getPercent());
        productTax.setDescription(request.getDescription());
        productTax.setIsActiveStatus(request.getIsActiveStatus());
        return productTax;
    }
}