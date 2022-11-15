package com.example.restea.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "role")
public class Role extends BaseEntity {
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleEnum name;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
