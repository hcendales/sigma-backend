package co.gov.umv.sigma.backend.mejoramiento.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public interface ICrudDTO 
{
	public ObjetoSalida insertar(ObjetoEntrada OE);
	public ObjetoSalida actualizar(ObjetoEntrada OE);
	public ObjetoSalida eliminar(ObjetoEntrada OE);
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE);
	
}
