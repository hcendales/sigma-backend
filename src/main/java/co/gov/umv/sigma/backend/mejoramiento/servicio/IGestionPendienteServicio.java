package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

/**
*
* @author rocio.guio
*/

@Path("/gestion")
public interface IGestionPendienteServicio 
{
	
	
	@POST
	@JWT
    @Path("/listarPanelGestionPendiente")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response listarPanelGestionPendiente(GestionOE OE);   //{ "usuario":"rocio.guio","idUsuario":1379}

	@POST
	@JWT
	@Path("/listarParaRevisarVisitaDiagnostico")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response listarParaRevisarVisitaDiagnostico(GestionOE OE); //{ "usuario":"rocio.guio","idUsuario":1379}

	
	@POST
	@JWT
	@Path("/asignarSolicitudUsuario")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response asignarSolicitudUsuario(GestionOE OE); //{"usuario":"rocio.guio","idProcesoGestion":431672}

	@POST
	@JWT
	@Path("/avanzarMantenimientoVial")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response avanzarMantenimientoVial(GestionOE OE); //{"usuario":"rocio.guio","idProcesoGestion":431672,"idActividadTransicion":5,"idUsuario":1379,"observacion":"Prueba","enviarCorreo":"SI"}

	
	@POST
	@JWT
	@Path("/obtenerActividadesDestino")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response obtenerActividadesDestino(GestionOE OE); //{"usuario":"rocio.guio","idProcesoGestion":431672}
	
	@POST
	@JWT
	@Path("/obtenerUsuariosParaAsignarPorActividad")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response obtenerUsuariosParaAsignarPorActividad(GestionOE OE); //{"usuario":"rocio.guio","idProcesoGestion":431672,"idActividadTransicion":5}
	
	
	@POST
	@JWT
	@Path("/cambiarAsignacionProceso")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response cambiarAsignacionProceso(GestionOE OE); //{"usuario":"rocio.guio","idProcesoGestion":431672,"idActividadTransicion":6}
	
	
	/******************************* PARA CUS 11 **********************************/
	@POST
	@JWT
	@Path("/listarParaValidarVisitaDiagnostico") 
    @Produces({ MediaType.APPLICATION_JSON})
	public Response listarParaValidarVisitaDiagnostico(GestionOE OE); //{ "usuario":"rocio.guio","idUsuario":1379}
	
	@POST
	@JWT
	@Path("/obtenerGestionPendientePorTransicion")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response obtenerGestionPendientePorIdTransicion(GestionOE OE);  //{"usuario":"rocio.guio", "idUsuario":1379, "idActividad":5,"idActividadTransicion":9}
	
	@POST
	@JWT
	@Path("/obtenerTransicionesPorActividad")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response obtenerTransicionesPorActividad(GestionOE OE); //{"usuario":"rocio.guio", "idUsuario":1010, "idActividad":5}
	
	
	@POST
	@JWT
	@Path("/avanzarMantenimientoVialMasivo")
    @Produces({ MediaType.APPLICATION_JSON})
	public Response avanzarMantenimientoVialMasivo(GestionOE OE); //{"usuario":"rocio.guio","ids":[379765,396485],"idActividadTransicion":9,"idUsuario":1379,"observacion":"Prueba","enviarCorreo":"SI"}

	

	/******************************* PARA CUS 17 **********************************/
	
	@GET
	@Path("/listarDominio")
    public Response listarDominio(@QueryParam("dominio")String dominio, @QueryParam("usuario")String usuario);
	
	
	
	/*************************bandeja general **********************************/
	@POST
	@JWT
	@Path("/listarBandejaGestionPendiente") 
    @Produces({ MediaType.APPLICATION_JSON})
	public Response listarBandejaGestionPendiente(GestionOE OE); //{ "usuario":"rocio.guio","idUsuario":1379, "idActividad":5}

	
	/***************************************************************************/
	@POST
	@JWT
	@Path("/acumularKmCarrilImpactoPorEventos") 
    @Produces({ MediaType.APPLICATION_JSON})
	public Response obtenerKmCarrilImpactoPorEventos(GestionOE OE); 

	
	@POST
	@JWT
	@Path("/acumularKmCarrilImpactoPorGestion") 
    @Produces({ MediaType.APPLICATION_JSON})
	public Response acumularKmCarrilImpactoPorGestion(GestionOE OE); 
	
	
}
