/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface AtraccionServices {
    
    public List<Atraccion> getAllAtractions();

    public Atraccion getAtraccion(int nombreatraccion) throws ChillParkNotFoundException;

	public void changeState(Atraccion at, int id);
    
}
