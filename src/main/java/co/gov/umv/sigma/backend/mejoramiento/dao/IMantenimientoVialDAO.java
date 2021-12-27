package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;

public interface IMantenimientoVialDAO {
	public ObjetoSalida crearMantenimientoVial(MantenimientoVialOE OE);
	public ObjetoSalida insertar(MantenimientoVialOE OE);
	public ObjetoSalida actualizar(MantenimientoVialOE OE);
	public ObjetoSalida eliminar(MantenimientoVialOE OE);
	public ObjetoSalida consultarXFiltro(MantenimientoVialOE OE);
	public ObjetoSalida actualizarPCI(MantenimientoVialOE OE);
	public ObjetoSalida actualizarCampo(MantenimientoVialOE OE);
}
