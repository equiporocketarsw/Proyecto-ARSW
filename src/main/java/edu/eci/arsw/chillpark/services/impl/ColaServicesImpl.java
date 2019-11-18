package edu.eci.arsw.chillpark.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.model.ColaID;
import edu.eci.arsw.chillpark.model.Usuario;
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
    public Atraccionusuario getCola(int atraccion, String usuario) throws ChillParkNotFoundException {
        ColaID id = new ColaID(atraccion, usuario);
        return colarepo.findById(id).get();
    }

    @Override
    public List<Usuario> findByAtraccion(int atraccion) {
       
        return colarepo.findByAtraccion(atraccion);
    }

    @Override
    public List<Atraccion> findByUsuario(String usuario) {
        return colarepo.findByUsuario(usuario);
    }

    @Override
    public void addQueue(Atraccionusuario cola) {
        colarepo.saveAndFlush(cola);

    }


    
}