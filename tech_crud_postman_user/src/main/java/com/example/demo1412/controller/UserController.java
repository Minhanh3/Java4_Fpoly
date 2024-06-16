package com.example.demo1412.controller;

import com.example.demo1412.entity.User;
import com.example.demo1412.model.dto.UserDto;
import com.example.demo1412.service.UserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServie userServie;

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userServie.getListUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserbyid(@PathVariable int id){
        UserDto result = userServie.getUserId(id);
        System.out.println(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword") String name){
        List<UserDto> users = userServie.searchUser(name);

        return ResponseEntity.ok(users);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(){
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(){
        return null;
    }
}
