package com.example.luyentap1.controller;

import com.example.luyentap1.model.GiangVien;
import com.example.luyentap1.service.GiangVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "hehe", value = {
        "/giang-vien/home",
        "/giang-vien/them",
        "/giang-vien/detail",
        "/giang-vien/delete",
        "/giang-vien/search",
        "/giang-vien/update",
        "/giang-vien/sua",
})
public class GiangVienServlet extends HttpServlet {
    private GiangVienService giangVienService = new GiangVienService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("home")) {
            req.setAttribute("list", giangVienService.getList());
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        } else if (url.contains("detail")) {
            detail(req, resp);
        } else if (url.contains("delete")) {
            delete(req, resp);
        } else if (url.contains("search")) {
            search(req, resp);
        } else if (url.contains("update")) {
            update(req, resp);
        }
    }

    @SneakyThrows
    public void update(HttpServletRequest r, HttpServletResponse q) {
        String ma = r.getParameter("ma");
        GiangVien gv = giangVienService.detail(ma);
        r.setAttribute("detail", gv);
        r.getRequestDispatcher("/update.jsp").forward(r, q);
    }

    @SneakyThrows
    public void search(HttpServletRequest r, HttpServletResponse q) {
        String ten = r.getParameter("ten");
        String gioiTinh = r.getParameter("gioiTinh");
        r.setAttribute("list", giangVienService.search(ten, Boolean.parseBoolean(gioiTinh)));
        r.getRequestDispatcher("/Home.jsp").forward(r, q);
    }

    @SneakyThrows
    public void delete(HttpServletRequest req, HttpServletResponse r) {
        String ma = req.getParameter("ma");
        giangVienService.delete(ma);
        r.sendRedirect("/giang-vien/home");
    }

    @SneakyThrows
    public void detail(HttpServletRequest request, HttpServletResponse response) {
        String ma = request.getParameter("ma");
        request.setAttribute("detail", giangVienService.detail(ma));
        request.setAttribute("list", giangVienService.getList());
        request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("them")) {
            them(req, resp);
        } else {
            sua(req, resp);
        }
    }

    @SneakyThrows
    public void sua(HttpServletRequest r, HttpServletResponse q) {
        GiangVien gv = new GiangVien();
        BeanUtils.populate(gv, r.getParameterMap());
        String ma = r.getParameter("ma");
        Map<String, String> errors = giangVienService.sua(ma, gv);
        if (errors == null) {
            q.sendRedirect("/giang-vien/home");
        } else {
            r.setAttribute("err", errors);
            r.setAttribute("detail", gv);
            r.getRequestDispatcher("/update.jsp").forward(r, q);
        }
    }

    public void them(HttpServletRequest req, HttpServletResponse resp) throws Exception, ServletException, IOException {
        GiangVien gv = new GiangVien();
        BeanUtils.populate(gv, req.getParameterMap());
        System.out.println(gv.isGioiTinh());
        Map<String, String> err = giangVienService.them(gv);
        if (err == null) {
            resp.sendRedirect("/giang-vien/home");
        } else {
            req.setAttribute("err", err);
            req.setAttribute("list", giangVienService.getList());
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        }
    }
}
