package edu.eci.arsw.chillpark.model;

import java.io.Serializable;

import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import edu.eci.arsw.chillpark.model.ColaID;

@Entity
@IdClass(ColaID.class)
@Table(name="atraccionusuario")
public class Atraccionusuario implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="atraccion")
	private int atraccion;

	@Id
    @Column(name="tiquete")
    private int tiquete;
        
        /*
		@EmbeddedId
    	private ColaID colaId;*/
        
       

	public Atraccionusuario() {
         
	}
	/*
	public ColaID getID(){
		return colaId;
	}

	public void setID(ColaID colaId){
		this.colaId=colaId;
	}
*/

	public int getAtraccion(){
		return atraccion;
	}

	public void setAtraccion(int atraccion){
		this.atraccion=atraccion;
	}

	 public int getTiquete(){
		 return tiquete;
	 }

	 public void setTiquete(int Tiquete){
		 this.tiquete = tiquete;
	 }

	 
}
