package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Inicio;
import dtos.usuarioDto;

public class usuarioImplementacion implements usuarioInterfaz {

	public void altaUsuario(Scanner sc) {

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

		usuarioDto nuevoUsuario = new usuarioDto(idUsuario, nombre, apellidos, dni, fecha);

		Inicio.listaUsuario.add(nuevoUsuario);

	}

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
		menuInterfaz mi = new menuImplementacion();
		
		for (usuarioDto usu : Inicio.listaUsuario) {

			System.out.println(usu.toString());
		}


		System.out.println("Introduce el DNI del usuario que quieres modificar");
		String dni = sc.next();
		int opcionUsuario;

		boolean esCerrar = false;
		String respuesta;
		
		for (usuarioDto usu : Inicio.listaUsuario) {

			if (dni.equals(usu.getDni())) {

				System.out.println(usu.toString());
				do {
					opcionUsuario = mi.menuModificarUsuario(sc);

					switch (opcionUsuario) {
					case 0:
						System.out.println("Has seleccionado volver");
						esCerrar = true;
						break;

					case 1:
						System.out.println("Has seleccionado nuevo nombre");
						String nombre = sc.next();
						usu.setNombreUsuario(nombre);
						break;

					case 2:

						System.out.println("Has seleccionado nuevo apellidos");
						String espacio = sc.nextLine();
						String apellidos = sc.nextLine();
						usu.setApellidosUsuario(apellidos);
						break;

					case 3:
						System.out.println("Has seleccionado nuevo DNI");
						String nuevoDni = sc.next();
						usu.setDni(nuevoDni);
						break;

					case 4:
						System.out.println("Has seleccionado nueva fecha de nacimiento");
						String fecha = sc.next();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate fechaNac = LocalDate.parse(fecha, formatter);
						usu.setFechaNac(fechaNac);
						break;

					default:
						System.out.println("La opcion introducida no corresponde con ninguna");
						break;
					}
					
					System.out.println("¿Quieres seguir modificando: s/n?");
					respuesta = sc.next();
				} while (!esCerrar & !respuesta.equalsIgnoreCase("n"));

			} else {
				System.out.println("El DNI introducido no existe");
			}
		}
	}

	public void eliminarUsuario(Scanner sc) {

		for (usuarioDto usu : Inicio.listaUsuario) {

			System.out.println(usu.toString());
		}
		System.out.println("Introduce el DNI que quieres eliminar");
		String dni = sc.next();

		boolean esBorrar = false;
		usuarioDto aux = new usuarioDto();
		
		for (usuarioDto usu : Inicio.listaUsuario) {
			if (dni.equals(usu.getDni())) {
				aux = usu;
				esBorrar = true;
				break;
					
			}
			else {System.out.println("El usuario introducido no existe, intentelo de nuevo");}
			
		}
		
		if(esBorrar = true) {
			 Inicio.listaUsuario.remove(aux);
			 System.out.println("El usuario ha sido eliminado con exito");
			
		}
		
		for (usuarioDto usu : Inicio.listaUsuario) {

			System.out.println(usu.toString());
		}
	}
}
