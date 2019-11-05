package edu.eci.arsw.chillpark.repository.custom;



import javax.transaction.Transactional;

import edu.eci.arsw.chillpark.model.Atraccion;


public interface AtraccionRepositoryCustom {
    
    
    @Transactional
    public void changeState(Atraccion a,int id);

    

}