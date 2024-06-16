package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.MauSac;
import com.example.bt_jv4_12th3.repository.KhachHangRepo;
import com.example.bt_jv4_12th3.repository.MauSacRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/mau-sac/create",
        "/mau-sac/store",
        "/mau-sac/edit",
        "/mau-sac/update",
        "/mau-sac/delete",
        "/mau-sac/index",
})
public class MauSacSerlvet extends HttpServlet {
    private List<MauSac> ds = new ArrayList<>();
    private MauSacRepo msRepo = new MauSacRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("update")) {
            this.update(req, resp);
        } else if (uri.contains("store")) {
            this.store(req, resp);
        } else {
//            this.index(req,resp);
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/mau-sac/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MauSac ms = new MauSac();
        try {
            BeanUtils.populate(ms, req.getParameterMap());
            msRepo.create(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        req.setAttribute("ds", ds);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/mau-sac/index");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);

        req.setAttribute("ms", msRepo.findByid(id));
        req.getRequestDispatcher("/views/mau-sac/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MauSac ms = new MauSac();
        try {
            BeanUtils.populate(ms, req.getParameterMap());
            this.msRepo.update(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/BT_jv4_12th3_war_exploded/mau-sac/index");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        MauSac ms = this.msRepo.findByid(id);
        this.msRepo.delete(ms);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/mau-sac/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", msRepo.findAll());
        req.getRequestDispatcher("/views/mau-sac/index.jsp").forward(req, resp);
    }
}
