package com.example.calculator_8th3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/calculator.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("numberA"));
        double b = Double.parseDouble(req.getParameter("numberB"));
        String action = req.getParameter("action");
        double rs = a + b;
        switch (action) {
            case "+": {
                rs = a + b;
                break;
            }
            case "-": {
                rs = a - b;
                break;
            }
            case "x": {
                rs = a * b;
                break;
            }
            case "/": {
                rs = a / b;
                break;
            }
        }
        req.setAttribute("NUMBER_A", a);
        req.setAttribute("NUMBER_B", b);
        req.setAttribute("ACTION", action);
        req.setAttribute("RESULT", rs);
        req.getRequestDispatcher("/views/result.jsp").forward(req, resp);
    }
}
