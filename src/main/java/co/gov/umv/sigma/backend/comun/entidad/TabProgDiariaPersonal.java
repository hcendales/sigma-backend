package co.gov.umv.sigma.backend.comun.entidad;

public class TabProgDiariaPersonal {

	private Long 	idProgdiariaPersonal;
	private Long 	idProgramacionDiaria;
	private Long 	idTipoRol;
	private Long 	idTipoOrigen;
	private Long 	cantidad;
	private Long    idPersona;
	
	public Long getIdProgdiariaPersonal() {
		return idProgdiariaPersonal;
	}
	public void setIdProgdiariaPersonal(Long idProgdiariaPersonal) {
		this.idProgdiariaPersonal = idProgdiariaPersonal;
	}
	public Long getIdProgramacionDiaria() {
		return idProgramacionDiaria;
	}
	public void setIdProgramacionDiaria(Long idProgramacionDiaria) {
		this.idProgramacionDiaria = idProgramacionDiaria;
	}
	public Long getIdTipoRol() {
		return idTipoRol;
	}
	public void setIdTipoRol(Long idTipoRol) {
		this.idTipoRol = idTipoRol;
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
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
	
}
