package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionImplementacion implements conexionInterfaz {

	
	public void conexionBSDT() {
		
		String url = "jdbc:postgresql://localhost:5432/bsdt_cmr";

		String usuario = "postgres";

		String contraseña = "Carlos120";

		try {

			// Cargar el controlador de la base de datos (opcional desde JDBC 4.0)

			Class.forName("org.postgresql.Driver");

			// Obtener la conexión usando DriverManager

			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

			if (conexion != null) {

				System.out.println("Conexión establecida con éxito.");

				conexion.close();

			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}
	}
}
