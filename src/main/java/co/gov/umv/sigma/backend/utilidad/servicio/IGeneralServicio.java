package co.gov.umv.sigma.backend.utilidad.servicio;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.seguridad.jwt.JWT;
import co.gov.umv.sigma.backend.utilidad.cbo.ListaOE;
@Path("/utilidad")
public interface IGeneralServicio {
	@POST
    @Path("/listar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response listar(ListaOE OE);
	
	@POST
    @Path("/listarDominio")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response listarDominio(ListaOE OE);
}
