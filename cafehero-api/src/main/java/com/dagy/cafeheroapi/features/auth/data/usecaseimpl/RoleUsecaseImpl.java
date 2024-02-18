package com.dagy.cafeheroapi.features.auth.data.usecaseimpl;

import com.dagy.cafeheroapi.core.annotations.Usecase;
import com.dagy.cafeheroapi.core.constants.Setting;
import com.dagy.cafeheroapi.features.auth.data.repository.RoleRepository;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;
import com.dagy.cafeheroapi.features.auth.domaine.entity.Role;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IPermissionUsecase;
import com.dagy.cafeheroapi.features.auth.domaine.usecase.IRoleUsecase;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.LongStream;

@Usecase
@RequiredArgsConstructor
public class RoleUsecaseImpl implements IRoleUsecase {
    private final RoleRepository repository;
    private final IPermissionUsecase usecase;

    @Override
    public Role save(Role role) {
        role.setPermissions(new HashSet<>(this.getFullPermissionObjectsFromRole(role)));
        return this.repository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return this.repository.findAll();
    }

    @Override
    public boolean isNotSystemRole(Role role) {
        return !role.getName().equals(Setting.DEFAULT_SYS_ROLE);
    }

    @Override
    public Optional<Role> getOne(Long id) {
        return this.repository.findById(id);
    }

    public boolean isRoleExist(Long id) {
        return this.getOne(id).isPresent();
    }

    @Override
    public Set<Permission> getRolePermissions(Long id) {
        Optional<Role> optional = this.getOne(id);
        return optional.map(Role::getPermissions).orElse(new HashSet<>());
    }

    @Override
    public Optional<Role> update(Role roleToUpdate) {
        Optional<Role> optionalRole = this.getOne(roleToUpdate.getId());
        return optionalRole.map(role -> mapRoleBeforeUpdate(roleToUpdate, role));
    }

    private Role mapRoleBeforeUpdate(Role roleToUpdate, Role existingRole) {
        existingRole.setName(roleToUpdate.getName());
        existingRole.setDescription(roleToUpdate.getDescription());
        existingRole.setPermissions(roleToUpdate.getPermissions());
        return this.save(existingRole);
    }


    @Override
    public Optional<Boolean> updateActiveStatus(Long id) {
        Optional<Role> optional = this.getOne(id);
        return optional.map(role -> this.updateRoleActiveStatus(role.getId(), !role.getIsActiveStatus()));
    }

    private Collection<Permission> getFullPermissionObjectsFromRole(Role role) {
        LongStream streamOfPermissionIds = role.getPermissions().stream().mapToLong(Permission::getId);
        return usecase.getPermissionsByIds(streamOfPermissionIds);
    }

    private Boolean updateRoleActiveStatus(Long id, Boolean status) {
        int result = this.repository.updateActiveStatus(status, id);
        return result == 1;
    }


}
