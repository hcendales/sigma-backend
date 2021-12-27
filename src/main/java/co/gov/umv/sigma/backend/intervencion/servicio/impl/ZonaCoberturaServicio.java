package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ZonaCoberturaEquipoDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ZonaCoberturaPersonaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ZonaCoberturaUnidadEjecDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IZonaCoberturaServicio;

public class ZonaCoberturaServicio implements IZonaCoberturaServicio {

	@Override
	public Response insertarEquipo(IntervencionOE OE) {
		ZonaCoberturaEquipoDTO dto = new ZonaCoberturaEquipoDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarEquipo(IntervencionOE OE) {
		ZonaCoberturaEquipoDTO dto = new ZonaCoberturaEquipoDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarEquipo(IntervencionOE OE) {
		ZonaCoberturaEquipoDTO dto = new ZonaCoberturaEquipoDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroEquipo(IntervencionOE OE) {
		ZonaCoberturaEquipoDTO dto = new ZonaCoberturaEquipoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	/********************************/

	@Override
	public Response insertarpersona(IntervencionOE OE) {
		ZonaCoberturaPersonaDTO dto = new ZonaCoberturaPersonaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarpersona(IntervencionOE OE) {
		ZonaCoberturaPersonaDTO dto = new ZonaCoberturaPersonaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarpersona(IntervencionOE OE) {
		ZonaCoberturaPersonaDTO dto = new ZonaCoberturaPersonaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltropersona(IntervencionOE OE) {
		ZonaCoberturaPersonaDTO dto = new ZonaCoberturaPersonaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/****************************/
	
	@Override
	public Response insertarUnidadEjec(IntervencionOE OE) {
		ZonaCoberturaUnidadEjecDTO dto = new ZonaCoberturaUnidadEjecDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarUnidadEjec(IntervencionOE OE) {
		ZonaCoberturaUnidadEjecDTO dto = new ZonaCoberturaUnidadEjecDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarUnidadEjec(IntervencionOE OE) {
		ZonaCoberturaUnidadEjecDTO dto = new ZonaCoberturaUnidadEjecDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroUnidadEjec(IntervencionOE OE) {
		ZonaCoberturaUnidadEjecDTO dto = new ZonaCoberturaUnidadEjecDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

}
