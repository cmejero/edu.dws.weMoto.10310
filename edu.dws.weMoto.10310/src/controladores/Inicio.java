package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.ClubDto;
import dtos.UsuarioDto;
import servicios.ConexionImplementacion;
import servicios.ConexionInterfaz;
import servicios.FicheroImplementacion;
import servicios.FicheroInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import util.Utiles;

/**
 * Clase principal de nuestra aplicación
 * @author CMR - 10/10/24
 */
public class Inicio {

	public static String rutaArchivo ="C:\\Users\\CMR\\git\\edu.dws.weMoto.10310\\edu.dws.weMoto.10310\\auditoria\\";
	public static String rutaFicheroLog = rutaArchivo.concat(Utiles.nombreFicheroLog());
	public static List<UsuarioDto> listaUsuario = new ArrayList<UsuarioDto>();
	public static List<ClubDto> listaClub = new ArrayList<ClubDto>();

	/**
	 * Metodo principal de entrada de nuestra aplicación
	 * 
	 * @author CMR - 10/10/24
	 * @param args
	 */
	public static void main(String[] args) {

		ConexionInterfaz ci = new ConexionImplementacion();
		MenuInterfaz mi = new MenuImplementacion();
		FicheroInterfaz fi = new FicheroImplementacion();

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
					fi.escribirFicheroLog("Has seleccionado cerrar aplicacion");
					esCerrar = true;
					break;

				case 1:
					System.out.println("Has seleccionado menu usuario");
					fi.escribirFicheroLog("Has seleccionado menu usuario");
					mi.menuUsuario(sc);
					break;

				case 2:
					System.out.println("Has seleccionado menu club ");
					fi.escribirFicheroLog("Has seleccionado menu club");
					mi.menuClub(sc);

					break;

				default:
					System.out.println("La opcion seleccionada no correspone con ninguna");
					fi.escribirFicheroLog("La opcion seleccionada no correspone con ninguna");
					break;
				}

			} catch (Exception e) {
				System.out.println("Se ha producido un error, intentelo más tarde");
				fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			}

		} while (!esCerrar);

	}
}
