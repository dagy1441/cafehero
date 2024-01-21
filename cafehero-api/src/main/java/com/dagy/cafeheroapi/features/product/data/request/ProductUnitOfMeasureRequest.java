package com.dagy.cafeheroapi.features.product.data.request;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductUnitOfMeasure;
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
public class ProductUnitOfMeasureRequest {
    private Long id;
    private String title;
    private String unit;
    private Boolean isActiveStatus;

    public ProductUnitOfMeasure toModel() {
        return new ProductUnitOfMeasure(this.id);
    }
}
