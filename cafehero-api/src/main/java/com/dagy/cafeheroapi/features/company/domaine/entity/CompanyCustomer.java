package com.dagy.cafeheroapi.features.company.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import com.dagy.cafeheroapi.features.company.domaine.enums.CustomerTagEnum;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.COMPANY_CUSTOMER;

@Entity
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = COMPANY_CUSTOMER)
public class CompanyCustomer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String customerFirstName;
    private String customerLastName;
    @Column(unique = true)
    private String customerEmail;

    @Column(unique = true)
    private String customerPhone;
    private String customerAddress;
    private CustomerTagEnum customerTag;

    public CompanyCustomer(Long id) {
        this.id = id;
    }

    public String getFullName() {

        String firstName = this.customerFirstName != null ? this.customerFirstName : "";
        String lastName = this.customerLastName != null ? this.customerLastName : "";

        return firstName + " " + lastName;
    }

    public String getFullNameAndPhone() {
        String phone = this.customerPhone != null ? this.customerPhone : "";
        return String.format("%s, (%s)", this.getFullName(), phone);

    }
}
