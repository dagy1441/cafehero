package com.dagy.cafeheroapi.core.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ErrorDTO {

        private String field;
        private String errorMessage;
    }

