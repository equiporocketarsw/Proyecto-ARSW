package edu.eci.arsw.chillpark.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.model.ColaID;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.repository.ColaRepository;
import edu.eci.arsw.chillpark.services.ColaServices;

/**
 *
 * @author 2128408
 */

@Service("colaservices")
public class ColaServicesImpl implements ColaServices {

    @Autowired
    private ColaRepository colarepo;

    @Override
    public List<Atraccionusuario> getAllQueues() {
        return colarepo.findAll();
    }

    @Override
    public Atraccionusuario getCola(int atraccion, int tiquete) throws ChillParkNotFoundException {
        ColaID id = new ColaID(atraccion,tiquete);
        return colarepo.findById(id).get();
    }

    @Override
    public List<Tiquete> findByAtraccion(int atraccion) {
       
        return colarepo.findByAtraccion(atraccion);
    }

    @Override
    public List<Atraccion> findByTiquete(int tiquete) {
        return colarepo.findByUsuario(tiquete);
    }

    @Override
    public void addQueue(Atraccionusuario cola) {
        colarepo.saveAndFlush(cola);

    }

    @Override
    public List<Tiquete> colasByUsuario(String user){
        return colarepo.ColasByUsuario(user);
    }

    @Override
    public List <Tiquete> colasByAtraccionAndUser(int atraccion, String usuario){
        return colarepo.colasByAtraccionAndUser(atraccion,usuario);

    }

    @Override
    public void deleteColas(int atraccion) {
        colarepo.deleteColas(atraccion);

    }

    @Override
    public void deletecolasByAtraccionAndUser(int atraccion, String usuario) {
        colarepo.deletecolasByAtraccionAndUser(atraccion,usuario);
    }
    
}