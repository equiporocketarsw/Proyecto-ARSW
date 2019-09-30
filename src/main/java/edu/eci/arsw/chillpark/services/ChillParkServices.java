package edu.eci.arsw.chillpark.services;

import edu.eci.arsw.chillpark.repository.UsuarioRepository;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkPersistence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * ChillParkServices
 */
@Service("chillparkservices")
public class ChillParkServices {
    @Autowired 
    @Qualifier("Imp")
    ChillParkPersistence cpp;

    

    @Autowired
    private UsuarioRepository userrepo;

    public Usuario addUser(Usuario user){
        return userrepo.saveAndFlush(user);
    }
    
    public List<Usuario> getAllUsers(){
        return userrepo.findAll(); 
    }
    
    
    public void addTiquete(Tiquete t){
        cpp.guardarTiquete(t);
    }

    public Tiquete getTiquete(int i){
        return cpp.getTiquete(i);
    }
    
    
    
    public ArrayList<Tiquete> getTiquetes(){
        return cpp.getTiquetes();
    }

    public void guardarAtraccion(Atraccion a){
        cpp.guardarAtraccion(a);
    }

    public Atraccion getAtraccion(int i){
        return cpp.getAtraccion(i);
    }

    public ArrayList<Atraccion> getAtracciones(){
        return cpp.getAtracciones();
    }

    
}