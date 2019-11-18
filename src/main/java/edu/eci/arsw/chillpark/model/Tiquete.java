package edu.eci.arsw.chillpark.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tiquete")
@Table(name="tiquete")
public class Tiquete implements Serializable{

        private static final long serialVersionUID = 1L;
        
        
        @Id
        @Column(name="id")
	int id;
        
        @Column(name="tipo")
	String tipo;
        

        @Column(name="fecha")
	Date fecha;
        
        @Column(name="valido")
        boolean valido;
        
        @Column(name="usuario")
        String usuario;
        
	public Tiquete() {
		
	}

	public int getId(){
            return id;
	}
        
        public void setId(int id){
                this.id=id;
        }

	public String getTipo(){
		return tipo;
	}
        
        public void setTipo(String tipo){
                this.tipo=tipo;
        }

	public Date getFecha(){
		return fecha;
	}
        
        public void setFecha(Date fecha){
                this.fecha=fecha;
        }

        public boolean getValido(){
		return valido;
	}
            
	public void setValido(boolean valido){
		this.valido = valido;
	}
        
        public String getUsuario(){
		return usuario;
	}
        
        public void setUsuario(String usuario){
                this.usuario=usuario;
        }
        
}
