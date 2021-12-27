package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.TipoDirectorApoyoDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.TipoDirectorZonaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.TipoDirectorResidenteDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.TipoResidenteUnidadEjecDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IPersonalIntervencionServicio;

public class PersonalIntervencionServicio implements IPersonalIntervencionServicio{

	@Override
	public Response insertarDirectorZona(IntervencionOE OE) {
		TipoDirectorZonaDTO dto = new TipoDirectorZonaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarDirectorZona(IntervencionOE OE) {
		TipoDirectorZonaDTO dto = new TipoDirectorZonaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarDirectorZona(IntervencionOE OE) {
		TipoDirectorZonaDTO dto = new TipoDirectorZonaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarDirectorZona(IntervencionOE OE) {
		TipoDirectorZonaDTO dto = new TipoDirectorZonaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response insertardirectorResidente(IntervencionOE OE) {
		TipoDirectorResidenteDTO dto = new TipoDirectorResidenteDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizardirectorResidente(IntervencionOE OE) {
		TipoDirectorResidenteDTO dto = new TipoDirectorResidenteDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminardirectorResidente(IntervencionOE OE) {
		TipoDirectorResidenteDTO dto = new TipoDirectorResidenteDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultardirectorResidente(IntervencionOE OE) {
		TipoDirectorResidenteDTO dto = new TipoDirectorResidenteDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response insertardirectorApoyo(IntervencionOE OE) {
		TipoDirectorApoyoDTO dto = new TipoDirectorApoyoDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizardirectorApoyo(IntervencionOE OE) {
		TipoDirectorApoyoDTO dto = new TipoDirectorApoyoDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminardirectorApoyo(IntervencionOE OE) {
		TipoDirectorApoyoDTO dto = new TipoDirectorApoyoDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultardirectorApoyo(IntervencionOE OE) {
		TipoDirectorApoyoDTO dto = new TipoDirectorApoyoDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response insertarresidenteUnidadEjec(IntervencionOE OE) {
		TipoResidenteUnidadEjecDTO dto = new TipoResidenteUnidadEjecDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarresidenteUnidadEjec(IntervencionOE OE) {
		TipoResidenteUnidadEjecDTO dto = new TipoResidenteUnidadEjecDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarresidenteUnidadEjec(IntervencionOE OE) {
		TipoResidenteUnidadEjecDTO dto = new TipoResidenteUnidadEjecDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarresidenteUnidadEjec(IntervencionOE OE) {
		TipoResidenteUnidadEjecDTO dto = new TipoResidenteUnidadEjecDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

}
