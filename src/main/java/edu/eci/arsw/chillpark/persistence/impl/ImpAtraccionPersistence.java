/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.persistence.impl;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.persistence.AtraccionPersistence;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author 2128408
 */

@Component("ImpAtr")
public class ImpAtraccionPersistence implements AtraccionPersistence {

    @Override
    public void guardarAtraccion(Atraccion a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Atraccion getAtraccion(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Atraccion> getAtracciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
