package edu.eci.arsw.blueprints.persistence;


import java.util.ArrayList;

import edu.eci.arsw.blueprints.model.Atraccion;
import edu.eci.arsw.blueprints.model.Tiquete;

/**
 * ChillParkPersistence
 */
public interface ChillParkPersistence {

    public void guardarTiquete(Tiquete t);

    public Tiquete getTiquete(int i);

    public ArrayList<Tiquete> getTiquetes();

    public void guardarAtraccion(Atraccion a);

    public Atraccion getAtraccion(int i);

    public ArrayList<Atraccion> getAtracciones();
    
}