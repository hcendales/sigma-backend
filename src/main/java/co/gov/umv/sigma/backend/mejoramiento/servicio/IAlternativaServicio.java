package co.gov.umv.sigma.backend.mejoramiento.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.AlternativaOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/alternativa")
public interface IAlternativaServicio  {

	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertar(AlternativaOE OE);
	

	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizar(AlternativaOE OE);
	

	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminar(AlternativaOE OE);
	

	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltro(AlternativaOE OE);

	/************* CAPAS  ***********/

	
	@POST
    @Path("/capa/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarCapa(AlternativaOE OE);
	

	@POST
    @Path("/capa/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarCapa(AlternativaOE OE);
	

	@POST
    @Path("/capa/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarCapa(AlternativaOE OE);
	

	@POST
    @Path("/capa/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroCapa(AlternativaOE OE);

	
}
