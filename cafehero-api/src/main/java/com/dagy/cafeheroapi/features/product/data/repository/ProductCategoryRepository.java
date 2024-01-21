package com.dagy.cafeheroapi.features.product.data.repository;

import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Long> {
    Optional<ProductCategory> findByTitle(String title);

    List<ProductCategory> findAllByTitleContainsIgnoreCase(String title);

    @Transactional
    @Modifying
    @Query(value = "update ProductCategory c set c.isActiveStatus = :status where c.id = :id")
    int updateIsActiveStatus(@Param(value = "status") Boolean status, @Param(value = "id") Long id);
}
