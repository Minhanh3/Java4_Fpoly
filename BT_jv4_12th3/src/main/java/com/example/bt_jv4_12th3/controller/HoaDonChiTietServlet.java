package com.example.bt_jv4_12th3.controller;


import com.example.bt_jv4_12th3.entities.HoaDonChiTiet;
import com.example.bt_jv4_12th3.repository.HDChiTietRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet({
        "/hoa-don-chitiet/create",
        "/hoa-don-chitiet/store",
        "/hoa-don-chitiet/edit",
        "/hoa-don-chitiet/update",
        "/hoa-don-chitiet/delete",
        "/hoa-don-chitiet/index"
})
public class HoaDonChiTietServlet extends HttpServlet {
    private List<HoaDonChiTiet> ds = new ArrayList<>();
    private HDChiTietRepo hdctRepo = new HDChiTietRepo();

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
//       this.index(req,resp);
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/hoa-don-chi-tiet/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("dd/MM/yyyy");
            ConvertUtils.register(dtc, Date.class);
            BeanUtils.populate(hdct, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.hdctRepo.create(hdct);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/hoa-don-chi-tiet/create.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/hoa-don-chitiet/index");
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id1 = req.getParameter("id");
        int id = Integer.parseInt(id1);
        req.setAttribute("hdct", hdctRepo.findByid(id));
        req.getRequestDispatcher("/views/hoa-don-chi-tiet/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        try {
            BeanUtils.populate(hdct, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.hdctRepo.update(hdct);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/hoa-don-chi-tiet/edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/hoa-don-chitiet/index");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        HoaDonChiTiet hdct = hdctRepo.findByid(id);
        hdctRepo.delete(hdct);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/hoa-don-chitiet/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", hdctRepo.findAll());
        req.getRequestDispatcher("/views/hoa-don-chi-tiet/index.jsp").forward(req, resp);
    }
}
