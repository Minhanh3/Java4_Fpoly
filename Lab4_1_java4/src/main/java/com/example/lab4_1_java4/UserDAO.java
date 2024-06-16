package com.example.lab4_1_java4;

import com.example.lab4_1_java4.entities.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    List<User> ls = new ArrayList<>();

    public List<User> dummyData() throws ParseException {
        ls.add(new User("A1", "123", "Nguyen Duc Manh", 21, formatDate.parse("30/01/2003"), false));
        ls.add(new User("A2", "123", "Nguyen Duc Anh", 22, formatDate.parse("30/05/2004"), true));
        ls.add(new User("A3", "123", "Nguyen Duc Huy", 23, formatDate.parse("30/04/2005"), false));
        ls.add(new User("A4", "123", "Nguyen Duc Nhat", 24, formatDate.parse("30/03/2006"), true));
        ls.add(new User("A5", "123", "Nguyen Duc Duong", 25, formatDate.parse("30/02/2007"), false));
        return ls;
    }

    public List<User> getAll() {
        return ls;
    }
    public int insert(User u){
        ls.add(u);
        return 1;
    }
    public int update(User u){
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getUsername().equals(u.getUsername())) {
                ls.set(i , u);
                return i;
            }
        }
        return -1;
    }
    public User findByUsername(String username){
        for (User user: ls) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public int save(User user){
        if (findByUsername(user.getUsername()) != null){
            update(user);
        }else {
            insert(user);
        }
        return 1;
    }
    public int delete(String username){
        User u = findByUsername(username);
        if (u != null) {
            ls.remove(u);
            return 1;
        }
        return -1;
    }
}
