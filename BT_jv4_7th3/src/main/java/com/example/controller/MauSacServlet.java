package com.example.controller;

import com.example.entitles.MauSac;
import com.example.repository.MauSacRespository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/mau-sac/create",
        "/mau-sac/store",
        "/mau-sac/edit",
        "/mau-sac/update",
        "/mau-sac/index",
        "/mau-sac/delete"
})
public class MauSacServlet extends HttpServlet {
    private List<MauSac> ds = new ArrayList<>();
    private MauSacRespository msRepo = new MauSacRespository() ;
    public MauSacServlet() {
        ds.add(new MauSac(null, "1", "Yellow", 0));
        ds.add(new MauSac(null, "2", "Black", 1));
        ds.add(new MauSac(null, "3", "Green", 1));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            this.create(req, resp);
        } else if (uri.contains("edit")) {
            this.edit(req, resp);
        } else if (uri.contains("delete")) {
            this.delete(req, resp);
        } else {
            this.index(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else {
//            this.index(req,resp);
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    public void store(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String tthai = req.getParameter("trangthai");
        int trangthai = Integer.parseInt(tthai);
        MauSac ms = new MauSac(null, ma, ten, trangthai);
//        this.ds.add(ms);
//        msRepo.create(ms);
        req.setAttribute("data", ms);
        req.setAttribute("ds", msRepo.create(ms));
//        System.out.println(ma + "-" + name + "-" + tthai );
        // luôn ở dưới cuối
        resp.sendRedirect("/BT_jv4_7th3_war_exploded/mau-sac/index");
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }

    public void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("ds", msRepo.findAll());
        req.getRequestDispatcher("/views/table.jsp").forward(req, resp);
    }

    public void delete(
            HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac c = this.ds.get(i);
            if (c.getMa().equals(ma)) {
//                msRepo.delete(i);
                this.ds.remove(i);
            }
        }
        resp.sendRedirect("/BT_jv4_7th3_war_exploded/mau-sac/index");
    }
}
