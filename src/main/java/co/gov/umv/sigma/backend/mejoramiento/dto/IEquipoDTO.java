package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EquipoOE;

public interface IEquipoDTO {

	public ObjetoSalida insertar(EquipoOE OE);
	public ObjetoSalida actualizar(EquipoOE OE);
	public ObjetoSalida eliminar(EquipoOE OE);
	public ObjetoSalida consultarXFiltro(EquipoOE OE);
}
