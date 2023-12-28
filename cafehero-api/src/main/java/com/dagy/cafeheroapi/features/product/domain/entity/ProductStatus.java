package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_STATUS;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_STATUS)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatus  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}