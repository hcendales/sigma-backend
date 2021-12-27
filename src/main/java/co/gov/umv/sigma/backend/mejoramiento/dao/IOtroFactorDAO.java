package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.OtroFactorOE;

public interface IOtroFactorDAO {
	public ObjetoSalida insertar(OtroFactorOE OE);
	public ObjetoSalida actualizar(OtroFactorOE OE);
	public ObjetoSalida eliminar(OtroFactorOE OE);
	public ObjetoSalida consultarXFiltro(OtroFactorOE OE);
}
