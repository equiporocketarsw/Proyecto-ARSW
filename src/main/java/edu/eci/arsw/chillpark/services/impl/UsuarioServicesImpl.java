/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services.impl;

import edu.eci.arsw.chillpark.persistence.ChillParkPersistenceException;
import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.repository.UsuarioRepository;
import edu.eci.arsw.chillpark.services.UsuarioServices;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2128408
 */

@Service("usuarioservices")
public class UsuarioServicesImpl implements UsuarioServices{
    
    
    @Autowired
    private UsuarioRepository userrepo;
    
    @Override
    public Usuario addUser(Usuario user) throws ChillParkPersistenceException{
        try {
            Usuario u = getUsuario(user.getUsername());
            throw new ChillParkPersistenceException("Nombre de usuario ya tomado");
        }
        catch(ChillParkNotFoundException ce){

            return userrepo.saveAndFlush(user);
        }
        
  
    }
    
    @Override
    public List<Usuario> getAllUsers(){
        return userrepo.findAll(); 
    }
   
    @Override
    public Usuario getUsuario(String username) throws ChillParkNotFoundException{
        try{
            Usuario user = userrepo.findById(username).get();
            return user;
        }
        catch(java.util.NoSuchElementException e){
           throw new ChillParkNotFoundException("No existe el usuario");
        }
           
    }
    
}
