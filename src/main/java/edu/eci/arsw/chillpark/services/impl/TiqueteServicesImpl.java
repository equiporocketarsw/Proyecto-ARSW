/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services.impl;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.repository.TiqueteRepository;
import edu.eci.arsw.chillpark.services.TiqueteServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */

@Service("tiqueteservices")
public class TiqueteServicesImpl implements TiqueteServices{

    @Autowired
    private TiqueteRepository tiqrepo;
    
    
    @Override
    public void addTiquete(Tiquete t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tiquete getTiquete(int id) throws ChillParkNotFoundException{
        try{
            Tiquete tiquete = tiqrepo.findById(id).get();
            return tiquete;
        }
        catch(java.util.NoSuchElementException e){
           throw new ChillParkNotFoundException("No existe el usuario");
        }      }

    @Override
    public List<Tiquete> getTiquetes() {
        return tiqrepo.findAll();
    }
    
}
