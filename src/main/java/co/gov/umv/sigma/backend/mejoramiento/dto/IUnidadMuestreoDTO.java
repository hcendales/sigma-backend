package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.UnidadMuestreoOE;

public interface IUnidadMuestreoDTO {
	public ObjetoSalida insertar(UnidadMuestreoOE OE);
	public ObjetoSalida actualizar(UnidadMuestreoOE OE);
	public ObjetoSalida eliminar(UnidadMuestreoOE OE);
	public ObjetoSalida consultarXFiltro(UnidadMuestreoOE OE);
	public ObjetoSalida consultarIdMantenimiento(UnidadMuestreoOE OE);
	public ObjetoSalida actualizarPCI(UnidadMuestreoOE OE);
	public ObjetoSalida actualizarCampo(UnidadMuestreoOE OE);
}
