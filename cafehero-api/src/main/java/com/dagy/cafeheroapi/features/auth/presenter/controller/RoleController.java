package com.dagy.cafeheroapi.features.auth.presenter.controller;

import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.RoleResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.RoleRequest;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.IRoleService;
import com.dagy.cafeheroapi.features.auth.presenter.api.RoleEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RoleController implements RoleEndpoint {
    private final IRoleService roleService;
    @Override
    public ResponseEntity<RoleResponse> create(RoleRequest role) {
        return roleService.create(role);
    }

    @Override
    public ResponseEntity<List<RoleResponse>> getAll() {
        return roleService.getAll();
    }

    @Override
    public ResponseEntity<Optional<RoleResponse>> getOne(Long id) {
        return roleService.getOne(id);
    }

    @Override
    public ResponseEntity<List<PermissionResponse>> getRolePermissions(Long id) {
        return roleService.getRolePermissions(id);
    }

    @Override
    public ResponseEntity<Optional<RoleResponse>> update(RoleRequest request) {
        return roleService.update(request);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> updateActiveStatus(Long id) {
        return roleService.updateActiveStatus(id);
    }
}
