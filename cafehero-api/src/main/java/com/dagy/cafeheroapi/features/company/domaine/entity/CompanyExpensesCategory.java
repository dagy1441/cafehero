package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_EXPENSES;
import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_EXPENSES_CATEGORY;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_EXPENSES_CATEGORY)
public class CompanyExpensesCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<CompanyExpenses> expenses;

    public CompanyExpensesCategory(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
