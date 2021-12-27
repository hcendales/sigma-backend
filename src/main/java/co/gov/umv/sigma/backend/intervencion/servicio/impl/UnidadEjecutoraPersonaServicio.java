package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.UnidadEjecutoraPersonaDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IUnidadEjecutoraPersonaServicio;

public class UnidadEjecutoraPersonaServicio implements IUnidadEjecutoraPersonaServicio {

	UnidadEjecutoraPersonaDTO dto = new UnidadEjecutoraPersonaDTO();
	
	@Override
	public Response insertar(IntervencionOE OE) {
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizar(IntervencionOE OE) {
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminar(IntervencionOE OE) {
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltro(IntervencionOE OE) {
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

}
