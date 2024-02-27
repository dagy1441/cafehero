package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_BASIC_DETAILS;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = COMPANY_BASIC_DETAILS)
@EqualsAndHashCode(callSuper = true)
public class CompanyBasicDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String setupKey;
    private String setupValue;

    public CompanyBasicDetail(String setupKey, String setupValue) {
        this.setupKey = setupKey;
        this.setupValue = setupValue;
    }
}
