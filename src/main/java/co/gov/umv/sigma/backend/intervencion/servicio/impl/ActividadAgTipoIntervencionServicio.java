package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ActividadAgTipoIntervencionDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IActividadAgTipoIntervencionServicio;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class ActividadAgTipoIntervencionServicio implements IActividadAgTipoIntervencionServicio {

	ICrudDTO dto = new ActividadAgTipoIntervencionDTO();
	
	@Override
	public Response insertar(IntervencionOE OE) {		
		ObjetoSalida os = dto.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}

	}

	@Override
	public Response actualizar(IntervencionOE OE) 
	{
		ObjetoSalida os = dto.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(IntervencionOE OE) {
		ObjetoSalida os = dto.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(IntervencionOE OE) {
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

}
