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
import modelo.Cliente;

/**
 *
 * @author akiot
 */
public class ClienteDAO extends GenericoDAO<Cliente> {
    
    public ClienteDAO() {
        super(Cliente.class);
    }
    
    public List<Cliente> findByNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Cliente> query = em.createQuery("Select c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public List<Cliente> findByCpf(String cpf) {
        EntityManager em = getEntityManager();
        TypedQuery<Cliente> query = em.createQuery("Select c FROM Cliente c WHERE c.cpf LIKE :cpf", Cliente.class);
        query.setParameter("cpf", "%" + cpf + "%");
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
import modelo.Cliente;

/**
 *
 * @author akiot
 */
public class ClienteDAO extends GenericoDAO<Cliente> {
    
    public ClienteDAO() {
        super(Cliente.class);
    }
    
    public List<Cliente> findByNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Cliente> query = em.createQuery("Select c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public List<Cliente> findByCpf(String cpf) {
        EntityManager em = getEntityManager();
        TypedQuery<Cliente> query = em.createQuery("Select c FROM Cliente c WHERE c.cpf LIKE :cpf", Cliente.class);
        query.setParameter("cpf", "%" + cpf + "%");
        return query.getResultList();
    }
}
>>>>>>> 791fa7302d8d5d97eeedd4be04da628588d96b96
