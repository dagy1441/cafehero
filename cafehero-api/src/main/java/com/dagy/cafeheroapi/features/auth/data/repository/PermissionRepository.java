package com.dagy.cafeheroapi.features.auth.data.repository;

import com.dagy.cafeheroapi.features.auth.domaine.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
