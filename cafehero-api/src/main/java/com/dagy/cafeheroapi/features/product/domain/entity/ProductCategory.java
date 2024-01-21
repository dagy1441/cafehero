package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_CATEGORY;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_CATEGORY)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private ProductCategory parent;

    @OneToMany(mappedBy = "productCategory")
    private List<ProductBasic> products;

    public ProductCategory(Long id) {
        this.id = id;
    }

}
