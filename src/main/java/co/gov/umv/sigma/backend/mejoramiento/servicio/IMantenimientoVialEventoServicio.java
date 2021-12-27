package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/mantenimientovialevento")
public interface IMantenimientoVialEventoServicio {
	@POST
    @Path("/crearMantenimientoVialEvento")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response crearMantenimientoVialEvento(MantenimientoVialEventoOE OE);
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response insertar(MantenimientoVialEventoOE OE);
	
	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizar(MantenimientoVialEventoOE OE) throws Exception;
	
	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response eliminar(MantenimientoVialEventoOE OE);
	
	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	//@JWT
	public Response consultarXFiltro(MantenimientoVialEventoOE OE);
	
	@POST
    @Path("/consultarId")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response consultarId(MantenimientoVialEventoOE OE);
	
	@POST
    @Path("/calcularPCI")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response calcularPCI(MantenimientoVialEventoOE OE);
	
	@POST
    @Path("/actualizarCampo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response actualizarCampo(MantenimientoVialEventoOE OE);
}
