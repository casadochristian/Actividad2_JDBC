package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidad.Coche;
import negocio.GestCar;

public class CarMenu {
	
	private GestCar gc = new GestCar();
	private static Scanner sc = new Scanner(System.in);
	
	public void add() {
		System.out.println("Añadiendo un nuevo coche");
		System.out.println("Introduzca la marca del coche");		
		String brand = sc.next();
		System.out.println("Introduzca el modelo del coche");
		String model = sc.next();
		System.out.println("Introduzca el año de fabricación");
		int year = sc.nextInt();
		System.out.println("Introduzca los kilómetros actuales");
		int km = sc.nextInt();
		
		Coche c = new Coche();
		c.setBrand(brand);
		c.setModel(model);
		c.setYear(year);
		c.setKm(km);
		
		boolean add = gc.add(c);
		if(add = true) {
			System.out.println("Coche añadido a la lista");
		}else if(add = false) {
			System.out.println("Error en el proceso");
		}
		
	}
	
	public void delete() {
		System.out.println("Introduzca el ID del coche a borrar.");
		int id = sc.nextInt();
		sc.nextLine();

		boolean delete = gc.delete(id);
		if (delete) {
			System.out.println("Coche con ID " + id + " borrado de la lista");
		} else {
			System.out.println("Error en el proceso");
		}
	}
	
	public void getCarById() {
		System.out.println("Introduzca el ID del coche");
		int id = sc.nextInt();
		sc.nextLine();

		Coche c = gc.getCarById(id);
		if (c == null) {
			System.out.println("El coche no existe");
		} else {
			System.out.println("El coche con id " + id + " es el siguiente : " + c);
		}
	}
	
	public void update() {
		System.out.print("Introduzca el ID del coche que quiere modificar");
		int id = sc.nextInt();
		sc.nextLine();
		
		Coche carCheck = gc.getCarById(id);
		if (carCheck == null) {
			System.out.println("El coche no existe, puede consultar la lista completa en la opción 5");
		}else {

			System.out.print("Introduzca la nueva marca");
			String brand = sc.nextLine();

			System.out.print("Introduzca el nuevo modelo");
			String model = sc.nextLine();

			System.out.print("Introduzca el nuevo año de fabricación");
			int year = sc.nextInt();

			System.out.print("Introduzca los nuevos kilómetros: ");
			int km = sc.nextInt();

			Coche c = new Coche();
			c.setId(id);
			c.setBrand(brand);
			c.setModel(model);
			c.setYear(year);
			c.setKm(km);

			boolean update = gc.update(c);

			if (update) {
			System.out.println("El coche ha sido modificado con los siguientes datos : " + c);
				} else {
			System.out.println("Error en el proceso");
				}
		}
	}

	public void listAll() {
		List<Coche> carList = new ArrayList<>();
		carList = gc.listAll();
		System.out.println("Lista completa de coches : " + carList);
	}

}
