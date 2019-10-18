package edu.eci.arsw.chillpark.repository.custom;

import javax.transaction.Transactional;

import edu.eci.arsw.chillpark.model.Tiquete;

public interface TiqueteRepositoryCustom {
    
    @Transactional
    public void postTiquete(Tiquete t);

    @Transactional
    public void updateTiquete(Tiquete t,int id);
}
