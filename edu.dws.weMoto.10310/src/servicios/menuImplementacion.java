package servicios;

import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

public class menuImplementacion implements menuInterfaz {

	public int menuYseleccionPrincipal(Scanner sc) {
		int opcionUsuario;
		System.out.println("####################");
		System.out.println("0. Cerrar aplicacion");
		System.out.println("1. Menu usuario");
		System.out.println("2. Menu club");
		System.out.println("Elige una opcion");
		System.out.println("####################");

		opcionUsuario = sc.nextInt();
		return opcionUsuario;
	}

	public void menuUsuario(Scanner sc) {
		usuarioInterfaz ui = new usuarioImplementacion();
		int opcion;
		boolean esVolver = false;
		do {

			opcion = menuYseleccionUsuarios(sc);
			switch (opcion) {

			case 0:
				System.out.println("Has seleccionado volver");
				esVolver = true;
				break;

			case 1:
				System.out.println("Has seleccionado dar alta usuario");
				ui.altaUsuario(sc);
				break;

			case 2:
				System.out.println("Has seleccionado modificar usuario ");
				ui.modificarUsuario(sc);
				break;

			case 3:
				System.out.println("Has seleccionado eliminar usuario");
				ui.eliminarUsuario(sc);
				break;

			default:
				System.out.println("La opcion seleccionada no correspone con ninguna");
				break;
			}

		} while (!esVolver);

	}

	public void menuClub(Scanner sc) {
		usuarioInterfaz ui = new usuarioImplementacion();
		int opcion;
		boolean esVolver = false;
		do {

			opcion = menuYseleccionClubes(sc);
			switch (opcion) {

			case 0:
				System.out.println("Has seleccionado volver");
				esVolver = true;
				break;

			case 1:
				System.out.println("Has seleccionado dar alta club");
				ui.altaUsuario(sc);
				break;

			case 2:
				System.out.println("Has seleccionado modificar club ");

				break;

			case 3:
				System.out.println("Has seleccionado eliminar club");

				break;

			default:
				System.out.println("La opcion seleccionada no correspone con ninguna");
				break;
			}

		} while (!esVolver);

	}

	private int menuYseleccionUsuarios(Scanner sc) {

		int opcionUsuario;
		System.out.println("####################");
		System.out.println("0. Volver");
		System.out.println("1. Dar alta usuario");
		System.out.println("2. Modificar usuario");
		System.out.println("3. Eliminar usuario");
		System.out.println("Elige una opcion");
		System.out.println("####################");

		opcionUsuario = sc.nextInt();
		return opcionUsuario;
	}

	private int menuYseleccionClubes(Scanner sc) {

		int opcionUsuario;
		System.out.println("####################");
		System.out.println("0. Volver");
		System.out.println("1. Dar alta club");
		System.out.println("2. Modificar club");
		System.out.println("3. Eliminar club");
		System.out.println("Elige una opcion");
		System.out.println("####################");

		opcionUsuario = sc.nextInt();
		return opcionUsuario;
	}

	public int menuModificarUsuario(Scanner sc) {

		int opcionUsuario;
		System.out.println("####################");
		System.out.println("0. Volver");
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar apellidos");
		System.out.println("3. Modificar DNI");
		System.out.println("4. Modificar fecha de nacimiento");
		System.out.println("Elige una opcion");
		System.out.println("####################");

		opcionUsuario = sc.nextInt();
		return opcionUsuario;

	}
	
	
	
	public int menuModificarClub(Scanner sc) {

		int opcionUsuario;
		System.out.println("####################");
		System.out.println("0. Volver");
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar código");
		System.out.println("Elige una opcion");
		System.out.println("####################");

		opcionUsuario = sc.nextInt();
		return opcionUsuario;

	}

}
