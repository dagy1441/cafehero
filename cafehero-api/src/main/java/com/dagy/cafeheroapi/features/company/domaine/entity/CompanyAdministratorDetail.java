package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_ADMIN_DETAILS;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_ADMIN_DETAILS)
public class CompanyAdministratorDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String setupKey;
    private String setupValue;

    public CompanyAdministratorDetail(String setupKey, String setupValue) {
        this.setupKey = setupKey;
        this.setupValue = setupValue;
    }
}
