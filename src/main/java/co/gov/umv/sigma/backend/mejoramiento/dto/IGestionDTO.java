package co.gov.umv.sigma.backend.mejoramiento.dto;

import java.util.Map;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionOE;

/**
*
* @author rocio.guio
*/
public interface IGestionDTO {

	public ObjetoSalida listarGestionPendiente(GestionOE OE);
	public ObjetoSalida listarPanelPendiente(GestionOE OE);
	public ObjetoSalida gestionarFlujoTrabajo(GestionOE OE);
	public ObjetoSalida obtenerGestionPendientePorIdTransicion(GestionOE OE);
	public ObjetoSalida obtenerInfoMantenimiento(GestionOE OE, String campos);
	public ObjetoSalida obtenerResponsableVisita(GestionOE OE);
	public ObjetoSalida gestionarFlujoTrabajoMasivo(GestionOE OE);
	public ObjetoSalida obtenerTransicionesPorActividad(GestionOE OE);
	
	public Map<Long,String> listarDominio(String dominio, String usuario);
	public ObjetoSalida recuperarDominios(String dominio, String usuario);
	public ObjetoSalida obtenerKmCarrilImpactoPorEventos(GestionOE OE) throws Exception ;
	public ObjetoSalida acumularKmCarrilImpactoPorGestion(GestionOE OE) throws Exception ;
	
	
}
