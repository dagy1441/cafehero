package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_EXPENSES;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_EXPENSES)
public class CompanyExpenses extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private CompanyExpensesCategory category;

    private Double amount;
    /*
        recordDate is the date the money was spent,
        it's not the same as the date the record was created on the system,
        that will be createdAt
     */
    private LocalDate recordDate;
    private String comment;
    private String uploads;
    private Boolean isPendingApproval;

    private Boolean isRecentlyUpdated;
    //todo: refactor approvedBy and registeredBy to a user object &
    // remember to update CompanyExpensesSearchSpecification too
    private String approvedBy;
    private String registeredBy;
}
