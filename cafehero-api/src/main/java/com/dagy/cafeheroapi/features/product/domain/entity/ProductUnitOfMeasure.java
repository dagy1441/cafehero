package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_UNIT_OF_MEASURE;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_UNIT_OF_MEASURE)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUnitOfMeasure extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
