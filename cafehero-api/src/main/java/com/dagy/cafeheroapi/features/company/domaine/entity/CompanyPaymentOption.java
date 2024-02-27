package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_PAYMENT_OPTION;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_PAYMENT_OPTION)
public class CompanyPaymentOption extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;
    private String description;

    public CompanyPaymentOption(Long id) {
        this.id = id;
    }
}
