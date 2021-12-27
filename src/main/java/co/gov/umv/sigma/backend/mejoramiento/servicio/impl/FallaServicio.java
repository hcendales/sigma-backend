package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FallaOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IFallaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.FallaDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IFallaServicio;

public class FallaServicio implements IFallaServicio {

	@Override
	public Response insertar(FallaOE OE) {
		IFallaDTO servicio = new FallaDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
		
	}

	@Override
	public Response actualizar(FallaOE OE) {
		IFallaDTO servicio = new FallaDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(FallaOE OE) {
		IFallaDTO servicio = new FallaDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(FallaOE OE) {
		IFallaDTO servicio = new FallaDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();		
	}

	@Override
	public Response consultarIdUnidadMuestreo(FallaOE OE) {
		IFallaDTO servicio = new FallaDTO();
		ObjetoSalida os = servicio.consultarIdUnidadMuestreo(OE);
		return Response.status(Response.Status.OK).entity(os).build();	
	}

}
