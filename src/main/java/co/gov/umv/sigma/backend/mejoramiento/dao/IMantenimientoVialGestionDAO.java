package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialGestionOE;

public interface IMantenimientoVialGestionDAO {
	public ObjetoSalida insertar(MantenimientoVialGestionOE OE);
	public ObjetoSalida actualizar(MantenimientoVialGestionOE OE);
	public ObjetoSalida eliminar(MantenimientoVialGestionOE OE);
	public ObjetoSalida consultarXFiltro(MantenimientoVialGestionOE OE);
}
