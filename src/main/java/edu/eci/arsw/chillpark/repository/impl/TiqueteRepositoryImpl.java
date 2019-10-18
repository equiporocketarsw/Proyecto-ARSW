package edu.eci.arsw.chillpark.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.repository.custom.TiqueteRepositoryCustom;

/**
 *
 * @author Santiago
 */


public class TiqueteRepositoryImpl implements TiqueteRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void postTiquete(Tiquete t) {
        Query query = entityManager.createNativeQuery("insert into tiquete(tipo,valido) values (?,true)",Tiquete.class);
        
        query.setParameter(1, t.getTipo() ).executeUpdate();

        
    }

    @Override
    public void updateTiquete(Tiquete t, int id) {
        Query query = entityManager.createNativeQuery("update tiquete set usuario = ?,valido=? where id=? ",Tiquete.class);
        
        query.setParameter(1, t.getUsuario() ).setParameter(2, t.getValido() ).setParameter(3, id ).executeUpdate();

    }
    
	
    
    
}