package com.poly.servlet;

import com.poly.dao.UserDAO;
import com.poly.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/login", "/logout"})
public class AuthServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.contains("logout")) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Users user = userDAO.findByUsernameAndPassword(username, password);

        if (user == null) {
            req.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
