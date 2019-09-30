package edu.eci.arsw.chillpark.repository;

import edu.eci.arsw.chillpark.model.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
