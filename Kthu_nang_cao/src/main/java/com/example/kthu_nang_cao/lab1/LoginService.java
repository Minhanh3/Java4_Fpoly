package com.example.kthu_nang_cao.lab1;

public class LoginService {
    public boolean login(String username, String password) {
        if (username.length() < 5 || username.length() > 15) {
            System.out.println("Username phải có từ 5 đến 15 ký tự.");
            return false;
        }
        if (password.length() < 4 || password.length() > 8) {
            System.out.println("Password phải có từ 4 đến 8 ký tự.");
            return false;
        }
        // Kiểm tra xác thực với username và password mặc định
        if("Admin".equals(username) && "123456".equals(password)){
            System.out.println("Đăng nhập thành công");
            return true;
        }
        return false;
    }
}
