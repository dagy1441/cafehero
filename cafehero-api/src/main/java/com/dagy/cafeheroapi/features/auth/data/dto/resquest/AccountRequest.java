package com.dagy.cafeheroapi.features.auth.data.dto.resquest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountRequest {
    private Long id;
    private Long employeeId;
    private Long userId;
    private String name;
    private String phone;
    private String username;
    private String password;
    private Collection<RoleRequest> roles;
    private Boolean isActiveStatus;
    private String expiryDate;
}
