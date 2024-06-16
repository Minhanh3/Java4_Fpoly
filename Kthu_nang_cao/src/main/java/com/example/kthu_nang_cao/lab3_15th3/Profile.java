package com.example.kthu_nang_cao.lab3_15th3;

public class Profile {
    private String name ;
    public Profile(String name){
this.name = name;
    }
    public String getName(){
        if (name == null){
            throw new NullPointerException("Profile is empty");
        }
        return name;
    }

}
