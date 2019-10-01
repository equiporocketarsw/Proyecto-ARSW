package edu.eci.arsw.chillpark.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tiquete")
public class Tiquete implements Serializable{

        private static final long serialVersionUID = 1L;
        
        
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
