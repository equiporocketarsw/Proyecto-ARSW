package edu.eci.arsw.chillpark.model;

import java.io.Serializable;
import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
        
	ArrayList<Atraccion> atracciones;
	ArrayList<Tiquete> tiquetes;
	public Usuario() {
            /*
		atracciones = new ArrayList<Atraccion>();	
		tiquetes = new ArrayList<Tiquete>();*/
	}

	public ArrayList<Atraccion> getAtracciones(){
		return atracciones;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones){
		this.atracciones = atracciones;
	}

	public ArrayList<Tiquete> getTiquetes(){
		return tiquetes;
	}

	public void setTiquetes(ArrayList<Tiquete> tiquetes){
		this.tiquetes = tiquetes;
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
