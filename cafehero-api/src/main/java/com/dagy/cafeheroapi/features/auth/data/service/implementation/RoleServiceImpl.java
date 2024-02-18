package com.dagy.cafeheroapi.features.auth.data.service.implementation;

import com.dagy.cafeheroapi.core.mapper.IMapper;
import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.RoleResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.RoleRequest;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.IRoleService;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Role;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IRoleUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService, IMapper<RoleResponse, RoleRequest, Role> {
    private final IRoleUsecase usecase;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<RoleResponse> create(RoleRequest request) {
        Role role = this.usecase.save(this.toModel(request));
        return ok().body(toResponse(toRequest(role)));
    }

    @Override
    public ResponseEntity<List<RoleResponse>> getAll() {
        List<Role> roles = this.usecase.getAll();
        List<RoleResponse> responses = roles.stream()
                .filter(this.usecase::isNotSystemRole)
                .map((Role request) -> toResponse(toRequest(request)))
                .collect(Collectors.toList());
        return ok().body(responses);
    }

    @Override
    public ResponseEntity<Optional<RoleResponse>> getOne(Long id) {
        Optional<Role> optional = this.usecase.getOne(id);
        return ok().body(optional.map((Role request) -> toResponse(toRequest(request))));
    }

    @Override
    public ResponseEntity<List<PermissionResponse>> getRolePermissions(Long id) {
        Set<Permission> permissions = this.usecase.getRolePermissions(id);
        List<PermissionResponse> permissionResponses = permissions.stream()
                .map(this::toPermissionResponse).collect(Collectors.toList());
        return ok().body(permissionResponses);
    }

    @Override
    public ResponseEntity<Optional<RoleResponse>> update(RoleRequest request) {
        Role model = toModel(request);
        Optional<Role> optional = this.usecase.update(model);
        return ok().body(optional.map((Role r) -> toResponse(toRequest(r))));
    }

    @Override
    public ResponseEntity<Optional<Boolean>> updateActiveStatus(Long id) {
        return ok().body(this.usecase.updateActiveStatus(id));
    }

    @Override
    public RoleRequest toRequest(Role model) {
        return this.mapper.map(model, RoleRequest.class);
    }

    @Override
    public RoleResponse toResponse(RoleRequest request) {
        return this.mapper.map(request, RoleResponse.class);
    }

    @Override
    public Role toModel(RoleRequest request) {
        return this.mapper.map(request, Role.class);
    }

    private PermissionResponse toPermissionResponse(Permission permission) {
        return this.mapper.map(permission, PermissionResponse.class);
    }
}

