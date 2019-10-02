package edu.eci.arsw.chillpark.services;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.repository.AtraccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2128408
 */


@Service("atraccionservices")
public class AtraccionServices {
    
    @Autowired
    private AtraccionRepository atracrepo;
    
    public List<Atraccion> getAllAtractions() {
        return atracrepo.findAll(); 
    }
    
}
