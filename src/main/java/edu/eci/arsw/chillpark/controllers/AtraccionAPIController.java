/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.controllers;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.services.AtraccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2128408
 */


@RestController
@RequestMapping(path = "/Atraccion")
public class AtraccionAPIController {
    
    @Autowired
    @Qualifier("atraccionservices")
    AtraccionServices as;
    
    public Iterable<Atraccion> getAtracciones() {
        return as.getAllAtractions();
    }
    
}
