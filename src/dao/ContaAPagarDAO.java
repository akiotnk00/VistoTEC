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
import modelo.ContaAPagar;

/**
 *
 * @author akiot
 */
public class ContaAPagarDAO extends GenericoDAO<ContaAPagar> {
    
    public ContaAPagarDAO() {
        super(ContaAPagar.class);
    }
     
     public List<ContaAPagar> mostrarOrdenado() {
        EntityManager em = getEntityManager();
        TypedQuery<ContaAPagar> query = em.createQuery("Select c FROM ContaAPagar c ORDER BY c.vencimento", ContaAPagar.class);
        return query.getResultList();
    }
     
     
     // Busca conta por data de vencimento.
       public List<ContaAPagar> findByData(Date dataBusca) {
        EntityManager em = getEntityManager();
        Calendar c = Calendar.getInstance();
        c.setTime(dataBusca);
        c.add(Calendar.HOUR, 23);
        c.add(Calendar.MINUTE, 59);
        c.add(Calendar.SECOND, 59);
        c.add(Calendar.MILLISECOND, 999);

        TypedQuery<ContaAPagar> query = em.createQuery("Select c FROM ContaAPagar c WHERE c.vencimento BETWEEN :di and :df", ContaAPagar.class);
        query.setParameter("di", dataBusca, TemporalType.DATE);
        query.setParameter("df", c.getTime(), TemporalType.TIMESTAMP);
        return query.getResultList();
    }
       
       public List<ContaAPagar> findByDesc(String desc) {
        EntityManager em = getEntityManager();
        TypedQuery<ContaAPagar> query = em.createQuery("Select c FROM ContaAPagar c WHERE c.descricao LIKE :desc", ContaAPagar.class);
        query.setParameter("desc", "%" + desc + "%");
        return query.getResultList();
    }
       public List<ContaAPagar> findByValor(String valor) {
        EntityManager em = getEntityManager();
        TypedQuery<ContaAPagar> query = em.createQuery("Select c FROM ContaAPagar c WHERE c.valor LIKE :valor", ContaAPagar.class);
        query.setParameter("valor", "%" + valor + "%");
        return query.getResultList();
    }
       
       public List<ContaAPagar> findBySit(String sit) {
        EntityManager em = getEntityManager();
        TypedQuery<ContaAPagar> query = em.createQuery("Select c FROM ContaAPagar c WHERE c.situacao LIKE :sit", ContaAPagar.class);
        query.setParameter("sit", "%" + sit + "%");
        return query.getResultList();
    }
       
}
