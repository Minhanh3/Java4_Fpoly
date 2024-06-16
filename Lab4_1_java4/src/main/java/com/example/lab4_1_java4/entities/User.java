package com.example.lab4_1_java4.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username ;
    private String password ;
    private String fullname ;
    private int age ;
    private Date birthday ;
    private boolean gender ;
}
