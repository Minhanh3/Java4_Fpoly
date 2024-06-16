package com.example.java4_session03_11th3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@MultipartConfig
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            Part part = req.getPart("photo");

            String realPart = req.getServletContext().getRealPath("/images");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if (!Files.exists(Path.of(realPart))) {
                Files.createDirectories(Path.of(realPart));
            }
            part.write(realPart + "/" + filename);
            try (PrintWriter out = resp.getWriter()) {
                out.print("id là : " + id + " Name là : " + name + " File là : " + filename);
            } catch (Exception e) {
            }
        } catch (Exception e) {

        }
    }
}
