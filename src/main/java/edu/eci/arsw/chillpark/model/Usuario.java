package edu.eci.arsw.chillpark.model;

import java.io.Serializable;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        
        
	@Id
        @Column(name="username")
	private String username;
        
        @Column(name="rol")
        private String rol;
        
        
        @Column(name="contrasena")
        private String contrasena;
        
        
        

	public Usuario() {
         
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
        
        public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
        
        public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
