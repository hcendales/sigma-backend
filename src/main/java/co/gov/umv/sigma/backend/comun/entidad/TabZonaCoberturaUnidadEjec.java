package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabZonaCoberturaUnidadEjec {

	private Long 	idZonaCoberturaUnidejec;
	private Long 	idTipoZonaCobertura;
	private Long 	idUnidadEjecutora;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	
	public Long getIdZonaCoberturaUnidejec() {
		return idZonaCoberturaUnidejec;
	}
	public void setIdZonaCoberturaUnidejec(Long idZonaCoberturaUnidejec) {
		this.idZonaCoberturaUnidejec = idZonaCoberturaUnidejec;
	}
	public Long getIdTipoZonaCobertura() {
		return idTipoZonaCobertura;
	}
	public void setIdTipoZonaCobertura(Long idTipoZonaCobertura) {
		this.idTipoZonaCobertura = idTipoZonaCobertura;
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
