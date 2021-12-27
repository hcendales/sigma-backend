package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialEvento;

public class MantenimientoVialEventoOE extends ObjetoEntrada {
	private TabMantenimientoVialEvento mantenimientoVialEvento;

	public TabMantenimientoVialEvento getMantenimientoVialEvento() {
		return mantenimientoVialEvento;
	}

	public void setMantenimientoVialEvento(TabMantenimientoVialEvento mantenimientoVialEvento) {
		this.mantenimientoVialEvento = mantenimientoVialEvento;
	}
}
