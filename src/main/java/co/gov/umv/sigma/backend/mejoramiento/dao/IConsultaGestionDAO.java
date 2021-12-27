package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionOE;

/**
*
* @author rocio.guio
*/
public interface IConsultaGestionDAO {
	
	public ObjetoSalida listarPanelPendiente(GestionOE OE);
	public ObjetoSalida listarGestionPendiente(GestionOE OE);
	public ObjetoSalida listarPorIdTransicion(GestionOE OE);
	public ObjetoSalida listarTransicionesPorActividad(GestionOE OE);

}
