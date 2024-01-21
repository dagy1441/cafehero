package com.dagy.cafeheroapi.core.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRangeParam {
    private LocalDate startDate;
    private LocalDate endDate;
}