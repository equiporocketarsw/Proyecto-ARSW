package edu.eci.arsw.chillpark.controllers;

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

import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.services.ColaServices;

/**
 *
 * @author 2133832
 */


@RestController
@RequestMapping(value = "/cola")
 
public class ColaAPIController {
    
    @Autowired
    @Qualifier("colaservices")
    ColaServices cs;
    
    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAtracciones() {
        try{
            return new ResponseEntity<>(cs.getAllQueues(), HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            Logger.getLogger(UsuarioAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
        }  
     }
        
        
    @RequestMapping(path = "/{atraccion}/{tiquete}", method = RequestMethod.GET)
    public ResponseEntity<?> getUsuario(@PathVariable(name = "atraccion") int idatraccion,@PathVariable(name = "tiquete") int tiquete) {
        try {
 
            Atraccionusuario cola = cs.getCola(idatraccion,tiquete);
            return new ResponseEntity<>(cola, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/atraccion/{atraccion}", method = RequestMethod.GET)
    public ResponseEntity<?> getTiquetesByAtraccion(@PathVariable(name = "atraccion") int atraccion) {
        /*try {*/
 
            return new ResponseEntity<>(cs.findByAtraccion(atraccion), HttpStatus.ACCEPTED);

       /* } catch (Exception ex) {
            return new ResponseEntity<>("Error al encontrar usuarios", HttpStatus.NOT_FOUND);
        }*/
    }
    
    @RequestMapping(path = "/tiquete/{tiquete}", method = RequestMethod.GET)
    public ResponseEntity<?> getAtraccionByTiquete(@PathVariable(name = "tiquete") int tiquete) {
        /*try {*/
 
            return new ResponseEntity<>(cs.findByTiquete(tiquete), HttpStatus.ACCEPTED);
/*
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al encontrar atracciones", HttpStatus.NOT_FOUND);
        }
        */
    }

    @RequestMapping(path = "/usuario/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<?> colasByUsers(@PathVariable(name = "usuario") String usuario) {
        /*try {*/
 
            return new ResponseEntity<>(cs.colasByUsuario(usuario), HttpStatus.ACCEPTED);
/*
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al encontrar atracciones", HttpStatus.NOT_FOUND);
        }
        */
    }

    @RequestMapping(path = "/atraccion/{atraccion}/usuario/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<?> colasByAtraccionAndUser(@PathVariable(name = "atraccion") int atraccion, @PathVariable(name = "usuario") String usuario) {
        /*try {*/
 
            return new ResponseEntity<>(cs.colasByAtraccionAndUser(atraccion,usuario), HttpStatus.ACCEPTED);
/*
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al encontrar atracciones", HttpStatus.NOT_FOUND);
        }
        */
    }

    

    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> PostRecursoCola(@RequestBody Atraccionusuario cola){
        
       /* try {*/
            cs.addQueue(cola);
            return new ResponseEntity<>(HttpStatus.CREATED);/*
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);        
        }        */

    }

    @RequestMapping(path = "/atraccion/{atraccion}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteColas(@PathVariable (name = "atraccion") int atraccion) {
    try {
        cs.deleteColas(atraccion);
        return new ResponseEntity<>(HttpStatus.ACCEPTED); 
    } catch (Exception e) {
            Logger.getLogger(ColaAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
    }
}
    
     @RequestMapping(path = "/atraccion/{atraccion}/usuario/{usuario}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletecolasByAtraccionAndUser(@PathVariable(name = "atraccion") int atraccion, @PathVariable(name = "usuario") String usuario) {
        try {
            cs.deletecolasByAtraccionAndUser(atraccion,usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED); 
        } catch (Exception e) {
                Logger.getLogger(ColaAPIController.class.getName()).log(Level.SEVERE, null, e);
                return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
       
    }
    
}