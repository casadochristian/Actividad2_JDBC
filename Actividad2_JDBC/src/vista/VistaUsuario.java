package vista;

import java.util.Scanner;

import negocio.GestCar;
import negocio.GestPasajero;

public class VistaUsuario {

	public static void main(String[] args) {
		System.out.println("Bienvenidos a nuestra CRUD de coches");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestCar gc = new GestCar();
		GestPasajero gp = new GestPasajero();
		CarMenu cm = new CarMenu();
		PasajeroMenu pm = new PasajeroMenu();
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				cm.add();
				break;
			case 2:
				cm.delete();
				break;
			case 3:
				cm.getCarById();
				break;
			case 4:
				cm.update();
				break;
			case 5:
				cm.listAll();
				break;
			case 6:
				System.out.println("Bienvenido a la gestión de pasajeros");
				int opcionSubMenu = 0;
					do {
						menuPasajeros();
						opcionSubMenu = sc.nextInt();
						sc.nextLine();
						
						switch (opcionSubMenu){ 
						case 1:
							pm.add();
							break;
						case 2:
							pm.delete();
							break;
						case 3:
							pm.getPasajeroById();
							break;
						case 4:
							pm.listAll();
							break;
						case 5:
							//pm.addPasajeroToCoche();
							break;
						case 6:
							//pm.deletePasajeroFromCoche();
							break;
						case 7:
							//pm.listPasajerosByCarId();
							break;
						case 8:
							System.out.println("Volviendo al menú principal");
						default:
							System.out.println("Opción errónea");
						}
					}while(opcionSubMenu !=8);
				
				break;
			case 0:
				fin = true;
				break;
			}
		}while(!fin);
		
		System.out.println("Fin de programa");

	}

	private static void menu() {
		System.out.println("Elija una opción:");
		System.out.println("1- Añadir un nuevo coche");
		System.out.println("2- Borrar coche por ID");
		System.out.println("3- Consulta coche por ID");
		System.out.println("4- Modificar coches por ID");
		System.out.println("5- Listado de coches");
		System.out.println("6- Gestión de los pasajeros");
		System.out.println("0- Terminar el programa");
	}
	
	private static void menuPasajeros(){
		System.out.println("Elija una opción:");
		System.out.println("1- Crear un nuevo pasajero");
		System.out.println("2- Borrar pssajero por ID");
		System.out.println("3- Consultar pasajero por ID");
		System.out.println("4- Listar todos los pasajeros");
		System.out.println("5- Añadir pasajero a un coche");
		System.out.println("6- Eliminar pasajero de un coche");
		System.out.println("7- Listar todos los pasajeros de un coche");
		System.out.println("8- Volver al menú principal");		
	}
}
