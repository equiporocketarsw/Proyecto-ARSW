package edu.eci.arsw.chillpark.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;
	ArrayList<Atraccion> atracciones;
	ArrayList<Tiquete> tiquetes;
	public Usuario() {
		atracciones = new ArrayList<Atraccion>();	
		tiquetes = new ArrayList<Tiquete>();
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
	
}
