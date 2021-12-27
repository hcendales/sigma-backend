package co.gov.umv.sigma.backend.intervencion.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;

@Path("/intervencion")
public interface IIntervencionService {
	
	@POST
    @Path("/periodoProgramacion/consultar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarPeriodoProgramacion(IntervencionOE OE);
	
	@POST
    @Path("/periodoProgramacion/filtrarVigencias")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response filtrarVigenciasProgramacion(ObjetoEntrada OE);
	
	@POST
    @Path("/programacionPeriodica/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarProgramacionPeriodica(IntervencionOE OE);
	
	@POST
    @Path("/programacionPeriodica/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizarProgramacionPeriodica(IntervencionOE OE);
	
	@POST
    @Path("/programacionPeriodica/actualizarArchivo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizarArchivoProgramacionPeriodica(IntervencionOE OE);
	
	@POST
    @Path("/programacionPeriodica/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarProgramacionPeriodica(IntervencionOE OE);
	
	
	@POST
    @Path("/programacionPeriodica/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response eliminarProgramacionPeriodica(IntervencionOE OE);
	
	@POST
    @Path("/programacionPeriodica/adicionarPK")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response adicionarPKProgramacionPeriodica(IntervencionOE OE);
	
	@POST
    @Path("/programacionPeriodica/removerPK")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response removerPKProgramacionPeriodica(IntervencionOE OE);
	
	@POST
    @Path("/programacionPeriodica/consultarActivas")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarProgramacionPeriodicaActiva(ObjetoEntrada OE);
	
	@POST
    @Path("/programacionPeriodica/consultarPK")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarPkEnProgramacionPeriodica(ObjetoEntrada OE);
	
	@POST
    @Path("/programacionPeriodica/listarPkAsociar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response listarPkParaAsociar(IntervencionOE OE);
	
	
	/****************************************************/
	
	@POST
    @Path("/tipoClaseMaterial/insertar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response insertarTipoClaseMaterial(IntervencionOE OE);
	
	@POST
    @Path("/tipoClaseMaterial/actualizar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response actualizarTipoClaseMaterial(IntervencionOE OE);
	
	@POST
    @Path("/tipoClaseMaterial/eliminar")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response eliminarTipoClaseMaterial(IntervencionOE OE);
	
	@POST
    @Path("/tipoClaseMaterial/consultarXFiltro")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response consultarTipoClaseMaterial(IntervencionOE OE);
	
	/****************************************************************/
	@POST
    @Path("/confPersonal/listarDirectoresApoyo")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response listarDirectoresApoyo(ObjetoEntrada OE);
	
	@POST
    @Path("/confPersonal/listarResidentes")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT		
	public Response listarResidentes(ObjetoEntrada OE);
	
	
	
	
}
