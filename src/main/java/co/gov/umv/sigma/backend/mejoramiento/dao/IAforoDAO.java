package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;

public interface IAforoDAO {
	public ObjetoSalida insertar(AforoOE OE); 
	public ObjetoSalida actualizar(AforoOE OE);
	public ObjetoSalida eliminar(AforoOE OE);
	public ObjetoSalida consultarXFiltro(AforoOE OE);
}
