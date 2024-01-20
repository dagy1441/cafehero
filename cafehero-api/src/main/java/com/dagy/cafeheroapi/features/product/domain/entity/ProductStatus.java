package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String title;
    private String description;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<ProductBasic> productBasics;

    public ProductStatus(Long id) {
        this.id = id;
    }



}