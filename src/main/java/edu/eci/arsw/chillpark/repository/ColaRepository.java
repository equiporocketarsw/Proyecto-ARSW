package edu.eci.arsw.chillpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.chillpark.model.ColaID;
import edu.eci.arsw.chillpark.model.Atraccionusuario;
import edu.eci.arsw.chillpark.repository.custom.ColaRepositoryCustom;



@Repository
public interface ColaRepository extends JpaRepository<Atraccionusuario, ColaID>,ColaRepositoryCustom{

}