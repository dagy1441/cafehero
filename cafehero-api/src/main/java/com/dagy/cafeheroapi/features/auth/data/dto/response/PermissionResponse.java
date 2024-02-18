package com.dagy.cafeheroapi.features.auth.data.dto.response;

import com.dagy.cafeheroapi.features.auth.domaine.enums.AppModuleEnum;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionResponse {
    private Long id;
    private String name;
    private AppModuleEnum module;
}
