package main;

import java.util.Scanner;

import entidad.Coche;
import negocio.GestCar;

public class Main {
	public static void main(String[] args) {
	System.out.println("Bienvenidos a nuestra CRUD de personas");
	Scanner sc = new Scanner(System.in);
	boolean fin = false;
	GestCar gestCar = new GestCar();
	
	do {
		menu();
		int opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			System.out.println("Introduzca los datos del coche(marca/modelo/año/km)");
			String brand = sc.next();
			String model = sc.next();
			int year = sc.nextInt();
			int km = sc.nextInt();
			
			Coche c = new Coche();
			c.setBrand(brand);
			c.setModel(model);
			c.setYear(year);
			c.setKm(km);
			
			boolean add = gestCar.add(c);
			if(add = true) {
				System.out.println("Persona dada de alta");
			}else {
				System.out.println("error");
			}
			break;

		case 0:
			fin = true;
			break;
		}
	}while(!fin);
	
	System.out.println("Fin de programa");

}

private static void menu() {
	System.out.println("Elija una opciï¿½n:");
	System.out.println("1- Alta de persona");
	System.out.println("0- Salir del programa");
}
	
	
	

}


