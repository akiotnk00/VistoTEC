/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Reprova;

/**
 *
 * @author akiot
 */
public class ReprovaDAO extends GenericoDAO<Reprova> {
    
    public ReprovaDAO() {
        super(Reprova.class);
    }
    
    public List<Reprova> findById(long codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Reprova> query = em.createQuery("Select r FROM Reprova r WHERE r.codigo LIKE :codigo", Reprova.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }
}
