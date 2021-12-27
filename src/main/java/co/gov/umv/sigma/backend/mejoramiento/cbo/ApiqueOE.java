package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabPredisenioApique;

public class ApiqueOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6106888576653482511L;
	private TabPredisenioApique apique;
	public TabPredisenioApique getApique() {
		return apique;
	}
	public void setApique(TabPredisenioApique apique) {
		this.apique = apique;
	}

	
	
}
