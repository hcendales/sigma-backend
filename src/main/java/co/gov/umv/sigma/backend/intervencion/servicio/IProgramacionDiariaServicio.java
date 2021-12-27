package co.gov.umv.sigma.backend.intervencion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.intervencion.cbo.ProgramacionDiariaOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/programacionDiaria")
public interface IProgramacionDiariaServicio 
{

	@POST
    @Path("/listar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response listarProgramacionDiarias(ProgramacionDiariaOE OE);
	
	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertar(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizar(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminar(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltro(ProgramacionDiariaOE OE);
	
	@POST
    @Path("/copiar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response copiarProgDiaria(ProgramacionDiariaOE OE);

	/*************************************************/
	@POST
    @Path("/personal/consultarUE")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarUE(ProgramacionDiariaOE OE);

	
	@POST
    @Path("/personal/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarPersonal(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/personal/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarPersonal(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/personal/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarPersonal(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/personal/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroPersonal(ProgramacionDiariaOE OE);
	
	/****************************************************************/
	

	@POST
    @Path("/material/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarMaterial(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/material/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarMaterial(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/material/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarMaterial(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/material/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroMaterial(ProgramacionDiariaOE OE);
	
	/*************************************************************/
	
	
	@POST
    @Path("/maquinaria/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarMaquinaria(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/maquinaria/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarMaquinaria(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/maquinaria/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarMaquinaria(ProgramacionDiariaOE OE);
	

	@POST
    @Path("/maquinaria/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroMaquinaria(ProgramacionDiariaOE OE);
	
	
	
}
