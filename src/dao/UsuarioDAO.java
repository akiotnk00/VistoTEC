/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author akiot
 */
public class UsuarioDAO extends GenericoDAO<Usuario> {
    
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    public List<Usuario> findByUser(String usuario) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> query = em.createQuery("Select u FROM Usuario u WHERE u.usuario LIKE :usuario", Usuario.class);
        query.setParameter("usuario", "%" + usuario + "%");
        return query.getResultList();
    }
}
