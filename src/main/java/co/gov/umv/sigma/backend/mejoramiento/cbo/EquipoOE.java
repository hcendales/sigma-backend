package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabEquipo;
import co.gov.umv.sigma.backend.comun.entidad.TabEquipoPersona;

public class EquipoOE extends ObjetoEntrada 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TabEquipo equipo;
	private TabEquipoPersona persona;
	
	public TabEquipo getEquipo() {
		return equipo;
	}

	public void setEquipo(TabEquipo equipo) {
		this.equipo = equipo;
	}

	public TabEquipoPersona getPersona() {
		return persona;
	}

	public void setPersona(TabEquipoPersona persona) {
		this.persona = persona;
	}

	
	
	
	
}
