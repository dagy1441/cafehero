package com.dagy.cafeheroapi.core.params;

import lombok.Data;

@Data
public class MinMaxAmountParam {
    private Double minAmount;
    private Double maxAmount;
    private Double fixedAmount;
    private Boolean isRange;
}