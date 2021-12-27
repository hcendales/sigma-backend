package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabTipoDirectorZona {

	private Long 	idTipoDirectorZona;
	private Long 	idTipoZonacobertura;
	private Long 	idPersonaDirector;
	private Long 	idTipoCargo;
	private Long 	idTipoRol;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	
	public Long getIdTipoDirectorZona() {
		return idTipoDirectorZona;
	}
	public void setIdTipoDirectorZona(Long idTipoDirectorZona) {
		this.idTipoDirectorZona = idTipoDirectorZona;
	}
	public Long getIdTipoZonacobertura() {
		return idTipoZonacobertura;
	}
	public void setIdTipoZonacobertura(Long idTipoZonacobertura) {
		this.idTipoZonacobertura = idTipoZonacobertura;
	}
	public Long getIdPersonaDirector() {
		return idPersonaDirector;
	}
	public void setIdPersonaDirector(Long idPersonaDirector) {
		this.idPersonaDirector = idPersonaDirector;
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
	
	
}
