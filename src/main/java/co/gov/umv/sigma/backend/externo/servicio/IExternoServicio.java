package co.gov.umv.sigma.backend.externo.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.externo.cbo.ObjetoNegocioOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/externo")
public interface IExternoServicio {
	@POST
    @Path("/consume")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consumirExterno(ObjetoNegocioOE OE);
	
	@POST
    @Path("/consumearchivo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM})
	@JWT
	public Response consumirArchivoExterno(ObjetoNegocioOE OE);
}
