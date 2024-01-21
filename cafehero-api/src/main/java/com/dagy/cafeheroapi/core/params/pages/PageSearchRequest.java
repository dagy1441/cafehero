package com.dagy.cafeheroapi.core.params.pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageSearchRequest<T> {
    @NotNull(message = "page payload cannot be null")
    private PageParam page;

    @NotNull(message = "search parameter cannot be null")
    private T searchRequest;
}
