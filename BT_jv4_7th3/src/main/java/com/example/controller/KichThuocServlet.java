package com.example.controller;

import com.example.entitles.KichThuoc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/kich-thuoc/index")
public class KichThuocServlet extends HttpServlet {

    private List<KichThuoc> ds = new ArrayList<>();
    public KichThuocServlet(){
        ds.add(new KichThuoc(null , "Trắng" , "1" ,1));
        ds.add(new KichThuoc(null , "Hồng" , "3" ,0));
        ds.add(new KichThuoc(null , "Đen" , "5" ,1));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------------");
        req.setAttribute("ds" , ds);
        req.getRequestDispatcher("/views/kich_thuoc/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
//        String tts = req.getParameter("trangthai");
//        int trangthai = Integer.parseInt(tts);
//        KichThuoc ms = new KichThuoc(null ,ma,ten,trangthai);

    }
}
