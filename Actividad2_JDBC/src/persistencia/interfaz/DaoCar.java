package persistencia.interfaz;

import java.util.List;

import entidad.Coche;

public interface DaoCar {
	//añadir nuevo coche
	public boolean addCar(Coche c);
	//borrar coche por ID
	public boolean deleteCarById(int id);
	//consulta coche por ID
	public Coche getCarById(int id);
	//modifica coche por ID
	public boolean updateCar(Coche c);
	//Listado de coches
	public List<Coche> listCars();
}
