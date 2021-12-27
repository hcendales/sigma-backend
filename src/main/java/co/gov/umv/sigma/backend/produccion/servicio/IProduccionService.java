package co.gov.umv.sigma.backend.produccion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.mejoramiento.cbo.ContratoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FiltroBusquedaEquipo;
import co.gov.umv.sigma.backend.produccion.cbo.ProduccionOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/produccion")
public interface  IProduccionService
{

	@POST
    @Path("/listarEquiposVigentesActividad")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response listarEquiposVigentesAc(FiltroBusquedaEquipo OE);
	
	
	@POST
    @Path("/listarEquiposActivosMtto")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response listarEquiposActivosParaMtto(FiltroBusquedaEquipo OE);
	
	
	
	@POST
    @Path("/fallo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarFallo(ProduccionOE OE);
	

	@POST
    @Path("/fallo/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarFallo(ProduccionOE OE);
	

	@POST
    @Path("/fallo/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarFallo(ProduccionOE OE);
	

	@POST
    @Path("/fallo/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroFallo(ProduccionOE OE);
	
	/********************************************************************/

	@POST
    @Path("/mantenimientoEquipo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT			
	public Response programarMantenimientoEquipo(ProduccionOE OE);
	

	@POST
    @Path("/mantenimientoEquipo/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarMantenimientoEquipo(ProduccionOE OE);
	

	@POST
    @Path("/mantenimientoEquipo/finalizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response finalizarMantenimientoEquipo(ProduccionOE OE);
	

	@POST
    @Path("/mantenimientoEquipo/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroMtto(ProduccionOE OE);
	
	
	@POST
    @Path("/mantenimientoEquipo/cancelar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response cancelarMantenimiento(ProduccionOE OE);
	
	
	/**********************************************************/
	@POST
    @Path("/consultaContrato")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultaContrato(ContratoOE OE);
	
	
	@POST
    @Path("/consulta/mantenimientosEquipos")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarMantenimientosEquipos(ProduccionOE OE);

	/******************************************************************/
	
	@POST
    @Path("/mezclaFormula/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarMezclaFormula(ProduccionOE OE);
	

	@POST
    @Path("/mezclaFormula/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarMezclaFormula(ProduccionOE OE);
	

	@POST
    @Path("/mezclaFormula/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarMezclaFormula(ProduccionOE OE);
	

	@POST
    @Path("/mezclaFormula/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroMezclaFormula(ProduccionOE OE);
	

	/******************************************************************/
	
	@POST
    @Path("/mezclaFormula/materia/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarMezclaFormulaMateria(ProduccionOE OE);
	

	@POST
    @Path("/mezclaFormula/materia/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarMezclaFormulaMateria(ProduccionOE OE);
	

	@POST
    @Path("/mezclaFormula/materia/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarMezclaFormulaMateria(ProduccionOE OE);
	

	@POST
    @Path("/mezclaFormula/materia/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroMezclaFormulaMateria(ProduccionOE OE);

	
}
