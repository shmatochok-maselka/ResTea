package com.example.restea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user",
        uniqueConstraints ={
            @UniqueConstraint(columnNames = "email")
        })
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "bonus")
    private int bonus = 0;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "image")
    private String image = "https://cdn-icons-png.flaticon.com/512/149/149071.png";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ToString.Exclude
    private Set<Role> roles;
}
