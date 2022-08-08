<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import modelo.Agendamento;
import modelo.Vistoria;

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
        TypedQuery<Agendamento> query = em.createQuery("Select d FROM Agendamento d WHERE d LIKE :codigo", Agendamento.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }

    // Busca por Data
    public List<Agendamento> buscaPorData(Date dataBusca) {
        EntityManager em = getEntityManager();
        Calendar c = Calendar.getInstance();
        dataBusca.setHours(0);
        dataBusca.setMinutes(0);
        c.setTime(dataBusca);
        c.add(Calendar.HOUR, 23);
        c.add(Calendar.MINUTE, 59);
        c.add(Calendar.SECOND, 59);
        c.add(Calendar.MILLISECOND, 999);
        
        TypedQuery<Agendamento> query = em.createQuery("Select a FROM Agendamento a WHERE a.dataagendamento BETWEEN :di and :df ORDER BY a.dataagendamento", Agendamento.class);
        query.setParameter("di", dataBusca, TemporalType.DATE);
        query.setParameter("df", c.getTime(), TemporalType.TIMESTAMP);
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

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import modelo.Agendamento;
import modelo.Vistoria;

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
        TypedQuery<Agendamento> query = em.createQuery("Select d FROM Agendamento d WHERE d LIKE :codigo", Agendamento.class);
        query.setParameter("codigo", "%" + codigo + "%");
        return query.getResultList();
    }

    // Busca por Data
    public List<Agendamento> buscaPorData(Date dataBusca) {
        EntityManager em = getEntityManager();
        Calendar c = Calendar.getInstance();
        dataBusca.setHours(0);
        dataBusca.setMinutes(0);
        c.setTime(dataBusca);
        c.add(Calendar.HOUR, 23);
        c.add(Calendar.MINUTE, 59);
        c.add(Calendar.SECOND, 59);
        c.add(Calendar.MILLISECOND, 999);
        
        TypedQuery<Agendamento> query = em.createQuery("Select a FROM Agendamento a WHERE a.dataagendamento BETWEEN :di and :df ORDER BY a.dataagendamento", Agendamento.class);
        query.setParameter("di", dataBusca, TemporalType.DATE);
        query.setParameter("df", c.getTime(), TemporalType.TIMESTAMP);
        return query.getResultList();
    }
}
>>>>>>> 791fa7302d8d5d97eeedd4be04da628588d96b96
