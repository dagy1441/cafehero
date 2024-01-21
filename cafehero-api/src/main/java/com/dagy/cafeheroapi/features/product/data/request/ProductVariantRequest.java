package com.dagy.cafeheroapi.features.product.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVariantRequest {
    private Long id;

    @NotNull(message = "value cannot be empty")
    private String variantValue;

    @NotNull(message = "type cannot be empty")
    private String variantType;
}