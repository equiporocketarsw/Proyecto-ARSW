package edu.eci.arsw.chillpark.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.eci.arsw.chillpark.model.Atraccion;

import edu.eci.arsw.chillpark.repository.custom.AtraccionRepositoryCustom;


/**
 *
 * @author Santiago
 */

public class AtraccionRepositoryImpl implements AtraccionRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void changeState(Atraccion a, int id) {
        Query query = entityManager.createNativeQuery("update atraccion set activo=? where id=? ",Atraccion.class);
        
        query.setParameter(1, a.isActivo() ).setParameter(2, id ).executeUpdate();

    }


}