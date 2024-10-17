package dtos;

/**
 * Clase que se encarga de los datos de los clubes
 * @author CMR - 10/10/24
 */
public class ClubDto {

	
	long idClub;
	String nombreClub ="aaaaa";
	String codigo ="aaaaa";
	long numeroClub;
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
	public long getNumeroClub() {
		return numeroClub;
	}
	public void setNumeroClub(long numeroClub) {
		this.numeroClub = numeroClub;
	}
	public long getSede_id() {
		return sede_id;
	}
	public void setSede_id(long sede_id) {
		this.sede_id = sede_id;
	}
	
	
	public ClubDto(long idClub, String nombreClub, String codigo, long numeroClub) {
		super();
		this.idClub = idClub;
		this.nombreClub = nombreClub;
		this.codigo = codigo;
		this.numeroClub = numeroClub;
	}
	
	
	
	public ClubDto() {
		super();
	}
	@Override
	public String toString() {
		return "ClubDto [nombreClub=" + nombreClub + ", codigo=" + codigo + ", numeroClub=" + numeroClub + ", sede_id="
				+ sede_id + "]";
	}
	
	
	
	
}
