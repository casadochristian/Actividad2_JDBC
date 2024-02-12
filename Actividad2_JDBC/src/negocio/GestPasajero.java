package negocio;

import java.util.List;

import entidad.Pasajero;
import persistencia.DaoPasajeroMySql;
import persistencia.interfaz.DaoPasajero;

public class GestPasajero {
	private DaoPasajero daoPasajero = new DaoPasajeroMySql();
	
	public boolean add (Pasajero p) {
		boolean add = daoPasajero.addPasajero(p);
		return add;
	}
	
	public boolean delete(int id) {
		boolean delete = daoPasajero.deletePasajeroById(id);
		return delete;
	}
	
	public Pasajero getPasajeroById (int id) {
		Pasajero p = daoPasajero.getPasajeroById(id);
		return p;
	}	
	
	public List<Pasajero> listAll(){
		List<Pasajero> pasajerosLista = daoPasajero.listPasajeros();
		return pasajerosLista;
	}
	public boolean addPasajeroToCoche(Pasajero p) {
		boolean addPasajeroToCoche = daoPasajero.addPasajeroToCoche(p);
		return addPasajeroToCoche;
	}
	
	public boolean deletePasajeroFromCoche(int idPasajero, int idCoche) {
		boolean deletePasajeroFromCoche = daoPasajero.deletePasajeroFromCoche(idPasajero, idCoche);
		return deletePasajeroFromCoche;
	}

	public boolean listPasajerosByCarId (int idCoche) {
		boolean listPasajerosByCarId = daoPasajero.listPasajerosByCarId(idCoche);
		return listPasajerosByCarId;
		
	}
}
