package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_EMPLOYEE_PERSONAL_DETAIL;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_EMPLOYEE_PERSONAL_DETAIL)
public class CompanyEmployeePersonalDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "First name is required")
    @Column(nullable = false)
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeePhone;
    private String employeeAddress;
    private LocalDate employeeDateOfBirth;

    public String getEmployeeFullName() {
        return String.format("%s %s", this.employeeFirstName, this.employeeLastName);
    }
}
