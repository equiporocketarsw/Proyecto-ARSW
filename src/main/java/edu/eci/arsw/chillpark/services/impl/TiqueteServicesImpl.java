/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services.impl;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.persistence.ChillParkPersistenceException;
import edu.eci.arsw.chillpark.repository.TiqueteRepository;
import edu.eci.arsw.chillpark.services.TiqueteServices;

import java.util.ArrayList;
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
    public void addTiquete(Tiquete t){
        
        tiqrepo.postTiquete(t);

    }
    /*
    @Override
    public void addTiquete(Tiquete t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    @Override
    public Tiquete getTiquete(int id) throws ChillParkNotFoundException{
        try{
            Tiquete tiquete = tiqrepo.findById(id).get();
            return tiquete;
        }
        catch(java.util.NoSuchElementException e){
           throw new ChillParkNotFoundException("No existe el tiquete");
        }      }

    @Override
    public List<Tiquete> getTiquetes() {
        return tiqrepo.findAll();
    }

    @Override
    public void modifyTiquete(Tiquete tiq, int id) throws ChillParkPersistenceException{
        tiqrepo.updateTiquete(tiq, id);
    }

    @Override
    public List<Tiquete> getTiqueteByUsuario(String usuario) {
        List<Tiquete> result = new ArrayList<>();
        System.out.println(usuario);
        if (usuario.equals("anybody")){
            result= tiqrepo.findByAnybody();

        }
        else if(usuario.equals("none")){

            result= tiqrepo.findByNull();
        }
        else{
            result= tiqrepo.findbyUser(usuario);
        }
        return result;
    }
}
