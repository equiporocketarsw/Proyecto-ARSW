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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2128408
 */


@RestController
@RequestMapping(path = "/Usuario")
public class UsuarioAPIController {
    
    @Autowired
    @Qualifier("usuarioservices")
    UsuarioServices us;
    
    public Iterable<Usuario> getPersona() {
        return us.getAllUsers();
    }
    
    @RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<?> postLogIn(HttpServletRequest req, HttpSession session){
	    try {
	    	Usuario u = us.getCredenciales(req).get();
                
	        ResponseEntity<?> ans = new ResponseEntity<>("Accepted",HttpStatus.ACCEPTED);
	        session.setAttribute("nick", u.getUsername());
	        return ans;
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
        
        
    @RequestMapping(value="/signup", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(HttpServletRequest req,HttpSession session){
		try {
	    	Usuario u= us.createUser(req);
	    	ResponseEntity<?> ans = new ResponseEntity<>("Accepted",HttpStatus.CREATED);
	    	session.setAttribute("nick", u);
	        return ans;
	    } catch (ChillParkException ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }
	}
    
    
}
