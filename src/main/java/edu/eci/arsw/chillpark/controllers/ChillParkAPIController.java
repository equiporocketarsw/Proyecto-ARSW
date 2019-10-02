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

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.JwtResponse;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkException;
import edu.eci.arsw.chillpark.services.ChillParkServices;
import edu.eci.arsw.chillpark.repository.UsuarioRepository;
import edu.eci.arsw.chillpark.services.JwtUserDetailsService;
import edu.eci.arsw.config.JwtTokenUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * ChillParkAPIController
 */
@RestController
@RequestMapping(path = "/chillpark")
public class ChillParkAPIController {
	
	
	
    @Autowired
    @Qualifier("chillparkservices")
    ChillParkServices cps;
    /*
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarios() {
        
        try {
            return new ResponseEntity<>(cps.getAllUsers(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        
    }
    */
    @RequestMapping("/usuario")
	public Iterable<Usuario> getPersona() {
        return cps.getAllUsers();
    }
        
        
    @RequestMapping("/atraccion")
	public Iterable<Atraccion> getAtracciones() {
        return cps.getAllAtractions();
    }
    
        
    @RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseEntity<?> postLogIn(HttpServletRequest req, HttpSession session){
	    try {
	    	Usuario us = cps.getCredenciales(req).get();
                
	        ResponseEntity<?> ans = new ResponseEntity<>("Accepted",HttpStatus.ACCEPTED);
	        session.setAttribute("nick", us.getUsername());
	        return ans;
	    } catch (Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	}
        
        
    @RequestMapping(value="/signup", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(HttpServletRequest req,HttpSession session){
		try {
	    	Usuario us= cps.createUser(req);
	    	ResponseEntity<?> ans = new ResponseEntity<>("Accepted",HttpStatus.CREATED);
	    	session.setAttribute("nick", us);
	        return ans;
	    } catch (ChillParkException ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);            
	    }
	}
        
        
        
     
        @Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Usuario us) throws Exception {

		authenticate(us.getUsername(), us.getContrasena());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(us.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
    /*
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoTiquetes(){
        try {
            return new ResponseEntity<>(cps.getTiquetes(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ChillParkAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error en la peticiÃ³n",HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>("Error en la peticiÃ³n",HttpStatus.NOT_FOUND);
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

*/
    
}