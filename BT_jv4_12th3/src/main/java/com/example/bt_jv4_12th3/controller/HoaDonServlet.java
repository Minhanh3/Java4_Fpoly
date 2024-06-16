package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.HoaDon;
import com.example.bt_jv4_12th3.repository.HoaDonRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet({
        "/hoa-don/create",
        "/hoa-don/store",
        "/hoa-don/edit",
        "/hoa-don/update",
        "/hoa-don/delete",
        "/hoa-don/index"
})
public class HoaDonServlet extends HttpServlet {
    private List<HoaDon> ds = new ArrayList<>();
    private HoaDonRepo hdRepo = new HoaDonRepo();
    private int idNhanVien = 1;
    private int idKhachHang = 1;

    public HoaDonServlet() {
        ds.add(new HoaDon(1, idNhanVien++, idKhachHang++, "14/3/2024", 0));
        ds.add(new HoaDon(2, idNhanVien++, idKhachHang++, "15/4/2024", 1));
        ds.add(new HoaDon(3, idNhanVien++, idKhachHang++, "16/6/2024", 0));
    }

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
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else {
            //this.index(req, resp);
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/hoa-don/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDon hoaDon = new HoaDon();
        try {
            BeanUtils.populate(hoaDon, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String , String> err = this.hdRepo.create(hoaDon);
        if (!err.isEmpty()){
            req.setAttribute("err" , err);
            req.getRequestDispatcher("/views/hoa-don/create.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/hoa-don/index");
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        req.setAttribute("h", hdRepo.findById(id));
        req.getRequestDispatcher("/views/hoa-don/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDon hoaDon = new HoaDon();
        try {
            BeanUtils.populate(hoaDon, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String , String> err = this.hdRepo.update(hoaDon);
        if (!err.isEmpty()){
            req.setAttribute("err" , err);
            req.getRequestDispatcher("/views/hoa-don/edit.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/hoa-don/index");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        HoaDon hoaDon = this.hdRepo.findById(id);
        this.hdRepo.delete(hoaDon);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/hoa-don/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", hdRepo.findAll());
        req.getRequestDispatcher("/views/hoa-don/index.jsp").forward(req, resp);
    }
}
