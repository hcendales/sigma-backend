package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabOtroFactor;

public class OtroFactorOE extends ObjetoEntrada {

	private static final long serialVersionUID = -1807926833119616736L;
	private TabOtroFactor otroFactor;
	public TabOtroFactor getOtroFactor() {
		return otroFactor;
	}
	public void setOtroFactor(TabOtroFactor otroFactor) {
		this.otroFactor = otroFactor;
	}
}
