package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RadicadoVinculadoOE;

public interface IRadicadoVinculadoDAO {
	public ObjetoSalida insertar(RadicadoVinculadoOE OE);
	public ObjetoSalida actualizar(RadicadoVinculadoOE OE);
	public ObjetoSalida eliminar(RadicadoVinculadoOE OE);
	public ObjetoSalida consultarXFiltro(RadicadoVinculadoOE OE);
}
