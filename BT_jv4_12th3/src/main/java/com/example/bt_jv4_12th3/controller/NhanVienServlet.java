package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.NhanVien;
import com.example.bt_jv4_12th3.repository.NhanVienRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet({
        "/nhan-vien/create",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update",
        "/nhan-vien/delete",
        "/nhan-vien/index",
})
public class NhanVienServlet extends HttpServlet {
    private List<NhanVien> ds = new ArrayList<>();
    private NhanVienRepo nvRepo = new NhanVienRepo();

    public NhanVienServlet() {
        ds.add(new NhanVien(null, " Manh", " 1", " Manhn", "123", 1));
        ds.add(new NhanVien(null, " Ha ", " 2", " Haname", "1233", 0));
        ds.add(new NhanVien(null, " Treng", " 7", " TrengN", "123", 1));
    }

    @Override
    @SneakyThrows
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
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else {
//            this.index(req, resp);
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/nhan-vien/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        try {
            BeanUtils.populate(nhanVien, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.nvRepo.create(nhanVien);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/nhan-vien/create.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/nhan-vien/index");
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        req.setAttribute("nv", this.nvRepo.finById(id));
        req.getRequestDispatcher("/views/nhan-vien/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        try {
            BeanUtils.populate(nhanVien, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.nvRepo.update(nhanVien);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/nhan-vien/edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/nhan-vien/index");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        NhanVien nhanVien = this.nvRepo.finById(id);
        this.nvRepo.delete(nhanVien);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/nhan-vien/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", nvRepo.findAll());
        req.getRequestDispatcher("/views/nhan-vien/index.jsp").forward(req, resp);
    }
}
