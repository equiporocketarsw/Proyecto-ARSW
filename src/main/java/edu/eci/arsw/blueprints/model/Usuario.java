package edu.eci.arsw.blueprints.model;

import java.util.ArrayList;

public class Usuario {
	
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
	
}
