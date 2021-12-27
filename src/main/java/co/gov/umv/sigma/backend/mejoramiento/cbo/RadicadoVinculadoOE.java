package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabRadicadoVinculado;

public class RadicadoVinculadoOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2526402861402641337L;
	private TabRadicadoVinculado radicadoVinculado;

	public TabRadicadoVinculado getRadicadoVinculado() {
		return radicadoVinculado;
	}

	public void setRadicadoVinculado(TabRadicadoVinculado radicadoVinculado) {
		this.radicadoVinculado = radicadoVinculado;
	}
}
