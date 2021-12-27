package co.gov.umv.sigma.backend.seguridad.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;

@Path("/token")
public interface ITokenServicio {
	@POST
    @Path("/generate")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	public Response generarToken(UMVPersonLogin OE) throws Exception;
}
