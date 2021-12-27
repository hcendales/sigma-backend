package co.gov.umv.sigma.backend.workflow.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class GestionProcesoOE extends ObjetoEntrada {
	private Long idActividad;
	private Long idTipoOrigen;
	private Long idTipoProceso;
	public Long getIdActividad() {
		return idActividad;
	}
	public Long getIdTipoOrigen() {
		return idTipoOrigen;
	}
	public Long getIdTipoProceso() {
		return idTipoProceso;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public void setIdTipoOrigen(Long idTipoOrigen) {
		this.idTipoOrigen = idTipoOrigen;
	}
	public void setIdTipoProceso(Long idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}
	
}
