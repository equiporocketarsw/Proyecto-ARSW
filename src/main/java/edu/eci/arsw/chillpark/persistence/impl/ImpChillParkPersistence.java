package edu.eci.arsw.chillpark.persistence.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.ChillPark;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkPersistence;

/**
 * ImpChillParkPersistence
 */

@Component("Imp")
public class ImpChillParkPersistence implements ChillParkPersistence {

    private ChillPark chill = new ChillPark();
    public ImpChillParkPersistence(){
        chill.addAtraccion(new Atraccion("Montaña rusa", 60, 20));
    }


    @Override
    public void guardarTiquete(Tiquete t) {
        chill.addTiquete(t);

    }

    @Override
    public Tiquete getTiquete(int i) {
        return chill.getTiquete(i);
    }

    @Override
    public ArrayList<Tiquete> getTiquetes() {
        return chill.getTiquetes();
    }

    @Override
    public void guardarAtraccion(Atraccion a) {
        chill.addAtraccion(a);

    }

    @Override
    public Atraccion getAtraccion(int i) {
        return chill.getAtraccion(i);
    }

    @Override
    public ArrayList<Atraccion> getAtracciones() {
        return chill.getAtracciones();
    }

    
}