package edu.eci.arsw.chillpark.model;

import java.io.Serializable;

//import javax.persistence.Embeddable;


public class ColaID implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private int atraccion;
    private String usuario;
 
    // default constructor
    public ColaID()
    {
        
    }


    public ColaID(int atraccion, String usuario) {
        this.atraccion = atraccion;
        this.usuario = usuario;
    }
 
    public int getAtraccion(){
		return atraccion;
	}

	public void setAtraccion(int atraccion){
		this.atraccion=atraccion;
	}

	 public String getUsuario(){
		 return usuario;
	 }

	 public void setUsuario(String usuario){
		 this.usuario = usuario;
	 }
}