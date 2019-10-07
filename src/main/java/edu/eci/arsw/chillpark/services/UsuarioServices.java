/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.services;

import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;
import edu.eci.arsw.chillpark.persistence.ChillParkPersistenceException;
import java.util.List;

/**
 *
 * @author Santiago
 */
public interface UsuarioServices {
    public Usuario addUser(Usuario user) throws ChillParkPersistenceException;
    
    public List<Usuario> getAllUsers();
   
    public Usuario getUsuario(String username) throws ChillParkNotFoundException;
}
