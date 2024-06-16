package com.example.model;

import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username ;
    private String password;
    public boolean checkLogin(String u , String p){
        if (u.equals("Admin") && p.equals("123")){
            return true;
        }
        return false;
    }
}
