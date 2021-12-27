package co.gov.umv.sigma.backend.workflow.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.workflow.cbo.ActividadOE;
import co.gov.umv.sigma.backend.workflow.dto.IActividadDTO;
import co.gov.umv.sigma.backend.workflow.dto.impl.ActividadDTO;
import co.gov.umv.sigma.backend.workflow.servicio.IActividadServicio;

public class ActividadServicio implements IActividadServicio {

	@Override
	public Response insertar(ActividadOE OE) {
		IActividadDTO servicio = new ActividadDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
		
	}

	@Override
	public Response actualizar(ActividadOE OE) {
		IActividadDTO servicio = new ActividadDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(ActividadOE OE) {
		IActividadDTO servicio = new ActividadDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(ActividadOE OE) {
		IActividadDTO servicio = new ActividadDTO();
		ObjetoSalida os = servicio.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;		
	}
}
