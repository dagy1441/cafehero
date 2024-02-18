package com.dagy.cafeheroapi.features.auth.domaine.usecase;

import com.dagy.cafeheroapi.features.auth.domaine.entity.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IUserUsecase {
    User save(User user);

    Optional<User> findOne(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> update(User user);

    Optional<Boolean> toggleActiveStatus(Long id);

    List<User> findMany();

    void checkDuplicateUsername(String username);

    List<String> findUserPermissionsNameOnly(User user);

    Boolean updateExpiryDate(Long userId, LocalDate date);

    Boolean updateRoles(Long userId, Collection<Long> rolesId);

    Boolean updatePassword(Long userId, String password);

    Boolean changeForgottenPassword(Long userId, String oldPassword, String newPassword );
}
