package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_BASIC;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_BASIC)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasic extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;

}