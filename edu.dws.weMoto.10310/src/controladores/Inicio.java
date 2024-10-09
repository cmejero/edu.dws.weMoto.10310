package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.clubDto;
import dtos.usuarioDto;
import servicios.conexionImplementacion;
import servicios.conexionInterfaz;
import servicios.menuImplementacion;
import servicios.menuInterfaz;

public class Inicio {

	public static List<usuarioDto> listaUsuario = new ArrayList<usuarioDto>();
	public static List<clubDto> listaClub = new ArrayList<clubDto>();

	public static void main(String[] args) {

		conexionInterfaz ci = new conexionImplementacion();
		menuInterfaz mi = new menuImplementacion();

		ci.conexionBSDT();
		Scanner sc = new Scanner(System.in);

		int opcionUsuario;
		boolean esCerrar = false;
		do {
			try {

				opcionUsuario = mi.menuYseleccionPrincipal(sc);

				switch (opcionUsuario) {

				case 0:
					System.out.println("Has seleccionado cerrar aplicacion");
					esCerrar = true;
					break;

				case 1:
					System.out.println("Has seleccionado menu usuario");
					mi.menuUsuario(sc);
					break;

				case 2:
					System.out.println("Has seleccionado menu club ");
					mi.menuClub(sc);

					break;

				default:
					System.out.println("La opcion seleccionada no correspone con ninguna");
					break;
				}

			} catch (Exception e) {
			}

		} while (!esCerrar);

	}
}
