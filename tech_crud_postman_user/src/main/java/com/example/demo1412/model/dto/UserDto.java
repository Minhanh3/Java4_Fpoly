package com.example.demo1412.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
