package co.gov.umv.sigma.backend.intervencion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.intervencion.cbo.InformacionDiariaCuadrillaOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/informeDiarioCuadrilla")
public interface IInformeDiarioCuadrillaServicio {

	@POST
    @Path("/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertar(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizar(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminar(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltro(InformacionDiariaCuadrillaOE OE);
	
	/*************************************************/
	
	@POST
    @Path("/personal/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarPersonal(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/personal/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarPersonal(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/personal/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarPersonal(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/personal/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroPersonal(InformacionDiariaCuadrillaOE OE);
	
	/****************************************************************/
		
	
	@POST
    @Path("/maquinaria/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarMaquinaria(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/maquinaria/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarMaquinaria(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/maquinaria/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarMaquinaria(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/maquinaria/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroMaquinaria(InformacionDiariaCuadrillaOE OE);

	/**************************************************/
	@POST
    @Path("/entradaMaterial/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarentradaMaterial(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/entradaMaterial/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarentradaMaterial(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/entradaMaterial/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarentradaMaterial(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/entradaMaterial/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroentradaMaterial(InformacionDiariaCuadrillaOE OE);
	
	/******************************************************/
	@POST
    @Path("/salidaMaterial/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarsalidaMaterial(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/salidaMaterial/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarsalidaMaterial(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/salidaMaterial/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarsalidaMaterial(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/salidaMaterial/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltrosalidaMaterial(InformacionDiariaCuadrillaOE OE);

	/********************************************************************************/
	
	@POST
    @Path("/mezcla/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarmezcla(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/mezcla/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarmezcla(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/mezcla/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarmezcla(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/mezcla/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltromezcla(InformacionDiariaCuadrillaOE OE);

	/**************************************************************************/
	@POST
    @Path("/cantidadObra/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarcantidadObra(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/cantidadObra/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarcantidadObra(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/cantidadObra/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarcantidadObra(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/cantidadObra/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltrocantidadObra(InformacionDiariaCuadrillaOE OE);

	/*******************************************************************************/
	
	@POST
    @Path("/calidad/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarcalidad(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/calidad/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarcalidad(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/calidad/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarcalidad(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/calidad/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltrocalidad(InformacionDiariaCuadrillaOE OE);
	
	/***********************************************************/
	@POST
    @Path("/observacion/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarobservacion(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/observacion/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarobservacion(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/observacion/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarobservacion(InformacionDiariaCuadrillaOE OE);
	

	@POST
    @Path("/observacion/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroObservacion(InformacionDiariaCuadrillaOE OE);

}
