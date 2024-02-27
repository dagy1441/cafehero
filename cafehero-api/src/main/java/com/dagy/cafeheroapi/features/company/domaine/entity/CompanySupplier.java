package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import com.dagy.cafeheroapi.features.product.domain.entity.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_SUPPLIER;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_SUPPLIER)
public class CompanySupplier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierBusinessName;
    private String supplierFirstName;
    private String supplierLastName;
    private String supplierEmailAddress;
    private String supplierPhone;
    private String supplierOfficeAddress;

    @OneToMany
    @JoinTable
    private Set<ProductCategory> categories;

    public CompanySupplier(Long id) {
        this.id = id;
    }
}
