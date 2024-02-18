package com.dagy.cafeheroapi.features.auth.data.dto.response;

import com.dagy.cafeheroapi.features.auth.domaine.enums.AppModuleEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionGroupResponse {
    private AppModuleEnum module;
    private List<PermissionResponse> permissions;

}
