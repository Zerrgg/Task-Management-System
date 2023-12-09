package com.zzerrgg.taskmanagementsystem.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role id")
    private Integer id;

    @Column(name = "name")
    private String name;

}
