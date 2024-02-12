package entidad;

import java.util.Objects;

public class Pasajero {
	int id;
	String nombre;
	int edad;
	double peso;
	private Coche coche;
	
	public Pasajero() {
		super();
	}
	
	public Pasajero(int id, String nombre, int edad, double peso, Coche coche) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.coche = coche;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Coche getCoche() {
		return coche;
	}
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Pasajero [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", coche=" + coche
				+ "]";
	}
	
	
	
	
	
	
	

}
