/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.controllers;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.services.AtraccionServices;
import edu.eci.arsw.chillpark.services.impl.AtraccionServicesImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2128408
 */


@RestController
@RequestMapping(value = "/atraccion")
 
public class AtraccionAPIController {
    
    @Autowired
    @Qualifier("atraccionservices")
    AtraccionServices as;
    
    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAtracciones() {
        try{
            return new ResponseEntity<>(as.getAllAtractions(), HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            Logger.getLogger(UsuarioAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
        }  
     }
        
        
    @RequestMapping(path = "/{atraccion}", method = RequestMethod.GET)
    public ResponseEntity<?> getUsuario(@PathVariable(name = "atraccion") int idatraccion) {
        try {
 
            Atraccion atraccion = as.getAtraccion(idatraccion);
            return new ResponseEntity<>(atraccion, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> manejadorPostRecursoAtraccion(@RequestBody Atraccion a){
        try {
            as.getAllAtractions();
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(AtraccionAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al intentar crear la nueva atraccion",HttpStatus.FORBIDDEN);            
        }
    }


    @RequestMapping(path = "/{id}",method = RequestMethod.PUT)	
    public ResponseEntity<?> PutAtraccion(@PathVariable ("id") int id,@RequestBody Atraccion at ){
        
        try {
            as.changeState(at,id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(AtraccionAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
    
    
}
