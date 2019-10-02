package edu.eci.arsw.chillpark.repository;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.eci.arsw.chillpark.model.Atraccion;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AtraccionRepository extends JpaRepository<Atraccion, String>{

}
