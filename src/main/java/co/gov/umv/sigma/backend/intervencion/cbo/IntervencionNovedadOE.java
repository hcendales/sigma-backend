package co.gov.umv.sigma.backend.intervencion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabIntervencionNovedad;

public class IntervencionNovedadOE extends ObjetoEntrada {
	private TabIntervencionNovedad intervencionNovedad;

	public TabIntervencionNovedad getIntervencionNovedad() {
		return intervencionNovedad;
	}

	public void setIntervencionNovedad(TabIntervencionNovedad intervencionNovedad) {
		this.intervencionNovedad = intervencionNovedad;
	}
	

	
}
