package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/consulta")
public interface IConsultaServicio 
{
	@POST
    @Path("/consultarMantenimientoVial")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarMantenimientoVial(ConsultaOE OE);
	
	@POST
    @Path("/consultarGestionPendiente")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarGestionPendiente(ConsultaOE OE);
	
	@POST
    @Path("/consultarActividadSiguiente")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarActividadSiguiente(ConsultaOE OE);
	
	@POST
    @Path("/consultarActividadSiguienteSino")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarActividadSiguienteSino(ConsultaOE OE);
	
	@POST
    @Path("/consultarDisponibilidadPersonas")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarDisponibilidadPersonas(ConsultaOE OE);
	
	@POST
    @Path("/consultarProgramaciones")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarProgramaciones(ConsultaOE OE);
	
	@POST
    @Path("/consultarCargaTrabajoActual")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarCargaTrabajoActual(ConsultaOE OE);
	
	@POST
    @Path("/consultarUsuarioGestionPrevia")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarUsuarioGestionPrevia(ConsultaOE OE);
	
	@POST
    @Path("/consultarGeneralGestion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarGeneralGestion(ConsultaOE OE);
	
	@POST
    @Path("/consultarSeguimientoUTL")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarSeguimientoUTL(ConsultaOE OE);
	
	@POST
    @Path("/consultarSeguimientos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarSeguimientos(ConsultaOE OE);
	
	@POST
    @Path("/divisionTerritorial")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarDivisionTerritorial(ConsultaOE OE);
	
	
	@POST
    @Path("/mantenimientoVialEventos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarMantenimientoVialEventos(ConsultaOE OE);
	
	@POST
    @Path("/unidadesMuestreo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarUnidadesMuestreo(ConsultaOE OE);
	
	
	@POST
    @Path("/fallas")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarFallas(ConsultaOE OE);
	
	@POST
    @Path("/mantenimientoVialDocumento")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarMantenimientoVialDocumento(ConsultaOE OE);
	
	@POST
    @Path("/mantenimientoVialGestion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarMantenimientoVialGestion(ConsultaOE OE);
	
	
	@POST
    @Path("/otrosFactores")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarOtrosFactores(ConsultaOE OE);
	
	@POST
    @Path("/pkMantenimientosActivos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarPkConMantenimientosActivos(ConsultaOE OE);
	
	@POST
    @Path("/solicitudesAforosApiques")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarSolicitudesAforosApiques(ConsultaOE OE);
	
	@POST
    @Path("/areaIntervencion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarAreaIntervencion(ConsultaOE OE);
	
	@POST
    @Path("/intervencionNovedad")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarIntervencionNovedad(ConsultaOE OE);
	
	@POST
    @Path("/seguimientosProximos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarSeguimientosProximos(ConsultaOE OE);
	
	/*******************************************/
	
	
	
	@POST
    @Path("/radicadoVinculado")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaRadicadoVinculado(ConsultaOE OE);
	
	@POST
    @Path("/predisenioAledanio")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaPredisenioAledanio(ConsultaOE OE);
	
	@POST
    @Path("/predisenioApiques")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaPredisenioApiques(ConsultaOE OE);
	
	@POST
    @Path("/alternativasDisenio")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaAlternativasDisenio(ConsultaOE OE);
	
	@POST
    @Path("/disenioCapa")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaDisenioCapa(ConsultaOE OE);
	
	@POST
    @Path("/programacionDiaria")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaProgramacionDiaria(ConsultaOE OE);
	
	@POST
    @Path("/programacionDiariaPersonal")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaProgramacionDiariaPersonal(ConsultaOE OE);
	
	
	@POST
    @Path("/programacionDiariaMaquinaria")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaProgramacionDiariaMaquinaria(ConsultaOE OE);
	
	
	@POST
    @Path("/programacionDiariaMaterial")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaProgramacionDiariaMaterial(ConsultaOE OE);
	
	
	@POST
    @Path("/archivosMantenimientoVial")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaArchivosMantenimientoVial(ConsultaOE OE);
	
	@POST
    @Path("/calculadoMantenimientoVial")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultaCalculadoMantenimientoVial(ConsultaOE OE);

	@POST
    @Path("/consultarMantenimientoVialDocumentoArchivo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	//@JWT		
	public Response consultarMantenimientoVialDocumentoArchivo(ConsultaOE OE);
	
}
