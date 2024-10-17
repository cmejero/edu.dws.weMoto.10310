package servicios;

import java.util.Scanner;

import dtos.UsuarioDto;

/**
 * Clase que se encarga de las operaciones relacionadas con los usuarios
 * @author CMR - 10/10/24
 */
public interface UsuarioInterfaz {

	/**
	 * Metodo que se encarga de dar de alta a un usuario
	 * @author CMR - 10/10/24
	 */
	public void altaUsuario(Scanner sc);
	
	/**
	 * Metodo que se encarga de modificar datos de un usuario
	 * @author CMR - 10/10/24
	 */
	public void modificarUsuario(Scanner sc);
	
	/**
	 * Metodo que se encarga de eliminar a un usuario
	 * @author CMR - 10/10/24
	 */
	public void eliminarUsuario(Scanner sc);
}
