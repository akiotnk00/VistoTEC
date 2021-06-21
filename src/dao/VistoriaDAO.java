/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import modelo.Vistoria;

/**
 *
 * @author akiot
 */
public class VistoriaDAO extends GenericoDAO<Vistoria> {

    public VistoriaDAO() {
        super(Vistoria.class);
    }

    // Busca de Vistoria por Placa    
    public List<Vistoria> findByPlaca(String placa) {
        EntityManager em = getEntityManager();
        TypedQuery<Vistoria> query = em.createQuery("Select v FROM Vistoria v WHERE v.veiculo.placa LIKE :placa", Vistoria.class);
        query.setParameter("placa", "%" + placa + "%");
        return query.getResultList();
    }

    // Busca de Vistoria por Modelo
    public List<Vistoria> findByNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Vistoria> query = em.createQuery("Select v FROM Vistoria v WHERE v.cliente.nome LIKE :nome ORDER BY v.id", Vistoria.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    // Busca de Vistoria por Referencia
    public List<Vistoria> findByReferencia(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Vistoria> query = em.createQuery("Select v FROM Vistoria v WHERE v.referencia.nome LIKE :nome", Vistoria.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    // Busca de Vistoria por CPF
    public Vistoria findByCpf(String cpf) {
        EntityManager em = getEntityManager();
        TypedQuery<Vistoria> query = em.createQuery("Select v FROM Vistoria v WHERE v.cliente.cpf LIKE :cpf", Vistoria.class);
        query.setParameter("cpf", "%" + cpf + "%");
        return query.getSingleResult();
    }

    // Busca por Data
    public List<Vistoria> findByData(Date dataBusca) {
        EntityManager em = getEntityManager();
        Calendar c = Calendar.getInstance();
        c.setTime(dataBusca);
        c.add(Calendar.HOUR, 23);
        c.add(Calendar.MINUTE, 59);
        c.add(Calendar.SECOND, 59);
        c.add(Calendar.MILLISECOND, 999);

        TypedQuery<Vistoria> query = em.createQuery("Select v FROM Vistoria v WHERE v.data BETWEEN :di and :df", Vistoria.class);
        query.setParameter("di", dataBusca, TemporalType.DATE);
        query.setParameter("df", c.getTime(), TemporalType.TIMESTAMP);
        return query.getResultList();
    }
    
    // Busca Todos em ordem decrescente pelo codigo
    public List<Vistoria> findAllOrder() {
        EntityManager em = getEntityManager();
        TypedQuery<Vistoria> query = em.createQuery("Select v FROM Vistoria v ORDER BY v.id DESC", Vistoria.class);
        return query.getResultList();
    }
}
