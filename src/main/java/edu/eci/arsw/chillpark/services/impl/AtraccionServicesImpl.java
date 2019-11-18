package edu.eci.arsw.chillpark.services.impl;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.repository.AtraccionRepository;
import edu.eci.arsw.chillpark.services.AtraccionServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2128408
 */


@Service("atraccionservices")
public class AtraccionServicesImpl implements AtraccionServices{
    
    @Autowired
    private AtraccionRepository atracrepo;
    
    public List<Atraccion> getAllAtractions() {
        return atracrepo.findAll(); 
    }

    public Atraccion getAtraccion(int idatraccion) throws ChillParkNotFoundException{
        try{
            Atraccion atraccion = atracrepo.findById(idatraccion).get();
            return atraccion;
        }
        catch(java.util.NoSuchElementException e){
           throw new ChillParkNotFoundException("No existe la atraccion");
        }    
    }

    @Override
    public void changeState(Atraccion at, int id) {
        atracrepo.changeState(at, id);
    }
    
}
