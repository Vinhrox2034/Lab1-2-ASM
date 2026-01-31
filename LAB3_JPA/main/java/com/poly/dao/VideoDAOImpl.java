package com.poly.dao;
import com.poly.dao.VideoDAO;
import com.poly.entity.Video;
import com.poly.util.XJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class VideoDAOImpl implements VideoDAO {
    @Override
    public List<Video> findByKeyword(String keyword) {
        EntityManager em = XJPA.getEntityManager();
        try {
            String jpql = "SELECT o FROM Video o WHERE o.title LIKE :kw";
            return em.createQuery(jpql, Video.class)
                    .setParameter("kw", "%" + keyword + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAll() {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Video o", Video.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Video findById(String id) {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.find(Video.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Video create(Video entity) {
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
    public Video update(Video entity) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Video updated = em.merge(entity);
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
    public void deleteById(String id) {
        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Video entity = em.find(Video.class, id);
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
