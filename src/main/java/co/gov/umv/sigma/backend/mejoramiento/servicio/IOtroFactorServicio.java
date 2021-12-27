package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.OtroFactorOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/otrofactor")
public interface IOtroFactorServicio {
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertar(OtroFactorOE OE);
	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizar(OtroFactorOE OE);
	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminar(OtroFactorOE OE);
	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarXFiltro(OtroFactorOE OE);
	
	@POST
    @Path("/consultarIdMantenimiento")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarIdMantenimiento(OtroFactorOE OE);

}
