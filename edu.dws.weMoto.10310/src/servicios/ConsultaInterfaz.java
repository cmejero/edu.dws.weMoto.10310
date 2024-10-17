package servicios;

import java.sql.Connection;
import java.util.Scanner;

import dtos.ClubDto;
import dtos.UsuarioDto;

public interface ConsultaInterfaz {

	
	public void altaUsuarioBSDT(Scanner sc);
	public void modificarUsuarioBSDT(Scanner sc);
	public void EliminarUsuarioBSDT( Scanner sc);
	public void altaClubBSDT(Scanner sc);
	public void modificarClubBSDT (Scanner sc);
	public void EliminarClubBSDT(Scanner sc);
	
}
