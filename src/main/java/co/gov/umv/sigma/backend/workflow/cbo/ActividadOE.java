package co.gov.umv.sigma.backend.workflow.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabActividad;

public class ActividadOE extends ObjetoEntrada {
	private TabActividad actividad;

	public TabActividad getActividad() {
		return actividad;
	}

	public void setActividad(TabActividad actividad) {
		this.actividad = actividad;
	}
}
