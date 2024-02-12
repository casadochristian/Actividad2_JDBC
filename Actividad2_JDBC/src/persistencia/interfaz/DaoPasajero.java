package persistencia.interfaz;

import java.util.List;

import entidad.Pasajero;

public interface DaoPasajero {
	//Crear nuevo pasajero
	public boolean addPasajero(Pasajero p);
	//Borrar pasajero por id
	public boolean deletePasajeroById(int id);
	//Consulta pasajero por id
	public Pasajero getPasajeroById(int id);
	//Listar todos los pasajeros
	public List<Pasajero> listPasajeros();
	//añadir pasajero a coche
	public boolean addPasajeroToCoche(Pasajero p);
	//Eliminar pasajero de un coche
	public boolean deletePasajeroFromCoche(int idPasajero, int idCoche);
	//Listar todos los pasajeros de un coche
	public boolean listPasajerosByCarId(int idCoche);

}
