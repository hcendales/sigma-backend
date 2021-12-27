package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabTipoDirectorApoyo {

	private Long 	idTipoDirectorApoyo;
	private Long 	idPersonaDirector;
	private Long 	idPersonaApoyo;
	private Long 	idTipoCargoDirector;
	private Long 	idTipoRolDirector;
	private Long 	idTipoCargoApoyo;
	private Long 	idTipoRolApoyo;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	public Long getIdTipoDirectorApoyo() {
		return idTipoDirectorApoyo;
	}
	public void setIdTipoDirectorApoyo(Long idTipoDirectorApoyo) {
		this.idTipoDirectorApoyo = idTipoDirectorApoyo;
	}
	public Long getIdPersonaDirector() {
		return idPersonaDirector;
	}
	public void setIdPersonaDirector(Long idPersonaDirector) {
		this.idPersonaDirector = idPersonaDirector;
	}
	public Long getIdPersonaApoyo() {
		return idPersonaApoyo;
	}
	public void setIdPersonaApoyo(Long idPersonaApoyo) {
		this.idPersonaApoyo = idPersonaApoyo;
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
	public Long getIdTipoCargoApoyo() {
		return idTipoCargoApoyo;
	}
	public void setIdTipoCargoApoyo(Long idTipoCargoApoyo) {
		this.idTipoCargoApoyo = idTipoCargoApoyo;
	}
	public Long getIdTipoRolApoyo() {
		return idTipoRolApoyo;
	}
	public void setIdTipoRolApoyo(Long idTipoRolApoyo) {
		this.idTipoRolApoyo = idTipoRolApoyo;
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
