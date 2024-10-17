package servicios;

import java.io.FileWriter;
import java.io.IOException;

import controladores.Inicio;

/**
 * Clase que se encarga de implementar a ficheros interfaz
 * author CMR - 10/10/24
 */
public class FicheroImplementacion implements FicheroInterfaz {

	public void escribirFicheroLog(String mensaje) {
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(Inicio.rutaFicheroLog, true);
			fw.write(mensaje.concat(" \n"));
			 fw.close();
			
		}catch(IOException io) {
			System.out.println("Se ha producido un error, intentelo más tarde");
			
		}
		
	}
	
}
