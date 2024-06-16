package com.example.demo1412.entity;

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

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String password;

}
