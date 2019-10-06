/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.controllers;

import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkException;
import edu.eci.arsw.chillpark.services.ChillParkServices;
import edu.eci.arsw.chillpark.services.UsuarioServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class UsuarioAPIController {
    
    @Autowired
    @Qualifier("usuarioservices")
    UsuarioServices us;
    
 
    
    @RequestMapping("/usuario")
	public Iterable<Usuario> getPersons() {
        return us.getAllUsers();
    }
     
        
    @RequestMapping(method = RequestMethod.GET, value = "/usuario/{usuario}")
    public ResponseEntity<?> getUsuario(@PathVariable(name = "usuario") String username) {
        try {
            //obtener datos que se enviaran a traves del API
            Usuario user = us.getUsuario(username);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }  
    
    /*
    @RequestMapping(method = RequestMethod.POST)	
    public ResponseEntity<?> manejadorPostRecursoUsuario(@RequestBody Usuario usuario){
        
        try {
            us.addUser(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
        }        

    }
*/       
}
