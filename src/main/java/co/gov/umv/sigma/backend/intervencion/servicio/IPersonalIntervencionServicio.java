package co.gov.umv.sigma.backend.intervencion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/intervencion/personal")

public interface IPersonalIntervencionServicio {

/*****************************************************************************/
	
	@POST
    @Path("/directorZona/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarDirectorZona(IntervencionOE OE);
	
	@POST
	@Path("/directorZona/actualizar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizarDirectorZona(IntervencionOE OE);
	
	@POST
	@Path("/directorZona/eliminar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response eliminarDirectorZona(IntervencionOE OE);
	
	@POST
	@Path("/directorZona/consultarXFiltro")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarDirectorZona(IntervencionOE OE);
	
/*****************************************************************************/
	
	@POST
    @Path("/directorResidente/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertardirectorResidente(IntervencionOE OE);
	
	@POST
	@Path("/directorResidente/actualizar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizardirectorResidente(IntervencionOE OE);
	
	@POST
	@Path("/directorResidente/eliminar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response eliminardirectorResidente(IntervencionOE OE);
	
	@POST
	@Path("/directorResidente/consultarXFiltro")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultardirectorResidente(IntervencionOE OE);
	
/*****************************************************************************/
	
	@POST
    @Path("/directorApoyo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertardirectorApoyo(IntervencionOE OE);
	
	@POST
	@Path("/directorApoyo/actualizar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizardirectorApoyo(IntervencionOE OE);
	
	@POST
	@Path("/directorApoyo/eliminar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response eliminardirectorApoyo(IntervencionOE OE);
	
	@POST
	@Path("/directorApoyo/consultarXFiltro")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultardirectorApoyo(IntervencionOE OE);

/*****************************************************************************/
	
	@POST
    @Path("/residenteUnidadEjec/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarresidenteUnidadEjec(IntervencionOE OE);
	
	@POST
	@Path("/residenteUnidadEjec/actualizar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizarresidenteUnidadEjec(IntervencionOE OE);
	
	@POST
	@Path("/residenteUnidadEjec/eliminar")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response eliminarresidenteUnidadEjec(IntervencionOE OE);
	
	@POST
	@Path("/residenteUnidadEjec/consultarXFiltro")
	@Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarresidenteUnidadEjec(IntervencionOE OE);

}
