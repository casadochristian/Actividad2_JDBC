package negocio;

import java.util.List;

import entidad.Coche;
import persistencia.DaoCarMySql;
import persistencia.interfaz.DaoCar;

public class GestCar {
	
	private DaoCar daoCar = new DaoCarMySql();
	
	public boolean add (Coche c) {
		boolean add = daoCar.addCar(c);
		return add;
	}
	
	public boolean delete(int id) {
		boolean delete = daoCar.deleteCarById(id);
		return delete;
	}
	
	public boolean update (Coche c) {
		boolean update = daoCar.updateCar(c);
		return update;
	}
	
	public Coche getCarById (int id) {
		Coche car = daoCar.getCarById(id);
		return car;
	}
	
	public List<Coche> listAll(){
		List<Coche> carList = daoCar.listCars();
		return carList;
	}
	
	

}
