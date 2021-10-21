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
public class PagamentoDAO extends GenericoDAO<Caixa> {
    
    public PagamentoDAO() {
        super(Caixa.class);
    }

     
     public List<Caixa> findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Caixa> query = em.createQuery("Select d FROM Caixa d WHERE d LIKE :codigo LIMIT 5 ORDER BY codigo DESC", Caixa.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }
     
     
}
