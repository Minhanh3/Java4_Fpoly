package com.example.demo_ktra_9th4.controller;

import com.example.demo_ktra_9th4.entity.Ban;
import com.example.demo_ktra_9th4.repository.BanRepoSi;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
        "/ban/hien-thi",
        "/ban/update",
        "/ban/remove",
        "/ban/edit",
})
public class BanServlet extends HttpServlet {
    private BanRepoSi banRepo = new BanRepoSi();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            req.setAttribute("ds" , banRepo.getAll());
            req.getRequestDispatcher("/views/ban/hien-thi.jsp").forward(req , resp);
        } else if (uri.contains("edit")) {
            String ids = req.getParameter("id");
            int id = Integer.parseInt(ids);
            Ban ban =  banRepo.findByid(id);
            req.setAttribute("b" , ban);
            req.getRequestDispatcher("/views/ban/edit.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
