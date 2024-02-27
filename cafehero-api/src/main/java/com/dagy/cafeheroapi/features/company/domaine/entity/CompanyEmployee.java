package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import com.dagy.cafeheroapi.features.auth.domaine.entity.User;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_EMPLOYEE;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_EMPLOYEE)
public class CompanyEmployee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CompanyEmployeePersonalDetail personalDetail;

    @OneToOne
    private CompanyEmployeeNokDetail nokDetail;

    @OneToOne
    private User accountDetail;

    public CompanyEmployee(Long id) {
        this.id = id;
    }
}
