package com.dagy.cafeheroapi.features.auth.data.repository;

import com.dagy.cafeheroapi.features.auth.domaine.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Transactional
    @Modifying
    @Query(value = "update Role r set r.isActiveStatus = :status where r.id = :id")
    int updateActiveStatus(@Param("status") Boolean status, @Param("id") Long id);

    Optional<Role> findByNameEqualsIgnoreCase(String name);
}
