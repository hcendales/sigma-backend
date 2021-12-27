package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo;

public class UnidadMuestreoOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3861705936660904427L;
	private TabUnidadMuestreo unidadMuestreo;

	public TabUnidadMuestreo getUnidadMuestreo() {
		return unidadMuestreo;
	}

	public void setUnidadMuestreo(TabUnidadMuestreo unidadMuestreo) {
		this.unidadMuestreo = unidadMuestreo;
	}
}
