package edu.eci.arsw.chillpark.repository.impl;



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
        Query query = entityManager.createNativeQuery("update atraccion set nombre=?,capacidad=?,tiempo=?,activo=?,descripcion=?,estaturamin=?,estaturamax=?,tipo=? where id=? ",Atraccion.class);
        
        query.setParameter(1, a.getNombre() )
                .setParameter(2, a.getCapacidad() )
                .setParameter(3, a.getTiempo() )
                .setParameter(4, a.isActivo() )
                .setParameter(5, a.getDescrpcion() )
                .setParameter(6, a.getEstaturamin() )
                .setParameter(7, a.getEstaturamax() )
                .setParameter(8, a.getTipo() )
                .setParameter(9, id ).executeUpdate();

    }


}