package com.dagy.cafeheroapi.features.product.data.request;

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
public class ProductDiscountRequest {
    private Long id;
    private Long productId;
    private Double discount;
    private String start;
    private String end;
}
