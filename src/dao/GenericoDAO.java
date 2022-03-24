/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author akiot
 */
public abstract class GenericoDAO<T> {

    private final EntityManagerFactory emf;
    private final Class<T> classe;

    public GenericoDAO(Class<T> classe) {
        this.classe = classe;
        emf = Persistence.createEntityManagerFactory("deltaSysPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void persist(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public boolean remove(T entity) {

        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    public void merge(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(classe));

        return em.createQuery(cq).getResultList();
    }

}