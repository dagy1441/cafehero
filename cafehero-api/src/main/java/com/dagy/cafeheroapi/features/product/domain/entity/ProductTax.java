package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_TAX;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_TAX)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTax extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}