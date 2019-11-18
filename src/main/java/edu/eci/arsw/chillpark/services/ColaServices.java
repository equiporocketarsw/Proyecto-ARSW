package edu.eci.arsw.chillpark.services;

import java.util.List;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.model.Usuario;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;

/**
 *
 * @author Santiago
 */
public interface ColaServices {
    
    public List<Atraccionusuario> getAllQueues();

    public Atraccionusuario getCola(int atraccion,String usuario) throws ChillParkNotFoundException;

    public List<Usuario> findByAtraccion(int atraccion);

    
    public List<Atraccion> findByUsuario(String usuario);

	public void addQueue(Atraccionusuario cola);

}