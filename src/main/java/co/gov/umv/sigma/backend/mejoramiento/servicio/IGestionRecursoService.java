package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionRecursoOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;


@Path("/gestionRecurso")
public interface IGestionRecursoService {

	
	@POST
    @Path("/asignarMasivaRecurso")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response asignarMasivaRecursoOtraActividad(GestionRecursoOE OE);
	
	
	@POST
    @Path("/asignarRecurso")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response asignarRecursoOtraActividad(GestionRecursoOE OE);
	
	@POST
    @Path("/desasociarRecurso")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response desasociarRecursoOtraActividad(GestionRecursoOE OE);
	

	@POST
    @Path("/listarEquiposDisponibles")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response ListarEquiposDisponibles(GestionRecursoOE OE);

	@POST
    @Path("/listarRelacionEquipos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response listarRelacionEquipos(GestionRecursoOE OE);
	
	
	@POST
    @Path("/listarRecursosRelacionadosParaAsignacion")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response listarRecursosRelacionadosParaAsignacion(GestionRecursoOE OE);
	
	
	
	
	

}
