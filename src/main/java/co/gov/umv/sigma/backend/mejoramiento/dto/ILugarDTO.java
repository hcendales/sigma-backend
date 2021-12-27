package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.LugarOE;

public interface ILugarDTO {

	public ObjetoSalida insertar(LugarOE OE);
	public ObjetoSalida actualizar(LugarOE OE);
	public ObjetoSalida eliminar(LugarOE OE);
	public ObjetoSalida consultarXFiltro(LugarOE OE);
}
