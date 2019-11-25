package edu.eci.arsw.chillpark.model;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="atraccion")
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
	String estaturamin;
        
         @Column(name="estaturamax")
	String estaturamax;
         
          @Column(name="tipo")
	String tipo;
        
      
        
	public Atraccion() {
           
	}

	public int getID(){
		return id;
	}

	public void setID(int id){
		this.id=id;
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
         
         
         public String getEstaturamin(){
		return estaturamin;
	}

	public void setEstaturamin(String estaturamin){
		this.estaturamin = estaturamin;
	}
        
        public String getEstaturamax(){
		return estaturamax;
	}

	public void setEstaturamax(String estaturamax){
		this.estaturamax = estaturamax;
	}
        
        
        public String getTipo(){
		 return tipo;
	 }

	 public void setTipo(String tipo){
		 this.tipo = tipo;
	 }
}

