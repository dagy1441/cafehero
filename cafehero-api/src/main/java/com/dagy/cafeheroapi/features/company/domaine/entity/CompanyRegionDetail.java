package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_REGION_DETAILS;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_REGION_DETAILS)
public class CompanyRegionDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String setupKey;
    private String setupValue;


    public CompanyRegionDetail(String setupKey, String setupValue) {
        this.setSetupKey(setupKey);
        this.setSetupValue(setupValue);
    }
}
