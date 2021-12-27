package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabEquipoPersona 
{
	private Long 	idEquipoPersona;
	private Long 	idEquipo;
	private Long 	idPersona;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	private String 	observaciones;
	public Long getIdEquipoPersona() {
		return idEquipoPersona;
	}
	public void setIdEquipoPersona(Long idEquipoPersona) {
		this.idEquipoPersona = idEquipoPersona;
	}
	public Long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
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
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
