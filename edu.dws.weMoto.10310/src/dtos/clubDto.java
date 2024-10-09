package dtos;

public class clubDto {

	
	long idClub;
	String nombreClub ="aaaaa";
	String codigo ="aaaaa";
	long sede_id;
	
	
	public long getIdClub() {
		return idClub;
	}
	public void setIdClub(long idClub) {
		this.idClub = idClub;
	}
	public String getNombreClub() {
		return nombreClub;
	}
	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public long getSede_id() {
		return sede_id;
	}
	public void setSede_id(long sede_id) {
		this.sede_id = sede_id;
	}
	
	
	public clubDto(long idClub, String nombreClub, String codigo, long sede_id) {
		super();
		this.idClub = idClub;
		this.nombreClub = nombreClub;
		this.codigo = codigo;
		this.sede_id = sede_id;
	}
	
	public clubDto() {
		super();
	}
	
	
	
}
