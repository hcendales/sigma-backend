package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RadicadoVinculadoOE;

public interface IRadicadoVinculadoDTO {
	public ObjetoSalida insertar(RadicadoVinculadoOE OE);
	public ObjetoSalida actualizar(RadicadoVinculadoOE OE);
	public ObjetoSalida eliminar(RadicadoVinculadoOE OE);
	public ObjetoSalida consultarXFiltro(RadicadoVinculadoOE OE);
}
