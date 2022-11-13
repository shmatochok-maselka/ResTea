package com.example.restea.dto;

import com.example.restea.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private int bonus;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.patronymic = user.getPatronymic();
        this.birthday = user.getBirthday();
        this.bonus = user.getBonus();
        this.email = user.getEmail();
    }

    public User toUser(){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setBirthday(birthday);
        user.setBonus(bonus);
        user.setEmail(email);
        return user;
    }
}
