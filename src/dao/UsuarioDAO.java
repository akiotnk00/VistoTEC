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

    public List<Usuario> findByUser(String name) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> query = em.createQuery("Select u FROM Usuario u WHERE u.nomeusuario like :namebusca", Usuario.class);
        query.setParameter("namebusca", name);
        return query.getResultList();
    }

    public Usuario findUser(String name) {

        EntityManager em = getEntityManager();
        TypedQuery<Usuario> query = em.createQuery("Select u FROM Usuario u WHERE u.nomeusuario = :namebusca", Usuario.class);
        query.setParameter("namebusca", name);
        try {
            if (query.getSingleResult() == null) {
                return null;
            } else {
                return query.getSingleResult();
            }
        } catch (Exception e) {
            return null;
        }
                
    }

}
