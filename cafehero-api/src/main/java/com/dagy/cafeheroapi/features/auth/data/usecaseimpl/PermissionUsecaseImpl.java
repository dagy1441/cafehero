package com.dagy.cafeheroapi.features.auth.data.usecaseimpl;

import com.dagy.cafeheroapi.core.annotations.Usecase;
import com.dagy.cafeheroapi.features.auth.data.repository.PermissionRepository;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IPermissionUsecase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@Usecase
@RequiredArgsConstructor
public class PermissionUsecaseImpl implements IPermissionUsecase {
    private final PermissionRepository repository;

    @Override
    public List<Permission> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Permission> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Collection<Permission> getPermissionsByIds(LongStream list) {
        List<Permission> permissions = new ArrayList<>();
        list.forEach(id -> this.getById(id).ifPresent(permissions::add));
        return permissions;
    }

}

