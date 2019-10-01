package edu.eci.arsw.chillpark.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atraccion")
public class Atraccion implements Serializable{

        private static final long serialVersionUID = 1L;
        
        
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        int id;
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

