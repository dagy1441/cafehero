package com.dagy.cafeheroapi.features.auth.presenter.controller;

import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionGroupResponse;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.IPermissionService;
import com.dagy.cafeheroapi.features.auth.presenter.api.PermissionsEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PermissionsController implements PermissionsEndpoint {
    private final IPermissionService permissionService;
    @Override
    public ResponseEntity<List<PermissionGroupResponse>> getAllPermissionsGroupedByModule() {
        log.info("------------ CONTROLLER ---------------");
        return permissionService.getAllGroupedByModule();
    }
}
