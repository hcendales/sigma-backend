package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ServicioOE;

public interface IServicioDTO {
	public ObjetoSalida consultarRadicadoOrfeo(ServicioOE OE);
}
