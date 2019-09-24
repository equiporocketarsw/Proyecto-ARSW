package edu.eci.arsw.blueprints.model;

import java.util.Date;

public class Tiquete {

	String id;
	String tipo;
	Date fecha;
	public Tiquete(String id, String tipo, Date fecha) {
		this.id = id;
		this.tipo = tipo;
		this.fecha = fecha;
	}

	public String getId(){
		return id;
	}

	public String getTipo(){
		return tipo;
	}

	public Date getFecha(){
		return fecha;
	}

	public void setTipo(String tipo){
		this.tipo = tipo;
	}
}
