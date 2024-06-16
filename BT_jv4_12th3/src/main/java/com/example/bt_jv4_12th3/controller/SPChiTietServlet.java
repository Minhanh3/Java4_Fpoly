package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.SanPham;
import com.example.bt_jv4_12th3.entities.SanPhamChiTiet;
import com.example.bt_jv4_12th3.repository.SanPhamCTRepo;
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
        "/sp-chitiet/create",
        "/sp-chitiet/store",
        "/sp-chitiet/edit",
        "/sp-chitiet/update",
        "/sp-chitiet/delete",
        "/sp-chitiet/index"
})
public class SPChiTietServlet extends HttpServlet {
    private List<SanPhamChiTiet> ds = new ArrayList<>();
    private SanPhamCTRepo spctRepo = new SanPhamCTRepo();
//    private static int idKichThuoc = 1; // Giả sử ID ban đầu là 1
//    private static int idMauSac = 1;
//    private static int idSanPham = 1;

//    public SPChiTietServlet() {
//        ds.add(new SanPhamChiTiet(null, "1", idKichThuoc++, idMauSac++, idSanPham++, "10", "100.0", 0));
//        ds.add(new SanPhamChiTiet(null,"2", idKichThuoc++, idMauSac++, idSanPham++, "40", "200.0", 1));
//        ds.add(new SanPhamChiTiet(null,"3", idKichThuoc++, idMauSac++, idSanPham++, "50", "400.0", 1));
//    }

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
//            this.index(req,resp);
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/sp-chitiet/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPhamChiTiet sPChiTiet = new SanPhamChiTiet();
        try {
            BeanUtils.populate(sPChiTiet, req.getParameterMap());
            System.out.println(req.getParameterMap());
            Integer sanPhamId = Integer.parseInt(req.getParameter("IdSanPham"));
            SanPham sanPham = new SanPham();
            sPChiTiet.setSanPham(sanPham);
            this.spctRepo.create(sPChiTiet);
            System.out.println("Them Thanh Cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/sp-chitiet/index");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        req.setAttribute("sp", this.spctRepo.findByID(id));
        req.getRequestDispatcher("/views/sp-chitiet/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        try {
            BeanUtils.populate(sanPhamChiTiet, req.getParameterMap());
            this.spctRepo.upddate(sanPhamChiTiet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/sp-chitiet/index");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        SanPhamChiTiet sanPhamChiTiet = this.spctRepo.findByID(id);
        this.spctRepo.delete(sanPhamChiTiet);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/sp-chitiet/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", spctRepo.findAll());
        req.getRequestDispatcher("/views/sp-chitiet/index.jsp").forward(req, resp);
    }
}
