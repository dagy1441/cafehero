package com.dagy.cafeheroapi.features.auth.data.service.implementation;

import com.dagy.cafeheroapi.core.mapper.Mapper;
import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionGroupResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionResponse;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.IPermissionService;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IPermissionUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService,Mapper<PermissionResponse, Permission> {
    private final IPermissionUsecase usecase;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<List<PermissionResponse>> getAll() {
        List<Permission> permissions = this.usecase.getAll();
        return ok().body(permissions.stream().map(this::toRequest).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Optional<PermissionResponse>> getOne(Long id) {
        Optional<Permission> optional = this.usecase.getById(id);
        return ok().body(optional.map(this::toRequest));
    }

    @Override
    public PermissionResponse toRequest(Permission model) {
        return this.mapper.map(model, PermissionResponse.class);
    }

    @Override
    public Permission toModel(PermissionResponse request) {
        return this.mapper.map(request, Permission.class);
    }

    @Override
    public ResponseEntity<List<PermissionGroupResponse>> getAllGroupedByModule() {
        List<Permission> permissions = this.usecase.getAll();
        List<PermissionGroupResponse> collect = permissions.stream()
                .map(this::toRequest)
                .collect(Collectors.groupingBy(PermissionResponse::getModule))
                .entrySet()
                .stream()
                .map(entry -> new PermissionGroupResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return ok().body(collect);
    }
}
