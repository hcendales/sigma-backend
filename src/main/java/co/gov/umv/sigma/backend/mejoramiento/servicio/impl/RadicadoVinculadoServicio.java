package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RadicadoVinculadoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IRadicadoVinculadoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.RadicadoVinculadoDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IRadicadoVinculadoServicio;

public class RadicadoVinculadoServicio implements IRadicadoVinculadoServicio {

	@Override
	public Response insertar(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDTO servicio = new RadicadoVinculadoDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizar(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDTO servicio = new RadicadoVinculadoDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDTO servicio = new RadicadoVinculadoDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDTO servicio = new RadicadoVinculadoDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

	
}