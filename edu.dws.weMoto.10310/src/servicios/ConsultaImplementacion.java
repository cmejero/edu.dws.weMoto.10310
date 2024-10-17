package servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Inicio;
import dtos.ClubDto;
import dtos.UsuarioDto;

public class ConsultaImplementacion implements ConsultaInterfaz {

	static private Connection connection;

	public ConsultaImplementacion(Connection connection) {
		this.connection = connection;
	}

	public ConsultaImplementacion() {

	}

	FicheroInterfaz fi = new FicheroImplementacion();

	public void altaUsuarioBSDT(Scanner sc) {

		try {

			long nuevoId = crearIdUsuarioBSDT();
			System.out.println("Introduzca el nuevo nombre");
			String nombreUsuarioBSDT = sc.next();
			System.out.println("Introduzca los apellidos");
			String salto = sc.nextLine();
			String apellidosUsuarioBSDT = sc.nextLine();
			System.out.println("Introduzca el DNI");
			String dniUsuarioBSDT = sc.next();
			System.out.println("Introduzca la fecha de nacimiento. formato(dd/MM/yyyy");
			String fechaString = sc.next();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern(fechaString);
			LocalDate fechaNacBSDT = LocalDate.parse(fechaString, formato);

			UsuarioDto nuevoUsuario = new UsuarioDto(nuevoId, nombreUsuarioBSDT, apellidosUsuarioBSDT, dniUsuarioBSDT,
					fechaNacBSDT);

			Inicio.listaUsuario.add(nuevoUsuario);

			String query = "INSERT INTO usuarios (nombre, apellidos, dni, fch_nacimineto, id_usuario) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, nuevoUsuario.getNombreUsuario());
			ps.setString(2, nuevoUsuario.getApellidosUsuario());
			ps.setString(3, nuevoUsuario.getDni());
			ps.setString(4, nuevoUsuario.getFechaNac().toString());
			ps.setString(5, String.valueOf(nuevoUsuario.getIdUsuario()));

			ps.executeUpdate();

			System.out.println("Cliente añadido exitosamente.");

		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}
	}

	public void modificarUsuarioBSDT(Scanner sc) {

		try {

			System.out.println("Introduce el DNI del usuario");
			String dniIntroducido = sc.next();

			for (UsuarioDto usu : Inicio.listaUsuario) {

				if (usu.getDni().equalsIgnoreCase(dniIntroducido)) {

					buscarDniUsuario(dniIntroducido);

					System.out.println("¿Quieres cambiar el nombre? s/n");
					String respuestaN = sc.next();

					if (respuestaN.equalsIgnoreCase("s")) {
						System.out.println("Introduzca el nuevo nombre");
						String nuevoNombre = sc.next();
						usu.setNombreUsuario(nuevoNombre);
						String queryNombre = "UPDATE usuarios SET nombre = ? WHERE dni = ?";
						PreparedStatement psN = connection.prepareStatement(queryNombre);
						psN.setString(1, usu.getNombreUsuario());
						psN.executeUpdate();
						psN.close();

					}

					System.out.println("¿Quieres cambiar el apellidos? s/n");
					String respuestaA = sc.next();

					if (respuestaA.equalsIgnoreCase("s")) {
						System.out.println("Introduzca los apellidos");
						String salto = sc.nextLine();
						String nuevosApellidos = sc.nextLine();
						usu.setApellidosUsuario(nuevosApellidos);
						String queryApellidos = "UPDATE usuarios SET apellidos = ? WHERE dni = ?";
						PreparedStatement psA = connection.prepareStatement(queryApellidos);
						psA.setString(1, usu.getApellidosUsuario());
						psA.executeUpdate();
						psA.close();
					}

					System.out.println("¿Quieres cambiar el DNI? s/n");
					String respuestaD = sc.next();

					if (respuestaD.equalsIgnoreCase("s")) {
						System.out.println("Introduzca el nuevo DNI");
						String nuevoDni = sc.next();
						usu.setDni(dniIntroducido);
						String queryDni = "UPDATE usuarios SET dni = ? WHERE dni = ?";
						PreparedStatement psD = connection.prepareStatement(queryDni);
						psD.setString(1, usu.getDni());
						psD.executeUpdate();
						psD.close();
					}

					System.out.println("¿Quieres cambiar la fecha de nacimiento? s/n");
					String respuestaF = sc.next();

					if (respuestaF.equalsIgnoreCase("s")) {
						System.out.println("Introduzca la fecha de nacimiento");
						String fecha = sc.next();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fecha);
						LocalDate fechaNac = LocalDate.parse(fecha, formatter);
						usu.setFechaNac(fechaNac);
						String queryFechaNac = "UPDATE usuarios SET fch_nacimiento = ? WHERE dni = ?";
						PreparedStatement psF = connection.prepareStatement(queryFechaNac);
						psF.setDate(1, java.sql.Date.valueOf(usu.getFechaNac()));
						psF.executeUpdate();
						psF.close();
					}

				}

			}

		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}

	}

	public void EliminarUsuarioBSDT(Scanner sc) {

		try {

			for (UsuarioDto usuarios : Inicio.listaUsuario) {

				System.out.println(usuarios.toString());
			}

			boolean estaDni = false;
			UsuarioDto aux = new UsuarioDto();
			System.out.println("Introduzca el DNI del usuario que quieres eliminar");
			String dniIntroducido = sc.next();

			for (UsuarioDto usu : Inicio.listaUsuario) {
				if (dniIntroducido.equals(usu.getDni())) {

					aux = usu;
					estaDni = true;

				}

				if (estaDni == true) {

					Inicio.listaUsuario.remove(aux);
					String query = "DELETE FROM usuarios WHERE dni = ?";

					PreparedStatement ps = connection.prepareStatement(query);

					ps.setString(1, dniIntroducido);

					ps.executeUpdate();
					System.out.println("El usuario ha sido borrado correctamente");
				} else {
					System.out.println("El DNI introducido no es correcto, intentelo de nuevo");
				}
			}

		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}

	}

	private long crearIdUsuarioBSDT() {

		long nuevoId;
		int tamanioLista = Inicio.listaUsuario.size();

		if (tamanioLista == 0) {

			nuevoId = 1;

		} else {
			nuevoId = Inicio.listaUsuario.get(tamanioLista - 1).getIdUsuario() + 1;
		}
		return nuevoId;
	}

	private UsuarioDto buscarDniUsuario(String dni) {

		UsuarioDto usu = null;

		try {

			String query = "SELECT * FROM usuarios WHERE dni = ?";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, dni);

			ResultSet rs = ps.executeQuery();
			Date fecha = rs.getDate("fechaNac");
			LocalDate fechaNac = fecha.toLocalDate();

			if (rs.next()) {

				usu = new UsuarioDto(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("dni"), fechaNac);

			}

		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}

		return usu;

	}

	/*
	 * -----------------------------------------------------------------------------
	 * ------------------------------
	 */
	/*
	 * ----------------------------------------- CONSULTAS CLUB
	 * --------------------------------------------------
	 */
	/*
	 * -----------------------------------------------------------------------------
	 * ------------------------------
	 */

	public void altaClubBSDT(Scanner sc) {

		try {

			long idClub = crearIdClubBSDT();
			long numeroClub = idClub;
			System.out.println("Introduzca el nombre del club");
			String nombreClub = sc.next();
			System.out.println("Introduzca el codigo de acceso");
			String codigo = sc.next();

			ClubDto nuevoClub = new ClubDto(idClub, nombreClub, codigo, numeroClub);

			Inicio.listaClub.add(nuevoClub);

			String query = "INSERT INTO clubes (id_club, nombre_club, codigo, numero_club) VALUES (?, ?, ?, ?)";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setLong(1, nuevoClub.getIdClub());
			ps.setString(2, nuevoClub.getNombreClub());
			ps.setString(3, nuevoClub.getCodigo());
			ps.setLong(4, nuevoClub.getNumeroClub());

			ps.executeUpdate();

			System.out.println("Cliente añadido exitosamente.");

		} catch (SQLException e) {

			e.printStackTrace();
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
		}
	}

	public void modificarClubBSDT(Scanner sc) {

		try {

			System.out.println("Introduce el numero del club");
			String numeroString = sc.next();
			long numero = Long.parseLong(numeroString);

			for (ClubDto club : Inicio.listaClub) {

				if (club.getNumeroClub() == numero) {

					buscarNumeroClub(numero);

					System.out.println("¿Quieres cambiar el nombre del club? s/n");
					String respuestaN = sc.next();

					if (respuestaN.equalsIgnoreCase("s")) {
						System.out.println("Introduzca el nuevo nombre del club");
						String nuevoNombre = sc.next();
						club.setNombreClub(nuevoNombre);
						String queryNombre = "UPDATE clubes SET nombre_club = ? WHERE numero_club = ?";
						PreparedStatement psN = connection.prepareStatement(queryNombre);
						psN.setString(1, club.getNombreClub());
						psN.executeUpdate();
						psN.close();

					}

					System.out.println("¿Quieres cambiar el codigo? s/n");
					String respuestaA = sc.next();

					if (respuestaA.equalsIgnoreCase("s")) {
						System.out.println("Introduzca el código");
						String codigo = sc.nextLine();
						club.setCodigo(codigo);
						String queryApellidos = "UPDATE clubes SET codigo = ? WHERE numero_club = ?";
						PreparedStatement psA = connection.prepareStatement(queryApellidos);
						psA.setString(1, club.getCodigo());
						psA.executeUpdate();
						psA.close();
					}

				}

			}

		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}

	}

	public void EliminarClubBSDT(Scanner sc) {

		try {

			for (ClubDto clubes : Inicio.listaClub) {

				System.out.println(clubes.toString());
			}

			boolean estaNumero = false;
			ClubDto aux = new ClubDto();
			System.out.println("Introduzca el numero del club que quieres eliminar");
			String clubString = sc.next();
			long numeroClub = Long.parseLong(clubString);

			for (ClubDto club : Inicio.listaClub) {
				if (club.getNumeroClub() == numeroClub) {

					aux = club;
					estaNumero = true;

				}

				if (estaNumero == true) {

					Inicio.listaClub.remove(aux);
					String query = "DELETE FROM clubes WHERE numero_club = ?";

					PreparedStatement ps = connection.prepareStatement(query);

					ps.setLong(1, numeroClub);

					ps.executeUpdate();
					System.out.println("El club ha sido borrado correctamente");
				} else {
					System.out.println("El numero del club introducido no es correcto, intentelo de nuevo");
				}
			}
		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}

	}

	private ClubDto buscarNumeroClub(Long numero) {

		ClubDto usu = null;

		try {

			String query = "SELECT * FROM clubes WHERE numero_club = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, usu.getNumeroClub());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				usu = new ClubDto(rs.getLong("id_club"), rs.getString("nombre_club"), rs.getString("codigo"),
						rs.getLong("numero_club"));
			}

		} catch (SQLException e) {
			fi.escribirFicheroLog("Se ha producido un error: ".concat(e.getMessage()));
			e.printStackTrace();

		}

		return usu;

	}

	private long crearIdClubBSDT() {

		long nuevoId;
		int tamanioLista = Inicio.listaClub.size();

		if (tamanioLista == 0) {

			nuevoId = 1;

		} else {
			nuevoId = Inicio.listaClub.get(tamanioLista - 1).getIdClub() + 1;
		}
		return nuevoId;
	}

}
