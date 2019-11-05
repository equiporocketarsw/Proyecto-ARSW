/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.chillpark.repository;

import edu.eci.arsw.chillpark.model.Tiquete;
import edu.eci.arsw.chillpark.repository.custom.TiqueteRepositoryCustom;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Santiago
 */
@Repository
public interface TiqueteRepository extends JpaRepository<Tiquete, Integer>,TiqueteRepositoryCustom{

    
}
