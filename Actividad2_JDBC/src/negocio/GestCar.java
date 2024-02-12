package negocio;

import java.util.List;

import entidad.Coche;
import persistencia.DaoCarMySql;
import persistencia.interfaz.DaoCar;

public class GestCar {
	
	private DaoCar daoCar = new DaoCarMySql();
	
	public boolean add (Coche c) {
		if (!c.getBrand().isEmpty() && !c.getModel().isEmpty()) {
			boolean add = daoCar.addCar(c);
			return add;
		}
		return false;
	}
	
	public boolean delete(int id) {
		boolean delete = daoCar.deleteCarById(id);
		return delete;
	}
	
	public boolean update (Coche c) {
		if (!c.getBrand().isEmpty() && !c.getModel().isEmpty()) {
			boolean update = daoCar.updateCar(c);
			return update;
	}
		return false;
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
