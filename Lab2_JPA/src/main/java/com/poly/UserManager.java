package com.poly;

import javax.persistence.*;
import java.util.List;

public class UserManager {

    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("PolyOE");
    EntityManager em = factory.createEntityManager();

    // 1. Find all users
    public List<User> findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }

    // 2. Find users NOT admin (admin = false)
    public List<User> findFptUsersNotAdmin() {
        String jpql = "SELECT u FROM User u WHERE u.admin = false";
        return em.createQuery(jpql, User.class).getResultList();
    }

    // 3. Pagination
    public List<User> findPage(int page, int size) {
        String jpql = "SELECT u FROM User u ORDER BY u.id";
        return em.createQuery(jpql, User.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    // (Optional) CRUD methods still OK
}
