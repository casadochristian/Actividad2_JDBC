package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidad.Coche;
import entidad.Pasajero;
import negocio.GestCar;
import negocio.GestPasajero;

public class PasajeroMenu {
	private GestPasajero gp = new GestPasajero();
	private static Scanner sc = new Scanner(System.in);
	private GestCar gc = new GestCar();
	
	public void add() {
		System.out.println("Añadiendo un nuevo pasajero");
		System.out.println("Introduzca el nombre del pasajero");		
		String nombre = sc.next();
		System.out.println("Introduzca la edad del pasajero");
		int edad = sc.nextInt();
		System.out.println("Introduzca el peso del pasajero");
		double peso = sc.nextDouble();
		
		Pasajero p = new Pasajero();
		p.setNombre(nombre);
		p.setEdad(edad);
		p.setPeso(peso);
		
		boolean add = gp.add(p);
		if(add = true) {
			System.out.println("Pasajero añadido a la lista");
		}else if(add = false) {
			System.out.println("Error en el proceso");
		}
		
	}
	
	public void delete() {
		System.out.println("Introduzca el ID del pasajero a borrar.");
		int id = sc.nextInt();
		sc.nextLine();

		boolean delete = gp.delete(id);
		if (delete) {
			System.out.println("Pasajero con ID " + id + " borrado de la lista");
		} else {
			System.out.println("Error en el proceso");
		}
	}
	
	public void getPasajeroById() {
		System.out.println("Introduzca el ID del pasajero");
		int id = sc.nextInt();
		sc.nextLine();

		Pasajero p = gp.getPasajeroById(id);
		if (p == null) {
			System.out.println("El pasajero no existe");
		} else {
			System.out.println("El pasajero con id " + id + " es el siguiente : " + p);
		}
	}
	
	public void listAll() {
		List<Pasajero> listPasajeros = new ArrayList<>();
		listPasajeros = gp.listAll();
		System.out.println("Lista completa de pasajeros : " + listPasajeros);
	}
	/**
	public void addPasajeroToCoche() {
		System.out.print("Introduzca el ID del coche para añadir un pasajero");
		int idCoche = sc.nextInt();
		sc.nextLine();
		
		Coche carCheck = gc.getCarById(idCoche);
		if (carCheck == null) {
			System.out.println("El coche no existe, puede consultar la lista completa en la opción 5");
		}else {

			System.out.print("Introduzca el id del pasajero que quiere añadir al coche");
			int idPasajero = sc.nextInt();

			Pasajero p = new Pasajero();
			p.setId(idPasajero);
			p.setCoche();
			
			boolean addPasajeroToCoche = gp.addPasajeroToCoche(p);

			if (addPasajeroToCoche) {
			System.out.println("El pasajero ha sido añadido correctamente : " + p);
				} else {
			System.out.println("Error en el proceso");
				}
		}


			
		}


	
	public void deletePasajeroFromCoche(int idPasajero, int idCoche) {
		return deletePasajeroFromCoche;
	}

	public void listPasajerosByCarId (int idCoche) {
		return listPasajerosByCarId;
		
	}*/
	}
