package edu.eci.arsw.chillpark.repository.custom;

import java.util.List;

import javax.transaction.Transactional;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.model.Tiquete;


public interface ColaRepositoryCustom {
    
    @Transactional
    public void addQueue(Atraccionusuario cola);
    
    @Transactional
    public List<Tiquete> findByAtraccion(int atraccion);

    @Transactional
    public List<Atraccion> findByUsuario(int tiquete);

    @Transactional
    public List<Tiquete> ColasByUsuario(String user);

    @Transactional
    public List <Tiquete> colasByAtraccionAndUser(int atraccion, String usuario);

    @Transactional
    public void deleteColas(int atraccion);
    
    @Transactional
    public void deletecolasByAtraccionAndUser(int atraccion, String usuario);
    
}