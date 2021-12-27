package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabTipoResidenteUnidadEjec {

	private Long 	idTipoResidenteUnidadEje;
	private Long 	idTipoUnidadEjecutora;
	private Long 	idPersonaResidente;
	private Long 	idTipoCargoResidente;
	private Long 	idTipoRolResidente;
	private Date 	fechaDesde;
	private Date 	fechaHasta;
	public Long getIdTipoResidenteUnidadEje() {
		return idTipoResidenteUnidadEje;
	}
	public void setIdTipoResidenteUnidadEje(Long idTipoResidenteUnidadEje) {
		this.idTipoResidenteUnidadEje = idTipoResidenteUnidadEje;
	}
	public Long getIdTipoUnidadEjecutora() {
		return idTipoUnidadEjecutora;
	}
	public void setIdTipoUnidadEjecutora(Long idTipoUnidadEjecutora) {
		this.idTipoUnidadEjecutora = idTipoUnidadEjecutora;
	}
	public Long getIdPersonaResidente() {
		return idPersonaResidente;
	}
	public void setIdPersonaResidente(Long idPersonaResidente) {
		this.idPersonaResidente = idPersonaResidente;
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
