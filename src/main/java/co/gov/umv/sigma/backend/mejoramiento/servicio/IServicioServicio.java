package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.ServicioOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;
@Path("/servicio")
public interface IServicioServicio {
	@POST
    @Path("/consultarRadicadoOrfeo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarRadicadoOrfeo(ServicioOE OE);
}
