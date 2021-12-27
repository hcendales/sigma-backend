package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabFalla;

public class FallaOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6106888576653482511L;
	private TabFalla falla;

	public TabFalla getFalla() {
		return falla;
	}

	public void setFalla(TabFalla falla) {
		this.falla = falla;
	}
	
}
