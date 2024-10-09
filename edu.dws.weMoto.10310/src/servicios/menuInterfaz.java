package servicios;

import java.util.Scanner;

public interface menuInterfaz {

	public void menuUsuario(Scanner sc);
	
	public void menuClub(Scanner sc);
	
	public int menuYseleccionPrincipal(Scanner sc);
	
	public int menuModificarUsuario(Scanner sc);
	
	public int menuModificarClub(Scanner sc);
}
