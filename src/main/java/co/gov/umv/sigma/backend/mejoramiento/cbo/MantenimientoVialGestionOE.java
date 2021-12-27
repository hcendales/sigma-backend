package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialGestion;

public class MantenimientoVialGestionOE extends ObjetoEntrada {

	private static final long serialVersionUID = -6280668516531161021L;
	private TabMantenimientoVialGestion mantenimientoVialGestion;
	public TabMantenimientoVialGestion getMantenimientoVialGestion() {
		return mantenimientoVialGestion;
	}
	public void setMantenimientoVialGestion(TabMantenimientoVialGestion mantenimientoVialGestion) {
		this.mantenimientoVialGestion = mantenimientoVialGestion;
	}
}
