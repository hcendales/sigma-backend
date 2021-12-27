package co.gov.umv.sigma.backend.comun.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dto.impl.DocumentoMVDTO;
import co.gov.umv.sigma.backend.seguridad.jwt.JWT;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;

@Path("/documentoMV")
public class DocumentoMVServicio {

	@POST
    @Path("/nuevaVersion")
	 @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response nuevaVersion(DocumentoOE OE)
	{
		
		DocumentoMVDTO servicio = new DocumentoMVDTO();
		ObjetoSalida os = servicio.nuevaVersion(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}
	
	
	@POST
    @Path("/listarXTipo")
	 @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
	@JWT
	public Response listarXTipo(DocumentoOE OE)
	{
		
		DocumentoMVDTO servicio = new DocumentoMVDTO();
		ObjetoSalida os = servicio.listarXTipo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}
	
	
	
	
}
