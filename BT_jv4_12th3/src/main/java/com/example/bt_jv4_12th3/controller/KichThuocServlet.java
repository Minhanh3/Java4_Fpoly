package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.KichThuoc;
import com.example.bt_jv4_12th3.repository.KichThuocRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/kich-thuoc/create",
        "/kich-thuoc/store",
        "/kich-thuoc/edit",
        "/kich-thuoc/update",
        "/kich-thuoc/delete",
        "/kich-thuoc/index"
})
public class KichThuocServlet extends HttpServlet {
    private KichThuocRepo ktRepo = new KichThuocRepo();

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
        req.getRequestDispatcher("/views/kich-thuoc/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
//        String tts = req.getParameter("trangThai");
//        int trangThai = Integer.parseInt(tts);
//        KichThuoc kt = new KichThuoc(null, ma, ten, trangThai);
//        this.ds.add(kt);
//        req.setAttribute("ds", ds);
        KichThuoc kichThuoc = new KichThuoc();
        try {
            BeanUtils.populate(kichThuoc, req.getParameterMap());
            this.ktRepo.create(kichThuoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/kich-thuoc/index");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        req.setAttribute("kts", this.ktRepo.findById(id));
        req.getRequestDispatcher("/views/kich-thuoc/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
//        String tts = req.getParameter("trangThai");
//        int trangThai = Integer.parseInt(tts);
//        KichThuoc kt = new KichThuoc(null, ma, ten, trangThai);
//        for (int i = 0; i < this.ds.size(); i++) {
//            KichThuoc k = this.ds.get(i);
//            if (k.getMa().equals( kt.getMa())){
//                this.ds.set(i, kt);
//            }
//        }
        KichThuoc kichThuoc = new KichThuoc();
        try {
            BeanUtils.populate(kichThuoc, req.getParameterMap());
            this.ktRepo.update(kichThuoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/kich-thuoc/index");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ma = req.getParameter("ma");
//        for (int i = 0; i < this.ds.size(); i++) {
//            KichThuoc kt = this.ds.get(i);
//            if (kt.getMa().equals(ma)) {
//                System.out.println("Đã xóa 2");
//                this.ds.remove(i);
//            }
//        }
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        KichThuoc kichThuoc = this.ktRepo.findById(id);
        this.ktRepo.delete(kichThuoc);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/kich-thuoc/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", ktRepo.findAll());
        req.getRequestDispatcher("/views/kich-thuoc/index.jsp").forward(req, resp);
    }
}
