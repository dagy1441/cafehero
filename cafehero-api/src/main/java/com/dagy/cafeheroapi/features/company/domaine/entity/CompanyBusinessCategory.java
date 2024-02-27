package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_BUSINESS_CATEGORY_TABLE;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_BUSINESS_CATEGORY_TABLE)
public class CompanyBusinessCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;

    public CompanyBusinessCategory(String title) {
        this.title = title;
    }
}
