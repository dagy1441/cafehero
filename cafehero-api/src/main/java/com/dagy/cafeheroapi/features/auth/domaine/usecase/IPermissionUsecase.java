package com.dagy.cafeheroapi.features.auth.domaine.usecase;

import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public interface IPermissionUsecase {
    List<Permission> getAll();

    Optional<Permission> getById(Long id);

    Collection<Permission> getPermissionsByIds(LongStream list);
}
