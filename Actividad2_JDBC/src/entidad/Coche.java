package entidad;

import java.util.Objects;

public class Coche {
	private int id;
	private String marca;
	private String modelo;
	private int año;
	private int km;
	
	public Coche() {
		super();
	}
	
	public Coche(int id, String marca, String modelo, int año, int km) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.km = km;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return marca;
	}

	public void setBrand(String brand) {
		this.marca = brand;
	}

	public String getModel() {
		return modelo;
	}

	public void setModel(String model) {
		this.modelo = model;
	}

	public int getYear() {
		return año;
	}

	public void setYear(int year) {
		this.año = year;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
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
		Coche other = (Coche) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", km=" + km
				+ ", pasajero=" + "]";
	}
	
	

}
