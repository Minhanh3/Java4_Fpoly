package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.SanPham;
import com.example.bt_jv4_12th3.repository.SanPhamRepo;
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
        "/san-pham/create",
        "/san-pham/store",
        "/san-pham/edit",
        "/san-pham/update",
        "/san-pham/delete",
        "/san-pham/index"
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> ds = new ArrayList<>();
    private SanPhamRepo spRepo = new SanPhamRepo();

    public SanPhamServlet() {
        ds.add(new SanPham(null, "1", "Bánh", 0));
        ds.add(new SanPham(null, "2", "Bánh kẹo", 1));
        ds.add(new SanPham(null, "3", "Bánh chuối", 0));
    }

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("index")) {
            req.setAttribute("ds", spRepo.findAll());
            req.getRequestDispatcher("/views/san_pham/index.jsp").forward(req, resp);
        } else if (uri.contains("create")) {
            this.create(req, resp);
        } else if (uri.contains("edit")) {
            this.edit(req, resp);
        } else if (uri.contains("delete")) {
            this.delete(req, resp);
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
//       this.index(req,resp);
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/san_pham/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.spRepo.create(sp);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/san_pham/create.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/san-pham/index");
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);

        req.setAttribute("sp", spRepo.findByid(id));
        req.getRequestDispatcher("/views/san_pham/edit.jsp").forward(req, resp);
    }
    @SneakyThrows
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.spRepo.update(sp);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/san_pham/edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/san-pham/index");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        SanPham sp = spRepo.findByid(id);
        this.spRepo.delete(sp);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/san-pham/index");
    }

//    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("ds", spRepo.findAll());
//        req.getRequestDispatcher("/views/san_pham/index.jsp").forward(req, resp);
//    }


}
