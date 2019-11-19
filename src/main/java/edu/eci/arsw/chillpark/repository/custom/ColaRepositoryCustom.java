package edu.eci.arsw.chillpark.repository.custom;

import java.util.List;

import javax.transaction.Transactional;

import edu.eci.arsw.chillpark.model.Atraccion;
import edu.eci.arsw.chillpark.model.Tiquete;


public interface ColaRepositoryCustom {
    
    
    @Transactional
    public List<Tiquete> findByAtraccion(int atraccion);

    @Transactional
    public List<Atraccion> findByUsuario(int tiquete);

    
}