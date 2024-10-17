package servicios;

import java.util.Scanner;

/**
 * Clase que se encarga de las operaciones relacionadas con los clubes
 * @author CMR - 10/10/24
 */
public interface ClubInterfaz {

	/**
	 * Metodo que se encarga de dar de alta a un club
	 * 
	 * @author CMR - 10/10/24
	 */
	public void altaClub(Scanner sc);

	/**
	 * Metodo que se encarga de modificar datos de un club
	 * @author CMR - 10/10/24
	 */
	public void modificarClub(Scanner sc);

	/**
	 * Metodo que se encarga de eliminar a un club
	 * @author CMR - 10/10/24
	 */
	public void eliminarClub(Scanner sc);
}
