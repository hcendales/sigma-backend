package co.gov.umv.sigma.backend.administracion.dto;

import co.gov.umv.sigma.backend.administracion.cbo.PersonaOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public interface IPersonaDTO {
	public ObjetoSalida insertar(PersonaOE OE);
	public ObjetoSalida actualizar(PersonaOE OE);
	public ObjetoSalida eliminar(PersonaOE OE);
	public ObjetoSalida consultarXFiltro(PersonaOE OE);
}
