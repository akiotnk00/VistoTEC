<<<<<<< HEAD
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
        TypedQuery<Parceiro> query = em.createQuery("Select p FROM Parceiro p WHERE p.nome LIKE :nome", Parceiro.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
     public List<Parceiro> findByTelefone(String telefone) {
        EntityManager em = getEntityManager();
        TypedQuery<Parceiro> query = em.createQuery("Select p FROM Parceiro p WHERE p.telefone LIKE :telefone", Parceiro.class);
        query.setParameter("telefone", "%" + telefone + "%");
        return query.getResultList();
    }
}
=======
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
        TypedQuery<Parceiro> query = em.createQuery("Select p FROM Parceiro p WHERE p.nome LIKE :nome", Parceiro.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
     public List<Parceiro> findByTelefone(String telefone) {
        EntityManager em = getEntityManager();
        TypedQuery<Parceiro> query = em.createQuery("Select p FROM Parceiro p WHERE p.telefone LIKE :telefone", Parceiro.class);
        query.setParameter("telefone", "%" + telefone + "%");
        return query.getResultList();
    }
}
>>>>>>> 791fa7302d8d5d97eeedd4be04da628588d96b96
