package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.VisitaOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/visita")
public interface IVisitaServicio {

	@POST
    @Path("/vehiculo/consultar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarVisitaVehiculo(VisitaOE OE);
	
	@POST
    @Path("/vehiculo/asignar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response asignarVisitaVehiculo(VisitaOE OE);
	
	@POST
    @Path("/vehiculo/desasignar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response desasignarVisitaVehiculo(VisitaOE OE);
	
	
	@POST
    @Path("/vehiculo/consultarDisponibilidadAsignada")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarDisponibilidadAsignada(VisitaOE OE);
	
	@POST
    @Path("/consultarVisitaProgramada")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarVisitaProgramada(VisitaOE OE);
	
	
	
	
}
