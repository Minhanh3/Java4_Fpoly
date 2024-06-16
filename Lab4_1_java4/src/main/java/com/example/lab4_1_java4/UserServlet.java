package com.example.lab4_1_java4;

import com.example.lab4_1_java4.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.Date;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        User user = null;
        String action = req.getParameter("action");
        try {
            if (action == null || action.equals("")) {
                req.setAttribute("users", dao.dummyData());
                req.getRequestDispatcher("/views/display-users.jsp").forward(req, resp);
                return;
            }
            switch (action) {
                case "AddOrEdit": {
                    String username = req.getParameter("username");
                    user = dao.findByUsername(username);
                    if (user == null) {
                        user = new User();
                    }
                    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
                    break;
                }
                case "SaveOrUpdate": {
                    DateTimeConverter dtc = new DateConverter(new Date());
                    dtc.setPattern("dd/MM/yyyy");
                    ConvertUtils.register(dtc, Date.class);
                    user = new User();
                    BeanUtils.populate(user, req.getParameterMap());
                    dao.save(user);
                    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);

                    break;
                }
            }
        } catch (Exception e) {
            //
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
