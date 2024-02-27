package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_EMPLOYEE_NOK_DETAIL;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_EMPLOYEE_NOK_DETAIL)
public class CompanyEmployeeNokDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nokFullName;
    private String nokAddress;
    private String nokEmail;
    private String nokPhone;
    private String nokRelationship;
}
