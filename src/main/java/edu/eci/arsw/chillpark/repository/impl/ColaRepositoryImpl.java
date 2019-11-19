package edu.eci.arsw.chillpark.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Tiquete;
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
    public List<Tiquete> findByAtraccion(int atraccion) {
        Query query = entityManager.createQuery("select t from Atraccionusuario au , tiquete t where au.atraccion=:idAtraccion and t.id=au.tiquete", Tiquete.class);
        
        query.setParameter("idAtraccion", atraccion);
        return query.getResultList();
    }

    @Override
    public List<Atraccion> findByUsuario(int tiquete) {
        Query query = entityManager.createQuery("select a from Atraccionusuario au , Atraccion a where au.tiquete=:tiqid and a.id=au.atraccion", Atraccion.class);
        
        query.setParameter("tiqid", tiquete);
        return query.getResultList();
    }



}