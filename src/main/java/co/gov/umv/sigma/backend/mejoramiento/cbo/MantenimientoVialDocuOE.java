package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabMantenimientoVialDocu;

public class MantenimientoVialDocuOE extends ObjetoEntrada {

	private static final long serialVersionUID = -4620143811366594076L;
	private TabMantenimientoVialDocu mantenimientoVialDocu;
	public TabMantenimientoVialDocu getMantenimientoVialDocu() {
		return mantenimientoVialDocu;
	}
	public void setMantenimientoVialDocu(TabMantenimientoVialDocu mantenimientoVialDocu) {
		this.mantenimientoVialDocu = mantenimientoVialDocu;
	}
	

}
