/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.ContaAPagar;

/**
 *
 * @author akiot
 */
public class ContaAPagarDAO extends GenericoDAO<ContaAPagar> {
    
    public ContaAPagarDAO() {
        super(ContaAPagar.class);
    }

    
     public List<ContaAPagar> findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<ContaAPagar> query = em.createQuery("Select d FROM Despesa d WHERE d LIKE :codigo", ContaAPagar.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }
}
