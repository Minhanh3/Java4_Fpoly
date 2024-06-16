package com.example.bt_jv4_12th3.controller;

import com.example.bt_jv4_12th3.entities.HoaDon;
import com.example.bt_jv4_12th3.repository.BanHang.HoaDonBanHang;
import com.example.bt_jv4_12th3.repository.BanHang.SanPhamBanHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.Map;

@WebServlet({
        "/ban-hang/index",
        "/hoa-don/stores",
})
public class BanHangServlet extends HttpServlet {
    HoaDonBanHang hdRepo = new HoaDonBanHang();
    SanPhamBanHang spRepo = new SanPhamBanHang();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("index")) {
            req.setAttribute("listHd", hdRepo.findAll());
            req.setAttribute("listSp", spRepo.findAll());
            req.getRequestDispatcher("/views/ban-hang.jsp").forward(req, resp);
        } else {
            //
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("stores")) {
            this.stores(req, resp);
        } else if (uri.contains("update")) {
//            this.update(req, resp);
        } else {
            //this.index(req, resp);
        }
    }

    private void stores(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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


}
