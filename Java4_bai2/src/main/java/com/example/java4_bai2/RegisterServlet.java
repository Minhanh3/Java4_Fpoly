package com.example.java4_bai2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String country = req.getParameter("country");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");

        resp.getWriter().write("<h3>" + username + "<h3>");
        resp.getWriter().write("<h3>" + age + "<h3>");
        resp.getWriter().write("<h3>" + country + "<h3>");
        resp.getWriter().write("<h3>" + gender + "<h3>");
        for (String item : hobbies
        ) {
            resp.getWriter().write("<h3>" + item);
        }

    }
}
