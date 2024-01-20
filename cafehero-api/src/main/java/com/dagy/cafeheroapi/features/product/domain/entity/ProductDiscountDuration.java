package com.dagy.cafeheroapi.features.product.domain.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT;
import static com.dagy.cafeheroapi.core.constants.Table.PRODUCT_DISCOUNT;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_DISCOUNT)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDiscountDuration extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long priceId;
    private LocalDate startDate;
    private LocalDate endDate;


    public ProductDiscountDuration(Long priceId, LocalDate startDate, LocalDate endDate) {
        this.priceId = priceId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}