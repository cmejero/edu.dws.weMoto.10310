package servicios;

import java.util.Scanner;

import controladores.Inicio;
import dtos.ClubDto;

/**
 * Clase que se encarga de implementar a club interfaz * /**
 * Clase que se encarga de los datos de los club
 * @author CMR - 10/10/24
 */
 
public class ClubImplementacion implements ClubInterfaz {

	FicheroInterfaz fi = new FicheroImplementacion();
	
	public void altaClub(Scanner sc) {

		long idClub = crearIdClub();
		long numeroClub = idClub;
		System.out.println("Introduzca el nombre del club");
		String nombreClub = sc.next();
		System.out.println("Introduzca el codigo de acceso");
		String codigo = sc.next();
		
		
		ClubDto nuevoClub = new ClubDto(idClub, nombreClub, codigo, numeroClub);

		Inicio.listaClub.add(nuevoClub);

	}

	/**
	 * Metodo que se encarga de generar un id del club de manera automatica
	 * @author CMR - 10/10/24
	 * @return el valor del id
	 */
	private long crearIdClub() {

		long nuevoId;
		int tamanioLista = Inicio.listaClub.size();

		if (tamanioLista == 0) {

			nuevoId = 1;

		} else {
			nuevoId = Inicio.listaClub.get(tamanioLista - 1).getIdClub() + 1;
		}
		return nuevoId;
	}
	
	

	public void modificarClub(Scanner sc) {
		MenuInterfaz mi = new MenuImplementacion();
		
		for (ClubDto club : Inicio.listaClub) {

			System.out.println(club.toString());
		}


		System.out.println("Introduzca el numero del club a modificar");
		long numero = sc.nextLong();
		int opcionUsuario;

		boolean esCerrar = false;
		String respuesta = "";
		
		for (ClubDto club : Inicio.listaClub) {

			if (numero == club.getNumeroClub()) {

				System.out.println(club.toString());
				do {
					try {
					opcionUsuario = mi.menuModificarClub(sc);

					switch (opcionUsuario) {
					case 0:
						System.out.println("Has seleccionado volver");
						fi.escribirFicheroLog("Has seleccionado volver");
						esCerrar = true;
						break;

					case 1:
						System.out.println("Has seleccionado nuevo nombre del club");
						fi.escribirFicheroLog("Has seleccionado nuevo nombre del club");
						String nombreClub = sc.next();
						club.setNombreClub(nombreClub);
						break;

					case 2:

						System.out.println("Has seleccionado nuevo código inscripción");
						fi.escribirFicheroLog("Has seleccionado nuevo código inscripción");
						String espacio = sc.nextLine();
						String codigo = sc.nextLine();
						club.setCodigo(codigo);
						break;
					
					default:
						System.out.println("La opcion introducida no corresponde con ninguna");
						fi.escribirFicheroLog("La opcion introducida no corresponde con ninguna");
						break;
					}
					
					System.out.println("¿Quieres seguir modificando: s/n?");
					respuesta = sc.next();
					
					}catch(Exception e) {
						System.out.println("Se ha producido un error, intentelo más tarde");
						fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
						
					}finally {
						
					}
				} while (!esCerrar & !respuesta.equalsIgnoreCase("n"));

			} else {
				System.out.println("El nombre de club introducido no existe");
			}
		}
	}

	public void eliminarClub(Scanner sc) {

		for (ClubDto club : Inicio.listaClub) {

			System.out.println(club.toString());
		}
		System.out.println("Introduce el numero del club que quieres ");
		String numeroString = sc.next(); 
		
		long numero = Long.parseLong(numeroString);

		boolean esBorrar = false;
		ClubDto aux = new ClubDto();
		
		for (ClubDto club : Inicio.listaClub) {
			if (numero == club.getNumeroClub()) {
				aux = club;
				esBorrar = true;
				break;
					
			}
			
			
		}
		
		if(esBorrar == true) {
			 Inicio.listaClub.remove(aux);
			 System.out.println("El usuario ha sido eliminado con exito");
			
		}
		else {System.out.println("El usuario introducido no existe, intentelo de nuevo");}
		
		for (ClubDto club : Inicio.listaClub) {

			System.out.println(club.toString());
		}
	}
}
