package edu.eci.arsw.blueprints.controllers;

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

import edu.eci.arsw.blueprints.model.Atraccion;
import edu.eci.arsw.blueprints.model.Tiquete;
import edu.eci.arsw.blueprints.services.ChillParkServices;

/**
 * ChillParkAPIController
 */
@RestController
@RequestMapping(value = "/chillpark")
public class ChillParkAPIController {

    @Autowired
    @Qualifier("chillparkservices")
    ChillParkServices cps;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoTiquetes(){
        try {
            return new ResponseEntity<>(cps.getTiquetes(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error en la petición",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> manejadorPostRecursoTiquete(@RequestBody Tiquete t){
        try {
            cps.addTiquete(t);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al intentar crear el nuevo tiquete",HttpStatus.FORBIDDEN);            
        }
    }
    @RequestMapping(path="/{tiquete}",method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoTiquete(@PathVariable("tiquete") int tiquete){
        try {
            return new ResponseEntity<>(cps.getTiquete(tiquete),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        } 
    }

    @RequestMapping(path = "/atracciones", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoAtracciones(){
        try {
            return new ResponseEntity<>(cps.getAtracciones(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error en la petición",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> manejadorPostRecursoAtraccion(@RequestBody Atraccion a){
        try {
            cps.guardarAtraccion(a);;
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error al intentar crear la nueva atraccion",HttpStatus.FORBIDDEN);            
        }
    }
    @RequestMapping(path="/atracciones/{atraccion}",method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoAtraccion(@PathVariable("atraccion") int atraccion){
        try {
            return new ResponseEntity<>(cps.getAtraccion(atraccion),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        } 
    }


    
}