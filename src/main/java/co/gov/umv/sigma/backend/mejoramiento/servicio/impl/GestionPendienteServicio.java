package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.CodTipoGestion;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IGestionDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.GestionDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IGestionPendienteServicio;

/**
*
* @author rocio.guio
*/

public class GestionPendienteServicio implements IGestionPendienteServicio {
	
	@Override
	public Response listarPanelGestionPendiente(GestionOE OE)
	{
		IGestionDTO consulta = new GestionDTO();
		ObjetoSalida os = consulta.listarPanelPendiente(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response listarParaRevisarVisitaDiagnostico(GestionOE OE) 
	{
		OE.setIdActividad(4); //para revisar visita diagnostico
		
		IGestionDTO consulta = new GestionDTO();
		ObjetoSalida os = consulta.listarGestionPendiente(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response listarParaValidarVisitaDiagnostico(GestionOE OE) 
	{
		OE.setIdActividad(5); //para validar visita diagnostico
		
		IGestionDTO consulta = new GestionDTO();
		ObjetoSalida os = consulta.listarGestionPendiente(OE);
		
		//imprimirResultado(os);
		
		return Response.status(Response.Status.OK).entity(os).build();
	}	
	
	private void imprimirResultado(ObjetoSalida os)
	{
		try //solo quiero saber cuales llegan
		{
			if(os.esRespuestaOperacionCorrecta())
			{
				int index =0 ; String ids="";
				for(HashMap<String, Object> map : os.getRespuesta())
				{
					ids += "," + Long.parseLong(os.getRespuesta().get(index).get("id_proceso_gestion").toString());
					index++;
				}
				System.out.println( ids);
			}
		}
		catch(Exception e)
		{
			
		}
		
	}

	
	private Response obtenerResponsableVisitaMant(GestionOE OE)
	{
		IGestionDTO consulta = new GestionDTO();
		ObjetoSalida os = consulta.obtenerResponsableVisita(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	@Override
	public Response asignarSolicitudUsuario(GestionOE OE) 
	{
		IGestionDTO gestion = new GestionDTO();
		OE.setTipoGestion(CodTipoGestion.INICIAR);
		ObjetoSalida salida = gestion.gestionarFlujoTrabajo(OE);
		
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response avanzarMantenimientoVial(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		OE.setTipoGestion(CodTipoGestion.AVANZAR);
		ObjetoSalida salida = gestion.gestionarFlujoTrabajo(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response obtenerActividadesDestino(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		OE.setTipoGestion(CodTipoGestion.EVALUAR_TRANSICION);
		ObjetoSalida salida = gestion.gestionarFlujoTrabajo(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response obtenerUsuariosParaAsignarPorActividad(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		OE.setTipoGestion(CodTipoGestion.EVALUAR_ASIGNACION);
		ObjetoSalida salida = gestion.gestionarFlujoTrabajo(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response cambiarAsignacionProceso(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		OE.setTipoGestion(CodTipoGestion.CAMBIAR_ACTOR);
		ObjetoSalida salida = gestion.gestionarFlujoTrabajo(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response obtenerGestionPendientePorIdTransicion(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		ObjetoSalida salida = gestion.obtenerGestionPendientePorIdTransicion(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response obtenerTransicionesPorActividad(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		ObjetoSalida salida = gestion.obtenerTransicionesPorActividad(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}

	
	private Response obtenerKmCarrilImpactoMantenimiento(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		ObjetoSalida salida = gestion.obtenerInfoMantenimiento(OE, "id_mantenimiento_vial,km_carril_impacto" );
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response avanzarMantenimientoVialMasivo(GestionOE OE)
	{
		IGestionDTO gestion = new GestionDTO();
		OE.setTipoGestion(CodTipoGestion.AVANZAR);
		ObjetoSalida salida = gestion.gestionarFlujoTrabajoMasivo(OE);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	@Override
	public Response listarDominio(@QueryParam("dominio")String dominio, @QueryParam("usuario")String usuario)
	{
		IGestionDTO gestion = new GestionDTO();
		//Map<Long,String> salida = gestion.listarDominio( dominio, usuario);
		ObjetoSalida salida = gestion.recuperarDominios( dominio, usuario);
		return Response.status(Response.Status.OK).entity(salida).build();
	}
	
	
	@Override
	public Response listarBandejaGestionPendiente(GestionOE OE) 
	{
		IGestionDTO consulta = new GestionDTO();
		ObjetoSalida os = consulta.listarGestionPendiente(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response obtenerKmCarrilImpactoPorEventos(GestionOE OE) 
	{
		IGestionDTO gestion = new GestionDTO();
		ObjetoSalida os = new ObjetoSalida();
		try
		{
			os = gestion.obtenerKmCarrilImpactoPorEventos(OE);
		}
		catch(Exception e)
		{
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError(e.getMessage());
		}
		
		return Response.status(Response.Status.OK).entity(os).build();
		
	}
	
	
	@Override
	public Response acumularKmCarrilImpactoPorGestion(GestionOE OE) 
	{
		IGestionDTO gestion = new GestionDTO();
		ObjetoSalida os = new ObjetoSalida();
		try
		{
			os = gestion.acumularKmCarrilImpactoPorGestion(OE);
		}
		catch(Exception e)
		{
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError(e.getMessage());
		}
		
		return Response.status(Response.Status.OK).entity(os).build();
		
	}
	
	
	
}
