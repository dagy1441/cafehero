package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private ProductUnitOfMeasure unitOfMeasure;

    @ManyToOne
    private ProductStatus status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private List<ProductTax> taxes;

    @Column(nullable = false)
    private String productName;

    @Column(unique = true)
    private String sku;

    @Column(unique = true)
    private String barcode;
    private String brandName;
    private String description;
    private Boolean isActive;
    private Boolean useQuantity;
    private Boolean isService;
    private Integer minAgeLimit;
    private Integer lowStockPoint;
    @Column(columnDefinition = "integer default 0")
    private final Integer quantity = 0;

    public String title() {
        return String.format("%s %s", this.productName, this.brandName);
    }

}