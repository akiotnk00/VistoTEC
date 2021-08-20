/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Movimentacao;

/**
 *
 * @author akiot
 */
public class MovimentacaoDAO extends GenericoDAO<Movimentacao> {
    
    public MovimentacaoDAO() {
        super(Movimentacao.class);
    }

    
     public List<Movimentacao> findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Movimentacao> query = em.createQuery("Select d FROM Movimentacao d WHERE d LIKE :codigo", Movimentacao.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }
}
