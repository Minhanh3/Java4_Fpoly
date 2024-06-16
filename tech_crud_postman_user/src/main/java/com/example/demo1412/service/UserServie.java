package com.example.demo1412.service;

import com.example.demo1412.entity.User;
import com.example.demo1412.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserServie {
    public List<UserDto> getListUser();

    public UserDto getUserId(int id);
    public List<UserDto> searchUser(String keyword);
}
