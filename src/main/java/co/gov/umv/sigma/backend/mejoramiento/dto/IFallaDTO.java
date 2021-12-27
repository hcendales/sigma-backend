package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FallaOE;

public interface IFallaDTO {
	public ObjetoSalida insertar(FallaOE OE);
	public ObjetoSalida actualizar(FallaOE OE);
	public ObjetoSalida eliminar(FallaOE OE);
	public ObjetoSalida consultarXFiltro(FallaOE OE);
	public ObjetoSalida consultarIdUnidadMuestreo(FallaOE OE);
}
