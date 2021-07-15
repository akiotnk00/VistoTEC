/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Receita;

/**
 *
 * @author akiot
 */
public class ReceitaDAO extends GenericoDAO<Receita> {
    
    public ReceitaDAO() {
        super(Receita.class);
    }
    
    public List<Receita> findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Receita> query = em.createQuery("Select r FROM Receita r WHERE r LIKE :codigo", Receita.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }
    
}
