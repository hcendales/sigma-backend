package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabZonaCoberturaPersona {

	private Long 	idZonaCoberturapersona;
	private Long 	idTipoZonaCobertura;
	private Long 	idPersona;
	private Long 	idTipoCargo;
	private Long 	idTipoRol;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	
	
	public Long getIdZonaCoberturapersona() {
		return idZonaCoberturapersona;
	}
	public void setIdZonaCoberturapersona(Long idZonaCoberturapersona) {
		this.idZonaCoberturapersona = idZonaCoberturapersona;
	}
	public Long getIdTipoZonaCobertura() {
		return idTipoZonaCobertura;
	}
	public void setIdTipoZonaCobertura(Long idTipoZonaCobertura) {
		this.idTipoZonaCobertura = idTipoZonaCobertura;
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
	
	
}
