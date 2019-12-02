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
        Query query = entityManager.createQuery("select t from atraccionusuario au , tiquete t where au.atraccion=:idAtraccion and t.id=au.tiquete", Tiquete.class);
        
        query.setParameter("idAtraccion", atraccion);
        return query.getResultList();
    }

    @Override
    public List<Atraccion> findByUsuario(int tiquete) {
        Query query = entityManager.createQuery("select a from atraccionusuario au , atraccion a where au.tiquete=:tiqid and a.id=au.atraccion", Atraccion.class);
        
        query.setParameter("tiqid", tiquete);
        return query.getResultList();
    }

     @Override
    public List<Atraccion> ColasByUsuario(String user) {
        Query query = entityManager.createQuery("select a from atraccionusuario au , tiquete t,atraccion a where  t.id=au.tiquete and a.id=au.atraccion and  t.usuario=:username group by a.id", Atraccion.class);
        
        query.setParameter("username", user);
        return query.getResultList();
    }

    @Override
    public List <Tiquete> colasByAtraccionAndUser(int atraccion, String usuario){
        Query query = entityManager.createQuery("select t from atraccionusuario au , tiquete t where  t.id=au.tiquete and au.atraccion=:idAtraccion and t.usuario=:username ", Tiquete.class);
        
        query.setParameter("username", usuario).setParameter("idAtraccion", atraccion);
        return query.getResultList();
    }

    @Override
    public void addQueue(Atraccionusuario cola) {
        Query query = entityManager.createNativeQuery("insert into atraccionusuario values (idAtraccion,tiquete)",Atraccionusuario.class);
        
        query.setParameter("tiquete", cola.getTiquete()).setParameter("idAtraccion", cola.getAtraccion()).executeUpdate();

    }

    @Override
    public void deleteColas(int atraccion){
        Query query = entityManager.createNativeQuery("DELETE FROM atraccionusuario WHERE atraccion=:idAtraccion",Atraccionusuario.class);
        
        query.setParameter("idAtraccion", atraccion).executeUpdate();

    }

    @Override
    public void deletecolasByAtraccionAndUser(int atraccion, String usuario) {
        Query query = entityManager.createNativeQuery("delete from atraccionusuario where tiquete in (select au.tiquete from atraccionusuario au , tiquete t where  t.id=au.tiquete and au.atraccion=:idAtraccion and t.usuario=:username)",Atraccionusuario.class);
                                                        s
        query.setParameter("username", usuario).setParameter("idAtraccion", atraccion).executeUpdate();
    }


}