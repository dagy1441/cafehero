package com.dagy.cafeheroapi.features.product.data.request;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductStatus;
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
public class ProductStatusRequest {
    private Long id;
    private String title;
    private String description;
    private Boolean isActiveStatus;

    public ProductStatus toModel() {
        return new ProductStatus(this.id);
    }
}