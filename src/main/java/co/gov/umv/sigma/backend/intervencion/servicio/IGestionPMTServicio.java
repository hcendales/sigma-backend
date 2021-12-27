package co.gov.umv.sigma.backend.intervencion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.intervencion.cbo.SolicitudPMTOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/PMT")
public interface  IGestionPMTServicio {

	@POST
    @Path("/asociarSolicitud")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response asociarSolicitud(SolicitudPMTOE OE);
	
	@POST
    @Path("/registrarRespuesta")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response registrarRespuesta(SolicitudPMTOE OE);
	
	@POST
    @Path("/consultarRadicados")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarRadicados(SolicitudPMTOE OE);
	
	@POST
    @Path("/consultaArchivoCOI")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultaArchivoCOI(SolicitudPMTOE OE);
	
	@POST
    @Path("/desasociarRadicado")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response desasociarRadicado(SolicitudPMTOE OE);
}
