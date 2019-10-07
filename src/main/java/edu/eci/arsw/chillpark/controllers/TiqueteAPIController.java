/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.controllers;

import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.services.TiqueteServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Santiago
 */

@RestController
@RequestMapping(value = "/tiquete")
public class TiqueteAPIController {
    
    @Autowired
    @Qualifier("tiqueteservices")
    TiqueteServices ts;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoTiquetes(){
        try {
            return new ResponseEntity<>(ts.getTiquetes(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TiqueteAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error en la peticiÃ³n",HttpStatus.NOT_FOUND);
        }
    }

    
    @RequestMapping(path="/{tiquete}",method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoTiquete(@PathVariable("tiquete") int tiquete){
        try {
            return new ResponseEntity<>(ts.getTiquete(tiquete),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TiqueteAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        } 
    }
    
    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> manejadorPostRecursoTiquete(@RequestBody Tiquete t){
        try {
            ts.addTiquete(t);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(TiqueteAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al intentar crear el nuevo tiquete",HttpStatus.FORBIDDEN);            
        }
    }
    
}
