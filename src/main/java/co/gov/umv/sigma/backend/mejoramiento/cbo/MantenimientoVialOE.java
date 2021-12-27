package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVial;

public class MantenimientoVialOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3474443623305226807L;
	private TabMantenimientoVial mantenimientovial;
	private String observacion;
	private Long solicitudRadicado;
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public TabMantenimientoVial getMantenimientovial() {
		return mantenimientovial;
	}

	public void setMantenimientovial(TabMantenimientoVial mantenimientovial) {
		this.mantenimientovial = mantenimientovial;
	}

	public Long getSolicitudRadicado() {
		return solicitudRadicado;
	}

	public void setSolicitudRadicado(Long solicitudRadicado) {
		this.solicitudRadicado = solicitudRadicado;
	}
}
