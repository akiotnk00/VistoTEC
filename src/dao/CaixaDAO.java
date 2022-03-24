/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Caixa;

/**
 *
 * @author akiot
 */
public class CaixaDAO extends GenericoDAO<Caixa> {

    public CaixaDAO() {
        super(Caixa.class);
    }

    public List<Caixa> findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Caixa> query = em.createQuery("Select c FROM Caixa c WHERE d LIKE :codigo ORDER BY codigo", Caixa.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }

    public List<Caixa> ultimasAberturas() {
        EntityManager em = getEntityManager();
        TypedQuery<Caixa> query = em.createQuery("Select c FROM Caixa c ORDER BY c.codigo DESC", Caixa.class);
        query.setMaxResults(5);
        return query.getResultList();
    }

}
