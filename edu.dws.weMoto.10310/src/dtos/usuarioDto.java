package dtos;

import java.time.LocalDate;

public class usuarioDto {

	long idUsuario;
	String nombreUsuario ="aaaaa";
	String apellidosUsuario = "aaaaa";
	String dni = "aaaaa";
	LocalDate fechaNac ;
	long club_id ;
	long moto_id;
	
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public long getClub_id() {
		return club_id;
	}
	public void setClub_id(long club_id) {
		this.club_id = club_id;
	}
	public long getMoto_id() {
		return moto_id;
	}
	public void setMoto_id(long moto_id) {
		this.moto_id = moto_id;
	}
	
	
	public usuarioDto(long idUsuario, String nombreUsuario, String apellidosUsuario, String dni, LocalDate fechaNac
		) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.dni = dni;
		this.fechaNac = fechaNac;
		
	}
	
	
	public usuarioDto() {
		super();
	}
	@Override
	public String toString() {
		return "usuarioDto [NOMBRE= " + nombreUsuario + ", APELLIDOS= " + apellidosUsuario + ", DNI= " + dni
				+ "]";
	}
	
	
	
}
