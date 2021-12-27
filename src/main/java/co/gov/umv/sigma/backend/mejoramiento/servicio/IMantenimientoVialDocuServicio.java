package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialGestionOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/mantenimientovialdocu")
public interface IMantenimientoVialDocuServicio {
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertar(MantenimientoVialDocuOE OE);
	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizar(MantenimientoVialDocuOE OE);
	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminar(MantenimientoVialDocuOE OE);
	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltro(MantenimientoVialDocuOE OE);
}
