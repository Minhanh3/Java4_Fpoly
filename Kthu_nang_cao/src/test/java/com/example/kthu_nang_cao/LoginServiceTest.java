package com.example.kthu_nang_cao;

import com.example.kthu_nang_cao.lab1.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginServiceTest {

    @Test
    void login() {
    }
    @Test
    public void testCredentials() {
        LoginService loginService = new LoginService();
        String defaultUsername = "Admin";
        String defaultPassword = "123456";
        boolean result = loginService.login(defaultUsername, defaultPassword);
        Assertions.assertTrue(result);
    }
    @Test
    public void testlength() {
        LoginService loginService = new LoginService();
        String defaultUsername = "man";
        String defaultPassword = "123456";
        boolean result = loginService.login(defaultUsername, defaultPassword);
        Assertions.assertFalse(result);
    }
    @Test
    public void testlength1() {
        LoginService loginService = new LoginService();
        String defaultUsername = "minuuuuu";
        String defaultPassword = "12345678";
        boolean result = loginService.login(defaultUsername, defaultPassword);
        Assertions.assertFalse(result);
    }
    @Test
    public void testlength2() {
        LoginService loginService = new LoginService();
        String defaultUsername = "Admin";
        String defaultPassword = "12345678";
        boolean result = loginService.login(defaultUsername, defaultPassword);
        Assertions.assertFalse(result);
    }
    @Test
    public void testlength3() {
        LoginService loginService = new LoginService();
        String defaultUsername = "Admin@";
        String defaultPassword = "12345678@";
        boolean result = loginService.login(defaultUsername, defaultPassword);
        Assertions.assertFalse(result);
    }
}