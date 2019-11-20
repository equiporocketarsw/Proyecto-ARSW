package edu.eci.arsw.chillpark.services;

import java.util.List;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.persistence.ChillParkNotFoundException;

/**
 *
 * @author Santiago
 */
public interface ColaServices {
    
    public List<Atraccionusuario> getAllQueues();

    public Atraccionusuario getCola(int atraccion,int tiquete) throws ChillParkNotFoundException;

    public List<Tiquete> findByAtraccion(int atraccion);

    
    public List<Atraccion> findByTiquete(int tiquete);

	public void addQueue(Atraccionusuario cola);

    public List<Tiquete> colasByUsuario(String user);

    public List <Tiquete> colasByAtraccionAndUser(int atraccion, String usuario);

}