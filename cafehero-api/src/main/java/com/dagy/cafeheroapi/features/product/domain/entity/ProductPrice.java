package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_PRICE;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_PRICE)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double markup;
    private Double costPrice; // prix de revient
    private Double sellingPrice;  // prix de vente
    private Double discount;

    @OneToOne(mappedBy = "price", fetch = FetchType.LAZY)
    private Product product;

}