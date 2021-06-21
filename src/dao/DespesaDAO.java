/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Despesa;

/**
 *
 * @author akiot
 */
public class DespesaDAO extends GenericoDAO<Despesa> {
    
    public DespesaDAO() {
        super(Despesa.class);
    }

    
    public List<Despesa> findByCpf(String cpf) {
        EntityManager em = getEntityManager();
        TypedQuery<Despesa> query = em.createQuery("Select c FROM Cliente c WHERE c.cpf LIKE :cpf", Despesa.class);
        query.setParameter("cpf", "%" + cpf + "%");
        return query.getResultList();
    }
}
