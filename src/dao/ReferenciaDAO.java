/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Referencia;

/**
 *
 * @author akiot
 */
public class ReferenciaDAO extends GenericoDAO<Referencia> {
    
    public ReferenciaDAO() {
        super(Referencia.class);
    }
    
    public List<Referencia> findByNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Referencia> query = em.createQuery("Select r FROM Referencia r WHERE r.nome LIKE :nome", Referencia.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
     public List<Referencia> findByTelefone(String telefone) {
        EntityManager em = getEntityManager();
        TypedQuery<Referencia> query = em.createQuery("Select r FROM Referencia r WHERE r.telefone LIKE :telefone", Referencia.class);
        query.setParameter("telefone", "%" + telefone + "%");
        return query.getResultList();
    }
}
