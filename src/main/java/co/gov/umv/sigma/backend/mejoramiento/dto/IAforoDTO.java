package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;

public interface IAforoDTO {
	public ObjetoSalida nuevoAforo(AforoOE OE);
	public ObjetoSalida insertar(AforoOE OE);
	public ObjetoSalida actualizar(AforoOE OE);
	public ObjetoSalida eliminar(AforoOE OE);
	public ObjetoSalida consultarXFiltro(AforoOE OE);
	public ObjetoSalida analisisAforo(AforoOE OE);
}
