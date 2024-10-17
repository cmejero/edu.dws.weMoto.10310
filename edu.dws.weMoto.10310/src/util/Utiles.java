package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que se encarga de contener los metodos más repetidos en nuestra aplicación
 * author CMR - 10/10/24
 */
public class Utiles {

	/**
	 * Metodo que se encarga de crear el nombre de nuestros ficheros
	 * author CMR - 10/10/24
	 * @return devuelve el nombre del fichero
	 */
	public static String nombreFicheroLog() {

		String nombreCompleto = "";
		
		try {
			
			LocalDate fecha = LocalDate.now();
			
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			String fechaString = fecha.format(formatter);
			
			nombreCompleto = "log-".concat(fechaString).concat(".txt");
			
			
		}catch(Exception e) {
			
			System.out.println("Se ha producido un error, intentelo más tarde");
		}
			
			return nombreCompleto;
		
	}
}
