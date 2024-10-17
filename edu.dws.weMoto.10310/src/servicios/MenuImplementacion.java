package servicios;

import java.util.Scanner;

/**
 * Clase que se encarga de implementar al menu interfaz
 * @author CMR - 10/10/24	 
 */
public class MenuImplementacion implements MenuInterfaz {

	FicheroInterfaz fi = new FicheroImplementacion();
	
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
		
		ConsultaInterfaz ci = new ConsultaImplementacion();
		
		int opcion;
		boolean esVolver = false;
		do {
			try {
				opcion = menuYseleccionUsuarios(sc);
				switch (opcion) {

				case 0:
					System.out.println("Has seleccionado volver");
					fi.escribirFicheroLog("Has seleccionado volver");
					esVolver = true;
					break;

				case 1:
					System.out.println("Has seleccionado dar alta usuario");
					fi.escribirFicheroLog("Has seleccionado dar alta usuario");
					ci.altaUsuarioBSDT(sc);
					break;

				case 2:
					System.out.println("Has seleccionado modificar usuario ");
					fi.escribirFicheroLog("Has seleccionado modificar usuario");
					ci.modificarUsuarioBSDT(sc);
					break;

				case 3:
					System.out.println("Has seleccionado eliminar usuario");
					fi.escribirFicheroLog("Has seleccionado eliminar usuario");
					ci.EliminarUsuarioBSDT( sc);
					break;

				default:
					System.out.println("La opcion seleccionada no correspone con ninguna");
					fi.escribirFicheroLog("La opcion seleccionada no correspone con ninguna");
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Se ha producido un error, intentelo más tarde");
				fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
				
			}finally {}
		} while (!esVolver);

	}

	public void menuClub(Scanner sc) {
		ConsultaInterfaz ci = new ConsultaImplementacion();
		int opcion;
		boolean esVolver = false;
		do {
			try {

			opcion = menuYseleccionClubes(sc);
			switch (opcion) {

			case 0:
				System.out.println("Has seleccionado volver");
				fi.escribirFicheroLog("Has seleccionado volver");
				esVolver = true;
				break;

			case 1:
				System.out.println("Has seleccionado dar alta club");
				fi.escribirFicheroLog("Has seleccionado dar alta club");
				ci.altaClubBSDT(sc);
				break;

			case 2:
				System.out.println("Has seleccionado modificar club ");
				fi.escribirFicheroLog("Has seleccionado modificar club");
				ci.modificarClubBSDT(sc);
				break;

			case 3:
				System.out.println("Has seleccionado eliminar club");
				fi.escribirFicheroLog("Has seleccionado eliminar club");
				ci.EliminarClubBSDT(sc);
				break;

			default:
				System.out.println("La opcion seleccionada no correspone con ninguna");
				fi.escribirFicheroLog("La opcion seleccionada no correspone con ninguna");
				break;
			}
			
			}catch(Exception e) {
				System.out.println("Se ha producido un error, intentelo más tarde");
				fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			}finally {}
			
		} while (!esVolver);

	}

	/**
	 * Metodo que se encarga de mostrar las diferentes opciones del menu usuario
	 * @author CMR - 10/10/24	
	 * @param sc
	 * @return
	 */
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
	
	
	/**
	 * Metodo que se encarga de mostrar las diferentes opciones del menu club
	 * @author CMR - 10/10/24	
	 * @param sc
	 * @return
	 */
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
