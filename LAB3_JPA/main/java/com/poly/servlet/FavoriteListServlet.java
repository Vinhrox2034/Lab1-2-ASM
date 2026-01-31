package com.poly.servlet;
import com.poly.util.XJPA;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/favorite-list")
public class FavoriteListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager em = XJPA.getEntityManager();

        try {

            List<Object[]> list = em.createQuery(
                    "SELECT v.id, v.title, COUNT(f) " +
                            "FROM Favorite f JOIN f.video v " +
                            "GROUP BY v.id, v.title",
                    Object[].class
            ).getResultList();

            // send data to JSP
            req.setAttribute("items", list);

        } finally {
            em.close();
        }

        req.getRequestDispatcher("/favorite-list.jsp")
                .forward(req, resp);
    }
}
