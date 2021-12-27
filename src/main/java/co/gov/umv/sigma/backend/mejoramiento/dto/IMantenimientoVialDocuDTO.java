package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;

public interface IMantenimientoVialDocuDTO {
	public ObjetoSalida insertar(MantenimientoVialDocuOE OE);
	public ObjetoSalida actualizar(MantenimientoVialDocuOE OE);
	public ObjetoSalida eliminar(MantenimientoVialDocuOE OE);
	public ObjetoSalida consultarXFiltro(MantenimientoVialDocuOE OE);
}
