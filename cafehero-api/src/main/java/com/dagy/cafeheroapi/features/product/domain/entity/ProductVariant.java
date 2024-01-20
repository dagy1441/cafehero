package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import com.dagy.cafeheroapi.features.product.domain.enums.ProductVariantType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_VARIATIONS;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_VARIATIONS)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    @NotNull(message = "Variant type cannot be null")
    private ProductVariantType variantType;

    private String variantValue;
}
