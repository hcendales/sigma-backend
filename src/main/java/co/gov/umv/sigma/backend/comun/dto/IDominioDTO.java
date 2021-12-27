package co.gov.umv.sigma.backend.comun.dto;

import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.DominioGenerico;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public interface IDominioDTO 
{
	public ObjetoSalida consultarDominios(String usuario, int id_lista);
	public List<DominioGenerico> listaDominios(String usuario, int id_lista);
	
}
