package com.example.demo1412.model.mapper;

import com.example.demo1412.entity.User;
import com.example.demo1412.model.dto.UserDto;
import org.springframework.stereotype.Component;

public class Usermapper {
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());

        return tmp;
    }
}
