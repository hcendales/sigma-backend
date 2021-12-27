package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.UnidadMuestreoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IUnidadMuestreoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.UnidadMuestreoDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IUnidadMuestreoServicio;

public class UnidadMuestreoServicio implements IUnidadMuestreoServicio{

	@Override
	public Response insertar(UnidadMuestreoOE OE) {
		IUnidadMuestreoDTO servicio = new UnidadMuestreoDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizar(UnidadMuestreoOE OE) {
		IUnidadMuestreoDTO servicio = new UnidadMuestreoDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(UnidadMuestreoOE OE) {
		IUnidadMuestreoDTO servicio = new UnidadMuestreoDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(UnidadMuestreoOE OE) {
		IUnidadMuestreoDTO servicio = new UnidadMuestreoDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

	@Override
	public Response consultarIdMantenimiento(UnidadMuestreoOE OE) {
		IUnidadMuestreoDTO servicio = new UnidadMuestreoDTO();
		ObjetoSalida os = servicio.consultarIdMantenimiento(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

}
