package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabZonaCoberturaEquipo {

	private Long 	idZonaCoberturaEquipo;
	private Long 	idTipoZonaCobertura;
	private Long 	idEquipo;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	
	public Long getIdZonaCoberturaEquipo() {
		return idZonaCoberturaEquipo;
	}
	public void setIdZonaCoberturaEquipo(Long idZonaCoberturaEquipo) {
		this.idZonaCoberturaEquipo = idZonaCoberturaEquipo;
	}
	public Long getIdTipoZonaCobertura() {
		return idTipoZonaCobertura;
	}
	public void setIdTipoZonaCobertura(Long idTipoZonaCobertura) {
		this.idTipoZonaCobertura = idTipoZonaCobertura;
	}
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
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
