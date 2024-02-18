package com.dagy.cafeheroapi.features.auth.data.service.abstracts;

import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.RoleResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.RoleRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    ResponseEntity<RoleResponse> create(RoleRequest request);

    ResponseEntity<List<RoleResponse>> getAll();

    ResponseEntity<Optional<RoleResponse>> getOne(Long id);

    ResponseEntity<List<PermissionResponse>> getRolePermissions(Long id);

    ResponseEntity<Optional<RoleResponse>> update(RoleRequest request);

    ResponseEntity<Optional<Boolean>> updateActiveStatus(Long id);
}
