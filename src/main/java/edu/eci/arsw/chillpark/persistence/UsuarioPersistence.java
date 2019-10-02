/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.persistence;

import edu.eci.arsw.chillpark.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 2128408
 */
public interface UsuarioPersistence {
    
    public void guardarUsuario(Usuario u);
    
    public Usuario getUsuario(int i);
    
    public ArrayList<Usuario> getUsuarios();
    
}
