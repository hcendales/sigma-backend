package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabAlternativaDisenio;
import co.gov.umv.sigma.backend.comun.entidad.TabDisenioCapa;

public class AlternativaOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6106888576653482511L;
	
	private TabAlternativaDisenio alternativa;
	private TabDisenioCapa capa;

	public TabAlternativaDisenio getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(TabAlternativaDisenio alternativa) {
		this.alternativa = alternativa;
	}

	public TabDisenioCapa getCapa() {
		return capa;
	}

	public void setCapa(TabDisenioCapa capa) {
		this.capa = capa;
	}
	
	
	
	
	
}
