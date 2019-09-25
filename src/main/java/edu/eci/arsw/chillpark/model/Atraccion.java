package edu.eci.arsw.chillpark.model;

import java.util.ArrayList;

public class Atraccion {

	ArrayList<Usuario> usuarios;
	String nombre;
	int capacidad;
	int tiempo;
	public Atraccion(String nombre, int capacidad, int tiempo) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tiempo = tiempo;
		usuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}

	public Usuario getUsuario(int i){
		return usuarios.get(i);
	}

	public void setUsuario(ArrayList<Usuario> usuarios){
		this.usuarios = usuarios;
	}
	
	public void addUsuario(Usuario u){
		this.usuarios.add(u);
	}

	 public String getNombre(){
		 return nombre;
	 }

	 public void setNombre(String nombre){
		 this.nombre = nombre;
	 }
	
	public int getCapacidad(){
		return capacidad;
	}

	public void setCapacidad(int capacidad){
		this.capacidad = capacidad;
	}

	public int getTiempo(){
		return tiempo;
	}

	public void setTiempo(int tiempo){
		this.tiempo = tiempo;
	}
}

