package com.poly.servlet;
import com.poly.util.XJPA;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/jpa-test")
public class JPATestServlet extends HttpServlet {
    @Override
    public void init() {
        EntityManager em = XJPA.getEntityManager();
        System.out.println("JPA OK: " + em);
        em.close();
    }
}

