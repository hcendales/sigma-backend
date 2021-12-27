package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ServicioOE;

public interface IServicioDAO {
	public ObjetoSalida consultarRadicadoOrfeo(ServicioOE OE);
}
