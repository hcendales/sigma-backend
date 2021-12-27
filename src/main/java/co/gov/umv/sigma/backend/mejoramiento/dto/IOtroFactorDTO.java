package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.OtroFactorOE;

public interface IOtroFactorDTO {
	public ObjetoSalida insertar(OtroFactorOE OE);
	public ObjetoSalida actualizar(OtroFactorOE OE);
	public ObjetoSalida eliminar(OtroFactorOE OE);
	public ObjetoSalida consultarXFiltro(OtroFactorOE OE);
	public ObjetoSalida consultarIdMantenimiento(OtroFactorOE OE);
}
