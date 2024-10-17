package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Inicio;
import dtos.UsuarioDto;

/**
 * Clase que se encarga de implementar al usuario interfaz
 * 
 * @author CMR - 10/10/24
 */
public class UsuarioImplementacion implements UsuarioInterfaz {
	

	public void altaUsuario( Scanner sc) {
		

		long idUsuario = crearIdUsuario();
		System.out.println("Introduzca el nombre");
		String nombre = sc.next();
		System.out.println("Introduzca los apellidos");
		String salto = sc.nextLine();
		String apellidos = sc.nextLine();
		System.out.println("Introduce el DNI");
		String dni = sc.next();
		System.out.println("Introduce fecha de nacimiento, formato dd/MM/yyyy");
		String fechaNac = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(fechaNac, formatter);

		UsuarioDto nuevoUsuario = new UsuarioDto(idUsuario, nombre, apellidos, dni, fecha);

		Inicio.listaUsuario.add(nuevoUsuario);

	}

	/**
	 * Metodo que se encarga de generar un id del usuario de manera automatica
	 * 
	 * @author CMR - 10/10/24
	 * @return el valor del id
	 */
	private long crearIdUsuario() {

		long nuevoId;
		int tamanioLista = Inicio.listaUsuario.size();

		if (tamanioLista == 0) {

			nuevoId = 1;

		} else {
			nuevoId = Inicio.listaUsuario.get(tamanioLista - 1).getIdUsuario() + 1;
		}
		return nuevoId;
	}

	
	public void modificarUsuario(Scanner sc) {
		MenuInterfaz mi = new MenuImplementacion();
		FicheroInterfaz fi = new FicheroImplementacion();



		for (UsuarioDto usu : Inicio.listaUsuario) {

			System.out.println(usu.toString());
		}

		System.out.println("Introduce el DNI del usuario que quieres modificar");
		String dni = sc.next();
		
		
		int opcionUsuario;

		boolean esCerrar = false;
		String respuesta = "";

		for (UsuarioDto usu : Inicio.listaUsuario) {

			if (dni.equals(usu.getDni())) {

				System.out.println(usu.toString());
				do {
					try {
						opcionUsuario = mi.menuModificarUsuario(sc);

						switch (opcionUsuario) {
						case 0:
							System.out.println("Has seleccionado volver");
							fi.escribirFicheroLog("Has seleccionado volver");
							esCerrar = true;
							break;

						case 1:
							System.out.println("Has seleccionado nuevo nombre");
							fi.escribirFicheroLog("Has seleccionado nuevo nombre");
							
							String nombre = sc.next();
							usu.setNombreUsuario(nombre);
							break;

						case 2:

							System.out.println("Has seleccionado nuevo apellidos");
							fi.escribirFicheroLog("Has seleccionado nuevo apellidos");
							String espacio = sc.nextLine();
							String apellidos = sc.nextLine();
							usu.setApellidosUsuario(apellidos);
							break;

						case 3:
							System.out.println("Has seleccionado nuevo DNI");
							fi.escribirFicheroLog("Has seleccionado nuevo DNI");
							String nuevoDni = sc.next();
							usu.setDni(nuevoDni);
							break;

						case 4:
							System.out.println("Has seleccionado nueva fecha de nacimiento");
							fi.escribirFicheroLog("Has seleccionado nueva fecha de nacimiento");
							String fecha = sc.next();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate fechaNac = LocalDate.parse(fecha, formatter);
							usu.setFechaNac(fechaNac);
							break;

						default:
							System.out.println("La opcion introducida no corresponde con ninguna");
							fi.escribirFicheroLog("La opcion introducida no corresponde con ninguna");
							break;
						}

						System.out.println("¿Quieres seguir modificando: s/n?");
						respuesta = sc.next();

					} catch (Exception e) {

						System.out.println("Se ha producido un error, intentelo más tarde");
						fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));

					} finally {

					}

				} while (!esCerrar & !respuesta.equalsIgnoreCase("n"));

			} else {
				System.out.println("El DNI introducido no existe");
			}
		}
	}

	public void eliminarUsuario(Scanner sc) {

		for (UsuarioDto usu : Inicio.listaUsuario) {

			System.out.println(usu.toString());
		}
		System.out.println("Introduce el DNI que quieres eliminar");
		String dni = sc.next();

		boolean esBorrar = false;
		UsuarioDto aux = new UsuarioDto();

		for (UsuarioDto usu : Inicio.listaUsuario) {
			if (dni.equals(usu.getDni())) {
				aux = usu;
				esBorrar = true;
				break;

			}

		}

		if (esBorrar = true) {
			Inicio.listaUsuario.remove(aux);
			System.out.println("El usuario ha sido eliminado con exito");

		} else {
			System.out.println("El usuario introducido no existe, intentelo de nuevo");
		}

		for (UsuarioDto usu : Inicio.listaUsuario) {

			System.out.println(usu.toString());
		}
	}
}
