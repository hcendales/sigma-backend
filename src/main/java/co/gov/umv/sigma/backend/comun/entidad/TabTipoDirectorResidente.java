package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabTipoDirectorResidente {

	private Long 	idTipoDirectorResidente;
	private Long 	idPersonaDirector;
	private Long 	idPersonaResidente;
	private Long 	idTipoCargoDirector;
	private Long 	idTipoRolDirector;
	private Long 	idTipoCargoResidente;
	private Long 	idTipoRolResidente;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	
	public Long getIdTipoDirectorResidente() {
		return idTipoDirectorResidente;
	}
	public void setIdTipoDirectorResidente(Long idTipoDirectorResidente) {
		this.idTipoDirectorResidente = idTipoDirectorResidente;
	}
	public Long getIdPersonaDirector() {
		return idPersonaDirector;
	}
	public void setIdPersonaDirector(Long idPersonaDirector) {
		this.idPersonaDirector = idPersonaDirector;
	}
	public Long getIdPersonaResidente() {
		return idPersonaResidente;
	}
	public void setIdPersonaResidente(Long idPersonaResidente) {
		this.idPersonaResidente = idPersonaResidente;
	}
	public Long getIdTipoCargoDirector() {
		return idTipoCargoDirector;
	}
	public void setIdTipoCargoDirector(Long idTipoCargoDirector) {
		this.idTipoCargoDirector = idTipoCargoDirector;
	}
	public Long getIdTipoRolDirector() {
		return idTipoRolDirector;
	}
	public void setIdTipoRolDirector(Long idTipoRolDirector) {
		this.idTipoRolDirector = idTipoRolDirector;
	}
	public Long getIdTipoCargoResidente() {
		return idTipoCargoResidente;
	}
	public void setIdTipoCargoResidente(Long idTipoCargoResidente) {
		this.idTipoCargoResidente = idTipoCargoResidente;
	}
	public Long getIdTipoRolResidente() {
		return idTipoRolResidente;
	}
	public void setIdTipoRolResidente(Long idTipoRolResidente) {
		this.idTipoRolResidente = idTipoRolResidente;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	
}
