package edu.eci.arsw.chillpark.model;

import java.io.Serializable;

//import javax.persistence.Embeddable;


public class ColaID implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private int atraccion;
    private int tiquete;
 
    // default constructor
    public ColaID()
    {
        
    }


    public ColaID(int atraccion, int tiquete) {
        this.atraccion = atraccion;
        this.tiquete = tiquete;
    }
 
    public int getAtraccion(){
		return atraccion;
	}

	public void setAtraccion(int atraccion){
		this.atraccion=atraccion;
	}

	 public int getTiquete(){
		 return tiquete;
	 }

	 public void setTiquete(int tiquete){
		 this.tiquete = tiquete;
	 }
}