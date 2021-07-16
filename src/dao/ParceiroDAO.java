/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Parceiro;

/**
 *
 * @author akiot
 */
public class ParceiroDAO extends GenericoDAO<Parceiro> {
    
    public ParceiroDAO() {
        super(Parceiro.class);
    }
    
    public List<Parceiro> findByNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Parceiro> query = em.createQuery("Select r FROM Referencia r WHERE r.nome LIKE :nome", Parceiro.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
     public List<Parceiro> findByTelefone(String telefone) {
        EntityManager em = getEntityManager();
        TypedQuery<Parceiro> query = em.createQuery("Select r FROM Referencia r WHERE r.telefone LIKE :telefone", Parceiro.class);
        query.setParameter("telefone", "%" + telefone + "%");
        return query.getResultList();
    }
}
