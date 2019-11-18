/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services;

import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.persistence.ChillParkPersistenceException;
import java.util.List;


/**
 *
 * @author Santiago
 */


public interface TiqueteServices {

    /*public void addTiquete(String tipo);*/

    public void addTiquete(Tiquete t);

    public Tiquete getTiquete(int i) throws ChillParkNotFoundException;
   
    public List<Tiquete> getTiquetes();

    public void modifyTiquete(Tiquete tiq, int id) throws ChillParkPersistenceException;

	public List<Tiquete> getTiqueteByUsuario(String usuario);
}
