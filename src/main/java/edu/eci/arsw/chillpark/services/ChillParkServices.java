package edu.eci.arsw.chillpark.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkPersistence;

/**
 * ChillParkServices
 */
@Service("chillparkservices")
public class ChillParkServices {
    @Autowired 
    @Qualifier("Imp")
    ChillParkPersistence cpp;

    public void addTiquete(Tiquete t){
        cpp.guardarTiquete(t);
    }

    public Tiquete getTiquete(int i){
        return cpp.getTiquete(i);
    }

    public ArrayList<Tiquete> getTiquetes(){
        return cpp.getTiquetes();
    }

    public void guardarAtraccion(Atraccion a){
        cpp.guardarAtraccion(a);
    }

    public Atraccion getAtraccion(int i){
        return cpp.getAtraccion(i);
    }

    public ArrayList<Atraccion> getAtracciones(){
        return cpp.getAtracciones();
    }

    
}