package com.dagy.cafeheroapi.features.product.data.request;

import com.dagy.cafeheroapi.core.params.DateRangeParam;
import com.dagy.cafeheroapi.core.params.MinMaxAmountParam;
import lombok.Data;

import java.util.List;

@Data
public class ProductSearchRequest {
    private Long id;
    private String productName;
    private String brandName;
    private String sku;
    private DateRangeParam dateRangeParam;
    private MinMaxAmountParam sellingPriceParam;
    private MinMaxAmountParam costPriceParam;
    private ProductCategoryRequest category;
    private List<ProductTaxRequest> taxes;
    private Boolean isService;
    private ProductStatusRequest status;
    private Boolean isActive;
    private String productOrBrandName;
    private List<ProductCategoryRequest> categories;
}

