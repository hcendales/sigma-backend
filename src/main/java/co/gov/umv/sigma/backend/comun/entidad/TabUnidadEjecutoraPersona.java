package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabUnidadEjecutoraPersona {

	private Long 	idUnidadEjecutoraPersona;
	private Long 	idUnidadEjecutora;
	private Long 	idPersona;
	private Long 	idTipoCargo;
	private Long 	idTipoRol;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	
	
	public Long getIdUnidadEjecutoraPersona() {
		return idUnidadEjecutoraPersona;
	}
	public void setIdUnidadEjecutoraPersona(Long idUnidadEjecutoraPersona) {
		this.idUnidadEjecutoraPersona = idUnidadEjecutoraPersona;
	}
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Long getIdTipoCargo() {
		return idTipoCargo;
	}
	public void setIdTipoCargo(Long idTipoCargo) {
		this.idTipoCargo = idTipoCargo;
	}
	public Long getIdTipoRol() {
		return idTipoRol;
	}
	public void setIdTipoRol(Long idTipoRol) {
		this.idTipoRol = idTipoRol;
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
	public Long getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}
	public void setIdUnidadEjecutora(Long idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}
	
	
	
	
}
