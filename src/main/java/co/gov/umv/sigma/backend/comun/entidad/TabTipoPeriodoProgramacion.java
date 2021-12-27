package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabTipoPeriodoProgramacion 
{
	private Long 	idTipoPeriodoProgramacion;
	private Long 	vigencia;
	private Long 	idTipoPeriodicidad;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	private Long 	diasLaborales;
	private String 	nombrePeriodo;
	
	
	public Long getIdTipoPeriodoProgramacion() {
		return idTipoPeriodoProgramacion;
	}
	public void setIdTipoPeriodoProgramacion(Long idTipoPeriodoProgramacion) {
		this.idTipoPeriodoProgramacion = idTipoPeriodoProgramacion;
	}
	public Long getVigencia() {
		return vigencia;
	}
	public void setVigencia(Long vigencia) {
		this.vigencia = vigencia;
	}
	public Long getIdTipoPeriodicidad() {
		return idTipoPeriodicidad;
	}
	public void setIdTipoPeriodicidad(Long idTipoPeriodicidad) {
		this.idTipoPeriodicidad = idTipoPeriodicidad;
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
	public Long getDiasLaborales() {
		return diasLaborales;
	}
	public void setDiasLaborales(Long diasLaborales) {
		this.diasLaborales = diasLaborales;
	}
	public String getNombrePeriodo() {
		return nombrePeriodo;
	}
	public void setNombrePeriodo(String nombrePeriodo) {
		this.nombrePeriodo = nombrePeriodo;
	}
	
	
}
