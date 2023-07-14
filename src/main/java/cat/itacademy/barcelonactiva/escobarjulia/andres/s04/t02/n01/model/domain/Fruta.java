package cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fruta")

public class Fruta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cantidadQuilos")
	private int cantidadQuilos;

 
	
	
	public Fruta() {
		// TODO Auto-generated constructor stub
	}

	public Fruta(String nombre, int cantidadQuilos) {
		this.nombre = nombre;
		this.cantidadQuilos = cantidadQuilos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadQuilos() {
		return cantidadQuilos;
	}

	public void setCantidadQuilos(int cantidadQuilos) {
		this.cantidadQuilos = cantidadQuilos;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Fruta [id=" + id + ", nombre=" + nombre + ", cantidadQuilos=" + cantidadQuilos + "]";
	}

}
