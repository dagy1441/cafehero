package com.dagy.cafeheroapi.features.auth.data.dto.response;

import com.dagy.cafeheroapi.features.auth.data.dto.resquest.RoleRequest;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleResponse {
    private Long id;
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private String description;
    private List<PermissionResponse> permissions;
    private String createdAt;
    private Boolean isActiveStatus;

    public static RoleRequest toPartialRequest(Role role) {
        RoleRequest request = new RoleRequest();
        request.setId(role.getId());
        request.setName(role.getName());
        request.setDescription(role.getDescription());
        return request;
    }
}
