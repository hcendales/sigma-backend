package co.gov.umv.sigma.backend.administracion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabPersona;

public class PersonaOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TabPersona persona;
	
	public TabPersona getPersona() {
		return persona;
	}

	public void setPersona(TabPersona persona) {
		this.persona = persona;
	}

		
	
}
