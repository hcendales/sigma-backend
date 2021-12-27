package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabLugar;

public class LugarOE extends ObjetoEntrada 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TabLugar lugar;
	
	public TabLugar getLugar() {
		return lugar;
	}
	public void setLugar(TabLugar lugar) {
		this.lugar = lugar;
	}
	
	
	
}
