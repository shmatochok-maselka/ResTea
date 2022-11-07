package com.example.restea.dto;

import com.example.restea.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private LocalDate birthday;
    private int bonus;
    private String email;
    private String password;
    private String image;


    public UserDto(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.birthday = user.getBirthday();
        this.bonus = user.getBonus();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.image = user.getImage();
    }

    public User toUser(){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setBirthday(birthday);
        user.setBonus(bonus);
        user.setEmail(email);
        user.setPassword(password);
        user.setImage(image);
        return user;
    }
}

