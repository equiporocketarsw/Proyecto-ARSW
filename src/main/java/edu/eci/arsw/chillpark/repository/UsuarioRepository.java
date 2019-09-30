package edu.eci.arsw.chillpark.repository;

import edu.eci.arsw.chillpark.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
