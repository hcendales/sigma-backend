package co.gov.umv.sigma.backend.produccion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/laboratorio")
public interface ILaboratorioService {
	

	@POST
    @Path("/ensayo/clonar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response clonarEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/ensayo/consultarOrdenPrioridad")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarOrdenPrioridadEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/tipoMaterialEnsayo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertartipoMaterialEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/tipoMaterialEnsayo/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizartipoMaterialEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/tipoMaterialEnsayo/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminartipoMaterialEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/tipoMaterialEnsayo/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltrotipoMaterialEnsayo(LaboratorioOE OE);

	/****************************************************************/
	

	@POST
    @Path("/tipoServicioEnsayo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertartipoServicioEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/tipoServicioEnsayo/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizartipoServicioEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/tipoServicioEnsayo/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminartipoServicioEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/tipoServicioEnsayo/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltrotipoServicioEnsayo(LaboratorioOE OE);

	
	/********************************************/
	
	@POST
    @Path("/tipoMezcla/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertartipoMezcla(LaboratorioOE OE);
	

	@POST
    @Path("/tipoMezcla/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizartipoMezcla(LaboratorioOE OE);
	

	@POST
    @Path("/tipoMezcla/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminartipoMezcla(LaboratorioOE OE);
	

	@POST
    @Path("/tipoMezcla/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltrotipoMezcla(LaboratorioOE OE);

	
	
	
/*********************************************************/	
	@POST
    @Path("/ensayo/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/ensayo/eliminarXCodigo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarXCodigoEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/ensayo/actualizarCampo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarCampoEnsayo(LaboratorioOE OE);
	

/************************************************************/
	
	@POST
    @Path("/ensayo/detalle/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarDetEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/detalle/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarDetEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/detalle/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarDetEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/detalle/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroDetEnsayo(LaboratorioOE OE);

	@POST
    @Path("/ensayo/detalle/eliminarPorEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarPorEnsayoDetalle(LaboratorioOE OE);

	
	@POST
    @Path("/ensayo/detalle/eliminarXCodigo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarXCodigoEnsayoDetalle(LaboratorioOE OE);
	
/************************************************************/
	
	@POST
    @Path("/ensayo/resultado/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response insertarResEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/resultado/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarResEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/resultado/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarResEnsayo(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/resultado/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroResEnsayo(LaboratorioOE OE);
	
	/***********************************************************************/
	
	@POST
    @Path("/ensayo/pk/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarEnsayoPk(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/pk/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarEnsayoPk(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/pk/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarEnsayoPk(LaboratorioOE OE);
	

	@POST
    @Path("/ensayo/pk/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroEnsayoPk(LaboratorioOE OE);

	@POST
    @Path("/ensayo/pk/eliminarPorEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarPorEnsayoPk(LaboratorioOE OE);

	

	@POST
    @Path("/ensayo/pk/eliminarXCodigo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarXCodigoEnsayoPk(LaboratorioOE OE);
	
/***********************************************************************/
	
	@POST
    @Path("/ensayo/informe/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarEnsayoinforme(LaboratorioOE OE);
	

	@POST
	@Path("/ensayo/informe/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarEnsayoinforme(LaboratorioOE OE);
	

	@POST
	@Path("/ensayo/informe/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarEnsayoinforme(LaboratorioOE OE);
	

	@POST
	@Path("/ensayo/informe/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroEnsayoinforme(LaboratorioOE OE);
	
	@POST
    @Path("/ensayo/informe/eliminarXCodigo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarXCodigoEnsayoInforme(LaboratorioOE OE);

	@POST
    @Path("/ensayo/informe/eliminarPorEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarPorEnsayoInforme(LaboratorioOE OE);


	/***********************************************************/
	
	@POST
    @Path("/consultar/tipoMaterialEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarTipoMaterialEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/consultar/tipoServicioEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarTipoServicioEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/consultar/ensayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarEnsayo(LaboratorioOE OE);
	
	@POST
    @Path("/consultar/detalleEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarEnsayoDetalle(LaboratorioOE OE);
	
	/*****************************************************************************/
	
	@POST
    @Path("/ensayoMaterial/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarEnsayoMaterial(LaboratorioOE OE);
	

	@POST
    @Path("/ensayoMaterial/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarEnsayoMaterial(LaboratorioOE OE);
	

	@POST
    @Path("/ensayoMaterial/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarEnsayoMaterial(LaboratorioOE OE);
	

	@POST
    @Path("/ensayoMaterial/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroEnsayoMaterial(LaboratorioOE OE);
	
	
	@POST
    @Path("/ensayoMaterial/eliminarPorEnsayo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarPorEnsayoMaterial(LaboratorioOE OE);
	
	
	@POST
    @Path("/ensayo/material/eliminarXCodigo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarXCodigoEnsayoMaterial(LaboratorioOE OE);

	
	
	
/***********************************************************************/
	
	@POST
    @Path("/ensayo/informe/adjunto/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarEnsayoinformeAdjunto(LaboratorioOE OE);
	

	@POST
	@Path("/ensayo/informe/adjunto/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response actualizarEnsayoinformeAdjunto(LaboratorioOE OE);
	

	@POST
	@Path("/ensayo/informe/adjunto/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response eliminarEnsayoinformeAdjunto(LaboratorioOE OE);
	

	@POST
	@Path("/ensayo/informe/adjunto/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT	
	public Response consultarXFiltroEnsayoinformeAdjunto(LaboratorioOE OE);

	
}
