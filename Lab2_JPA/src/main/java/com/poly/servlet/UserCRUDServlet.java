package com.poly.servlet;

import com.poly.User;
import com.poly.UserDAO;
import com.poly.UserDAOImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/crud/*")
public class UserCRUDServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        UserDAO dao = new UserDAOImpl();

        // Form object
        User form = new User();
        try {
            BeanUtils.populate(form, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String message = "Enter user information";

        String path = req.getPathInfo(); // /index, /edit/u01, /create ...

        if (path == null || path.equals("/index")) {
            message = "User list";

        } else if (path.startsWith("/edit")) {
            String id = path.substring(path.lastIndexOf("/") + 1);
            form = dao.findById(id);
            message = "Edit user: " + id;

        } else if (path.equals("/create")) {
            dao.create(form);
            message = "Create success: " + form.getId();
            form = new User();

        } else if (path.equals("/update")) {
            dao.update(form);
            message = "Update success: " + form.getId();

        } else if (path.equals("/delete")) {
            dao.deleteById(form.getId());
            message = "Delete success: " + form.getId();
            form = new User();

        } else if (path.equals("/reset")) {
            form = new User();
            message = "Reset form";
        }

        //
        List<User> list = dao.findAll();

        req.setAttribute("message", message);
        req.setAttribute("user", form);
        req.setAttribute("users", list);

        req.getRequestDispatcher("/pages/user-crud.jsp")
                .forward(req, resp);
    }
}
