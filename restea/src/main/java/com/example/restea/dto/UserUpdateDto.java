package com.example.restea.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserUpdateDto {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private String image;
}
