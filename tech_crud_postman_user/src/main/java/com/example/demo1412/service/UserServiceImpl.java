package com.example.demo1412.service;

import com.example.demo1412.entity.User;
import com.example.demo1412.model.dto.UserDto;
import com.example.demo1412.model.mapper.Usermapper;
import com.example.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserServie {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "manh", "manh@gmail.com", "09875123", "avatar.img", "manh1"));
        users.add(new User(2, "manhken", "manh@gmail.com", "09875123", "avatar.img", "manh1"));
        users.add(new User(3, "manhkin", "manh@gmail.com", "09875123", "avatar.img", "manh1"));
        users.add(new User(4, "manhhen", "manh@gmail.com", "09875123", "avatar.img", "manh1"));
        users.add(new User(5, "manhtai", "manh@gmail.com", "09875123", "avatar.img", "manh1"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(Usermapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserId(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Usermapper.toUserDto(user);
            }
        }
        throw new NotFoundException("Không tồi tại id trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user: users
             ) {
            if (user.getName().contains(keyword)){
                result.add(Usermapper.toUserDto(user));
            }
        }
        return result;
    }

}
