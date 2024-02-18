package com.dagy.cafeheroapi.features.auth.domaine.usecase;

import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IRoleUsecase {
    Role save(Role role);

    List<Role> getAll();

    boolean isNotSystemRole(Role role);

    Optional<Role> getOne(Long id);

    Set<Permission> getRolePermissions(Long id);

    Optional<Role> update(Role role);

    Optional<Boolean> updateActiveStatus(Long id);
}
