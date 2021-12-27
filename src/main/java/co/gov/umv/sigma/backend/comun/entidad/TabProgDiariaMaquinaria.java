package co.gov.umv.sigma.backend.comun.entidad;

public class TabProgDiariaMaquinaria {

	private Long 	idProgdiariaMaquinaria;
	private Long 	idProgramacionDiaria;
	private Long 	idTipoClaseEquipo;
	private Long 	idTipoEquipo;
	private Long 	idTipoOrigen;
	private Long 	cantidad;
	private String 	hora;
	private String 	movil;
	private Long    idTipoUnidadEjecutora;
	
	public Long getIdProgdiariaMaquinaria() {
		return idProgdiariaMaquinaria;
	}
	public void setIdProgdiariaMaquinaria(Long idProgdiariaMaquinaria) {
		this.idProgdiariaMaquinaria = idProgdiariaMaquinaria;
	}
	public Long getIdProgramacionDiaria() {
		return idProgramacionDiaria;
	}
	public void setIdProgramacionDiaria(Long idProgramacionDiaria) {
		this.idProgramacionDiaria = idProgramacionDiaria;
	}
	public Long getIdTipoClaseEquipo() {
		return idTipoClaseEquipo;
	}
	public void setIdTipoClaseEquipo(Long idTipoClaseEquipo) {
		this.idTipoClaseEquipo = idTipoClaseEquipo;
	}
	public Long getIdTipoEquipo() {
		return idTipoEquipo;
	}
	public void setIdTipoEquipo(Long idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}
	public Long getIdTipoOrigen() {
		return idTipoOrigen;
	}
	public void setIdTipoOrigen(Long idTipoOrigen) {
		this.idTipoOrigen = idTipoOrigen;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public Long getIdTipoUnidadEjecutora() {
		return idTipoUnidadEjecutora;
	}
	public void setIdTipoUnidadEjecutora(Long idTipoUnidadEjecutora) {
		this.idTipoUnidadEjecutora = idTipoUnidadEjecutora;
	}
	
	
}
