package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.KhachHang;
import com.example.bt_jv4_12th3.repository.KhachHangRepo;
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
        "/khach-hang/create",
        "/khach-hang/store",
        "/khach-hang/edit",
        "/khach-hang/update",
        "/khach-hang/delete",
        "/khach-hang/index"
})
public class KhachHangServlet extends HttpServlet {
    private List<KhachHang> ds = new ArrayList<>();
    private KhachHangRepo khRepo = new KhachHangRepo();

    public KhachHangServlet() {
        ds.add(new KhachHang(null, "Manh", "123456", "1", 0));
        ds.add(new KhachHang(null, "Ha", "123456", "4", 1));
        ds.add(new KhachHang(null, "Trang", "123456", "6 ", 0));
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
        }
    }

    protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/khach-hang/create.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHang kh = new KhachHang();
        try {
            BeanUtils.populate(kh, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.khRepo.create(kh);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/khach-hang/create.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/khach-hang/index");
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        req.setAttribute("kh", khRepo.findByid(id));
        req.getRequestDispatcher("/views/khach-hang/edit.jsp").forward(req, resp);
    }

    @SneakyThrows
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHang kh = new KhachHang();
        try {
            BeanUtils.populate(kh, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> err = this.khRepo.update(kh);
        if (!err.isEmpty()) {
            req.setAttribute("err", err);
            req.getRequestDispatcher("/views/khach-hang/edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/BT_jv4_12th3_war_exploded/khach-hang/index");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
//        String maKh = req.getParameter("maKh");
//        for (int i = 0; i < this.ds.size(); i++) {
//            KhachHang k = this.ds.get(i) ;
//            System.out.println("Da xóa");
//            if (k.getMaKh().equals(maKh)) {
//                this.ds.remove(i);
//            }
//        }
        KhachHang kh = khRepo.findByid(id);
        khRepo.delete(kh);
        resp.sendRedirect("/BT_jv4_12th3_war_exploded/khach-hang/index");
    }

    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds", khRepo.findAll());
        req.getRequestDispatcher("/views/khach-hang/index.jsp").forward(req, resp);
    }
}
