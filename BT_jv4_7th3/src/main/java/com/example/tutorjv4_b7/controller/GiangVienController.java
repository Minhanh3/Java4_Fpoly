package com.example.tutorjv4_b7.controller;

import com.example.tutorjv4_b7.entity.GiangVien;
import com.example.tutorjv4_b7.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "/GiangVienController", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail",
        "/giang-vien/remove",
        "/giang-vien/view-update",
        "/giang-vien/update",
        "/giang-vien/tim-kiem",
        "/giang-vien/add",
})
public class GiangVienController extends HttpServlet {

    private GiangVienRepository gvRepo = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiTatCa(req, resp);
        } else if (uri.contains("detail")) {
            this.chiTiet(req, resp);
        } else if (uri.contains("remove")) {
            this.remove(req, resp);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(req, resp);
        } else {
            this.timKiem(req, resp);
        }
    }

    private void timKiem(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void hienThiTatCa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiangVien> list = gvRepo.getAll();
        req.setAttribute("a" ,list);
        req.getRequestDispatcher("/views/giang-vien/giangvien.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("update")) {
            this.update(req, resp);
        } else {
            this.add(req, resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
    }
}
