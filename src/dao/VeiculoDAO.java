/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Veiculo;

/**
 *
 * @author akiot
 */
public class VeiculoDAO extends GenericoDAO<Veiculo> {
    
    public VeiculoDAO() {
        super(Veiculo.class);
    }

// Busca de Veiculo por Placa    
    public List<Veiculo> findByPlaca(String placa) {
        EntityManager em = getEntityManager();
        TypedQuery<Veiculo> query = em.createQuery("Select p FROM Veiculo p WHERE p.placa LIKE :placa", Veiculo.class);
        query.setParameter("placa", "%" + placa + "%");
        return query.getResultList();
    }

// Busca de Veiculo por Modelo
 public List<Veiculo> findByModelo(String modelo) {
        EntityManager em = getEntityManager();
        TypedQuery<Veiculo> query = em.createQuery("Select p FROM Veiculo p WHERE p.modelo LIKE :modelo", Veiculo.class);
        query.setParameter("modelo", "%" + modelo + "%");
        return query.getResultList();
    }    
 
}
