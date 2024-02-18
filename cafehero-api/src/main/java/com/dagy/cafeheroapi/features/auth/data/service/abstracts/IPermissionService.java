package com.dagy.cafeheroapi.features.auth.data.service.abstracts;

import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionGroupResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    ResponseEntity<List<PermissionResponse>> getAll();

    ResponseEntity<Optional<PermissionResponse>> getOne(Long id);

    ResponseEntity<List<PermissionGroupResponse>> getAllGroupedByModule();
}
