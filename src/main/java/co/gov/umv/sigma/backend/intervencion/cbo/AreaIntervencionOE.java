package co.gov.umv.sigma.backend.intervencion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabAreaIntervencion;

public class AreaIntervencionOE extends ObjetoEntrada {
	private TabAreaIntervencion areaIntervencion;

	public TabAreaIntervencion getAreaIntervencion() {
		return areaIntervencion;
	}

	public void setAreaIntervencion(TabAreaIntervencion areaIntervencion) {
		this.areaIntervencion = areaIntervencion;
	}
	
}
