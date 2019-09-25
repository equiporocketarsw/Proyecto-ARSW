package edu.eci.arsw.chillpark.model;

import java.util.ArrayList;

public class ChillPark {
	
	ArrayList<Tiquete> tiquetes;
	ArrayList<Atraccion> atracciones;
	public ChillPark() {
		tiquetes = new ArrayList<Tiquete>();
		atracciones = new ArrayList<Atraccion>();
	}
	
	public ArrayList<Tiquete> getTiquetes(){
		return tiquetes;
	}
	
	public Tiquete getTiquete(int i){
		return tiquetes.get(i);
	}
	
	public void setTiquetes(ArrayList<Tiquete> tiquetes){
		this.tiquetes = tiquetes;
	}

	public void addTiquete(Tiquete t){
		this.tiquetes.add(t);
	}
	
	public ArrayList<Atraccion> getAtracciones(){
		return atracciones;
	}
	
	public Atraccion getAtraccion(int i){
		return atracciones.get(i);
	}
	
	public void setAtracciones(ArrayList<Atraccion> atracciones){
		this.atracciones = atracciones;
	}

	public void addAtraccion(Atraccion a){
		this.atracciones.add(a);
	}
	
}
