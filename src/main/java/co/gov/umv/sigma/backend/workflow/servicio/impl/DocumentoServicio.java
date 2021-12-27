package co.gov.umv.sigma.backend.workflow.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;
import co.gov.umv.sigma.backend.workflow.dto.IDocumentoDTO;
import co.gov.umv.sigma.backend.workflow.dto.impl.DocumentoDTO;
import co.gov.umv.sigma.backend.workflow.servicio.IDocumentoServicio;

public class DocumentoServicio implements IDocumentoServicio {

	@Override
	public Response insertar(DocumentoOE OE) {
		IDocumentoDTO servicio = new DocumentoDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
		
	}

	@Override
	public Response actualizar(DocumentoOE OE) {
		IDocumentoDTO servicio = new DocumentoDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(DocumentoOE OE) {
		IDocumentoDTO servicio = new DocumentoDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(DocumentoOE OE) {
		IDocumentoDTO servicio = new DocumentoDTO();
		ObjetoSalida os = servicio.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
		
	}

}
