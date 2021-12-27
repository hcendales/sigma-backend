package co.gov.umv.sigma.backend.intervencion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/zonaCobertura")
public interface IZonaCoberturaServicio 
{
	@POST
    @Path("/equipo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarEquipo(IntervencionOE OE);
	

	@POST
    @Path("/equipo/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarEquipo(IntervencionOE OE);
	

	@POST
    @Path("/equipo/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarEquipo(IntervencionOE OE);
	

	@POST
    @Path("/equipo/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroEquipo(IntervencionOE OE);
	
	/***************************/
	
	@POST
    @Path("/persona/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarpersona(IntervencionOE OE);
	

	@POST
    @Path("/persona/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarpersona(IntervencionOE OE);
	

	@POST
    @Path("/persona/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarpersona(IntervencionOE OE);
	

	@POST
    @Path("/persona/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltropersona(IntervencionOE OE);
	
/***************************/
	
	@POST
    @Path("/unidadEjec/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarUnidadEjec(IntervencionOE OE);
	

	@POST
    @Path("/unidadEjec/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarUnidadEjec(IntervencionOE OE);
	

	@POST
    @Path("/unidadEjec/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarUnidadEjec(IntervencionOE OE);
	

	@POST
    @Path("/unidadEjec/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroUnidadEjec(IntervencionOE OE);
	
}

