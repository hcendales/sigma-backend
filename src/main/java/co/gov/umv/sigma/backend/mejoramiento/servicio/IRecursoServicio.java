package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.FranjaHorariaOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RecursoOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/recurso")
public interface IRecursoServicio 
{
	@POST
    @Path("/programacion/franjas")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response generarFranjas(FranjaHorariaOE OE);

	@POST
    @Path("/programacion/franjas/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarFranjas(FranjaHorariaOE OE);


	@POST
    @Path("/programacion/franjas/consultar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarFranjas(FranjaHorariaOE OE);


	
	/* CRUD RECURSO */
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertar(RecursoOE OE);
	

	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizar(RecursoOE OE);
	

	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminar(RecursoOE OE);
	

	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltro(RecursoOE OE);

	
	/*ASIGNACION*/
	@POST
    @Path("/asignacion/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarAsignacion(RecursoOE OE);
	

	@POST
    @Path("/asignacion/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarAsignacion(RecursoOE OE);
	

	@POST
    @Path("/asignacion/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarAsignacion(RecursoOE OE);
	

	@POST
    @Path("/asignacion/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroAsignacion(RecursoOE OE);
	
	
	/*ASIGNACION*/
	@POST
    @Path("/disponibilidad/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarDisponibilidad(RecursoOE OE);
	

	@POST
    @Path("/disponibilidad/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarDisponibilidad(RecursoOE OE);
	

	@POST
    @Path("/disponibilidad/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarDisponibilidad(RecursoOE OE);
	

	@POST
    @Path("/disponibilidad/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroDisponibilidad(RecursoOE OE);
		



	/*NOVEDAD*/
	@POST
    @Path("/novedad/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarNovedad(RecursoOE OE);
	

	@POST
    @Path("/novedad/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarNovedad(RecursoOE OE);
	

	@POST
    @Path("/novedad/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarNovedad(RecursoOE OE);
	

	@POST
    @Path("/novedad/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroNovedad(RecursoOE OE);
	
	
	@POST
    @Path("/listarDisponibilidad")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response listarDisponibilidadRecurso(RecursoOE OE);

	@POST
    @Path("/crearRecursoConDisponibilidad")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response crearRecursoConDisponibilidad(RecursoOE OE);
	
	
	@POST
    @Path("/crearRecursoConDisponibilidadEq")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response crearRecursoConDisponibilidadEq(RecursoOE OE);
	
	@POST
    @Path("/crearRecursoConDisponibilidadPe")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response crearRecursoConDisponibilidadPe(RecursoOE OE);
	
	@POST
    @Path("/crearFranjasMasiva")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response crearFranjasMasiva(FranjaHorariaOE OE);
	
	@POST
    @Path("/listarDisponibilidadXTipo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response listarDisponibilidadxTipoRecurso(RecursoOE OE);
	
	@POST
    @Path("/listarDisponibilidadTotalXTipo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response listarDisponibilidadTotalXTipo(RecursoOE OE);
	
	
}
