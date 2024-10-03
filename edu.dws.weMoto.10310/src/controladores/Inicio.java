package controladores;

import servicios.conexionImplementacion;
import servicios.conexionInterfaz;

public class Inicio {

	public static void main(String[] args) {
		
		conexionInterfaz ci = new conexionImplementacion();
		ci.conexionBSDT();

	}

}
