package com.example.restea.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserDataDto {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private Integer bonus;
    private String image;
}
