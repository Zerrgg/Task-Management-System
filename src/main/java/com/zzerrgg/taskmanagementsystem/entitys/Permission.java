package com.zzerrgg.taskmanagementsystem.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "permissions")
public class Permission {
    @Id
    @Column(name = "permission_id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
