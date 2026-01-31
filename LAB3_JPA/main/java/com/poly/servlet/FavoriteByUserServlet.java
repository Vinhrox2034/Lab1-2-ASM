package com.poly.servlet;

import com.poly.entity.User;
import com.poly.util.XJPA;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/favorite-by-user")
public class FavoriteByUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        EntityManager em = XJPA.getEntityManager();

        try {
            User user = em.createQuery(
                            "SELECT u FROM User u LEFT JOIN FETCH u.favorites WHERE u.id = :id",
                            User.class
                    )
                    .setParameter("id", id)
                    .getSingleResult();

            req.setAttribute("user", user);

        } catch (NoResultException e) {
            req.setAttribute("message", "Không tìm thấy user");
        } finally {
            em.close(); // VERY IMPORTANT
        }

        req.getRequestDispatcher("/favorite-by-user.jsp").forward(req, resp);
    }
}
