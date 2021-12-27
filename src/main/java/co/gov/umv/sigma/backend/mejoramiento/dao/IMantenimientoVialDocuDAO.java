package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;

public interface IMantenimientoVialDocuDAO {
	public ObjetoSalida insertar(MantenimientoVialDocuOE OE);
	public ObjetoSalida actualizar(MantenimientoVialDocuOE OE);
	public ObjetoSalida eliminar(MantenimientoVialDocuOE OE);
	public ObjetoSalida consultarXFiltro(MantenimientoVialDocuOE OE);
}
