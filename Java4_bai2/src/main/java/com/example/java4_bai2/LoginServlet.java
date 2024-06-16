package com.example.java4_bai2;


import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/" , "/checklogin"})
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("MESSAGE" , "");
        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
        User u = new User();
        if (u.checkLogin(username,password)){
            req.getRequestDispatcher("/views/result.jsp").forward(req,resp);
        }else {
            req.setAttribute("MESSAGE" , "UserName or Password not exit");
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        }
    }
}
