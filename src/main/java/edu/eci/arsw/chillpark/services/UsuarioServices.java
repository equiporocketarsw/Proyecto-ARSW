/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services;

import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkException;
import edu.eci.arsw.chillpark.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2128408
 */

@Service("usuarioservices")
public class UsuarioServices {
    
    
    @Autowired
    private UsuarioRepository userrepo;
    
    public Usuario addUser(Usuario user){
        return userrepo.saveAndFlush(user);
    }
    
    public List<Usuario> getAllUsers(){
        return userrepo.findAll(); 
    }
   
    public Usuario getUsuario(String username){
           Usuario user = userrepo.findById(username).get();
           return user;
    }
    
}
