/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Agendamento;

/**
 *
 * @author akiot
 */
public class AgendamentoDAO extends GenericoDAO<Agendamento> {
    
    public AgendamentoDAO() {
        super(Agendamento.class);
    }
    
    public List<Agendamento> findByCodigo(String codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Agendamento> query = em.createQuery("Select c FROM Cliente c WHERE c.nome LIKE :nome", Agendamento.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }
  
}
