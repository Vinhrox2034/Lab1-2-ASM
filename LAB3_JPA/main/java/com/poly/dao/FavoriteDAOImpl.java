package com.poly.dao;
import com.poly.dao.FavoriteDAO;
import com.poly.entity.Favorite;
import com.poly.util.XJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class FavoriteDAOImpl implements FavoriteDAO {

    @Override
    public List<Favorite> findAll() {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Favorite o", Favorite.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Favorite findById(Integer id) {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.find(Favorite.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Favorite create(Favorite entity) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Favorite update(Favorite entity) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Favorite updated = em.merge(entity);
            em.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Favorite entity = em.find(Favorite.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
