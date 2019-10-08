package edu.eci.arsw.chillpark.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;

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
        @Column(name="id")
        int id;
	
        
        @Column(name="nombre")
	String nombre;
        
        @Column(name="capacidad")
	int capacidad;
        
        @Column(name="tiempo")
	int tiempo;
        
        
        @Column(name="activo")
	boolean activo;
        
        @Column(name="descripcion")
	String descripcion;
        
         @Column(name="estaturamin")
	int estaturamin;
        
         @Column(name="estaturamax")
	int estaturamax;
         
          @Column(name="tipo")
	String tipo;
        
       /* ArrayList<Usuario> usuarios;*/
        
	public Atraccion() {
            /*
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tiempo = tiempo;
		usuarios = new ArrayList<Usuario>();*/
	}
/*
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
*/
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
        
        
        public boolean isActivo(){
		return activo;
	}

	public void setActivo(boolean activo){
		this.activo = activo;
	}
        
        
        
        public String getDescrpcion(){
		 return descripcion;
	 }

	 public void setDescrpcion(String descripcion){
		 this.descripcion = descripcion;
	 }
         
         
         public int getEstaturamin(){
		return estaturamin;
	}

	public void setEstaturamin(int estaturamin){
		this.estaturamin = estaturamin;
	}
        
        public int getEstaturamax(){
		return estaturamax;
	}

	public void setEstaturamax(int estaturamax){
		this.estaturamax = estaturamax;
	}
        
        
        public String getTipo(){
		 return tipo;
	 }

	 public void setTipo(String tipo){
		 this.tipo = tipo;
	 }
}

