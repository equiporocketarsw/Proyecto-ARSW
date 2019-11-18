package edu.eci.arsw.chillpark.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.repository.custom.ColaRepositoryCustom;


/**
 *
 * @author Santiago
 */

public class ColaRepositoryImpl implements ColaRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> findByAtraccion(int atraccion) {
        Query query = entityManager.createQuery("select u from Atraccionusuario au , Usuario u where au.atraccion=:idAtraccion and u.username=au.usuario", Usuario.class);
        
        query.setParameter("idAtraccion", atraccion);
        return query.getResultList();
    }

    @Override
    public List<Atraccion> findByUsuario(String usuario) {
        Query query = entityManager.createQuery("select a from Atraccionusuario au ,Atraccion a where usuario=:userName and atraccion=id", Atraccion.class);
        
        query.setParameter("userName", usuario);
        return query.getResultList();
    }



}