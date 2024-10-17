package servicios;

import java.util.Scanner;

/**
 * Clase que se encarga de los menus de nuestra aplicacion
 * @author CMR - 10/10/24
 */
public interface MenuInterfaz {

	/**
	 * Metodo que se encarga del menu de usuario
	 * @author CMR - 10/10/24
	 * @param sc
	 */
	public void menuUsuario(Scanner sc);
	
	/**
	 * Metodo que se encarga del menu de club
	 * @author CMR - 10/10/24
	 * @param sc
	 */
	public void menuClub(Scanner sc);
	
	/**
	 * Metodo que se encarga del menu principal de la aplicacion
	 * @author CMR - 10/10/24
	 * @param sc
	 */
	public int menuYseleccionPrincipal(Scanner sc);
	
	/**
	 * Metodo que se encarga del menu de modificacion de usuario
	 * @author CMR - 10/10/24
	 * @param sc
	 */
	public int menuModificarUsuario(Scanner sc);
	
	/**
	 * Metodo que se encarga del menu de modificación de club
	 * @author CMR - 10/10/24
	 * @param sc
	 */
	public int menuModificarClub(Scanner sc);
}
