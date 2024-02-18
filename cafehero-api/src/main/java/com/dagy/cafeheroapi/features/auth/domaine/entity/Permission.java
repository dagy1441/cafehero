package com.dagy.cafeheroapi.features.auth.domaine.entity;

import com.dagy.cafeheroapi.core.base.BaseEntity;
import com.dagy.cafeheroapi.features.auth.domaine.enums.AppModuleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static com.dagy.cafeheroapi.core.constants.Table.AUTH_PERMISSION;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = AUTH_PERMISSION)
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class Permission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private AppModuleEnum module;

    public Permission(String name, AppModuleEnum module) {
        this.name = name;
        this.module = module;
    }

    public Permission(Long id) {
        this.id = id;
    }
}
