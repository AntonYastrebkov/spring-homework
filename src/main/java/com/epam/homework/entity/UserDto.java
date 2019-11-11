package com.epam.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String number;
}
