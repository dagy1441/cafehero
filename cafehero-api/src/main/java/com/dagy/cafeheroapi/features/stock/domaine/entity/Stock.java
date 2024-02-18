package com.dagy.cafeheroapi.features.stock.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static com.dagy.cafeheroapi.core.constants.Table.STOCK;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = STOCK)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Stock extends BaseEntity {
}
