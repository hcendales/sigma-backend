package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;

public interface IMantenimientoVialEventoDAO {
	public ObjetoSalida crearMantenimientoVialEvento(MantenimientoVialEventoOE OE);
	public ObjetoSalida insertar(MantenimientoVialEventoOE OE);
	public ObjetoSalida actualizar(MantenimientoVialEventoOE OE);
	public ObjetoSalida eliminar(MantenimientoVialEventoOE OE);
	public ObjetoSalida consultarXFiltro(MantenimientoVialEventoOE OE);
	public ObjetoSalida actualizarPCI(MantenimientoVialEventoOE OE);
	public ObjetoSalida actualizarCampo(MantenimientoVialEventoOE OE);
	
}
