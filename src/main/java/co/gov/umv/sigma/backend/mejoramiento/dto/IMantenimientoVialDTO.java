package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;

public interface IMantenimientoVialDTO {
	public ObjetoSalida crearMantenimientoVial(MantenimientoVialOE OE);
	public ObjetoSalida insertar(MantenimientoVialOE OE);
	public ObjetoSalida actualizar(MantenimientoVialOE OE) throws Exception;
	public ObjetoSalida eliminar(MantenimientoVialOE OE);
	public ObjetoSalida consultarXFiltro(MantenimientoVialOE OE);
	public ObjetoSalida consultarId(MantenimientoVialOE OE);
	public ObjetoSalida calcularPCI(MantenimientoVialOE OE);
	public ObjetoSalida actualizarPCI(MantenimientoVialOE OE);
	public ObjetoSalida actualizarCampo(MantenimientoVialOE OE);
}
