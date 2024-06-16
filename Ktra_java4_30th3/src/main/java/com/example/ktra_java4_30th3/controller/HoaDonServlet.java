package com.example.ktra_java4_30th3.controller;

import com.example.ktra_java4_30th3.model.HoaDon;
import com.example.ktra_java4_30th3.repository.HoaDonRepo;
import com.example.ktra_java4_30th3.repository.NhanVienRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet({
        "/hoa-don/index",
        "/hoa-don/create",
        "/hoa-don/store",
        "/hoa-don/delete"
})
public class HoaDonServlet extends HttpServlet {
    private HoaDonRepo hdRepo = new HoaDonRepo();
    private NhanVienRepo nvRepo = new NhanVienRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String uri = req.getRequestURI();
        if (uri.contains("index")) {
            this.index(req, resp);
        }else if (uri.contains("create")){
            this.create(req , resp);
        } else if (uri.contains("delete")) {
            this.delete(req , resp);
        }else {

        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        HoaDon hd = this.hdRepo.findByid(id);
        this.hdRepo.delete(hd);
        resp.sendRedirect("../hoa-don/index");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/hoa-don/create.jsp").forward(req,resp);
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ds" , this.hdRepo.findALl());
        req.setAttribute("dsnv" , this.nvRepo.findALl());
        req.getRequestDispatcher("/views/hoa-don/index.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req , resp);
        }    else {
            //
        }
    }

    private void store(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HoaDon hd = new HoaDon();
        try {
            BeanUtils.populate(hd , req.getParameterMap());
            this.hdRepo.create(hd);
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("../hoa-don/index");
    }
}
