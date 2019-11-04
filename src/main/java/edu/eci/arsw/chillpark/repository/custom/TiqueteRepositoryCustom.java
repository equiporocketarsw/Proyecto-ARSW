package edu.eci.arsw.chillpark.repository.custom;

import java.util.List;

import javax.transaction.Transactional;

import edu.eci.arsw.chillpark.model.Tiquete;

public interface TiqueteRepositoryCustom {
    
    @Transactional
    public void postTiquete(Tiquete t);

    @Transactional
    public void updateTiquete(Tiquete t,int id);

    @Transactional
    public List<Tiquete> findbyUser(String user);

    @Transactional
    public List<Tiquete> findByAnybody();

    @Transactional
    public List<Tiquete> findByNull();

}
