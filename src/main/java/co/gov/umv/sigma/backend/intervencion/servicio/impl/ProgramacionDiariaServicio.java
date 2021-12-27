package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.ProgramacionDiariaOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ProgDiariaMaquinariaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ProgDiariaMaterialDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ProgDiariaPersonalDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ProgramacionDiariaDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IProgramacionDiariaServicio;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class ProgramacionDiariaServicio implements IProgramacionDiariaServicio {

	
	@Override
	public Response insertar(ProgramacionDiariaOE OE)
	{
		ICrudDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(ProgramacionDiariaOE OE)
	{
		ICrudDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(ProgramacionDiariaOE OE)
	{
		ICrudDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(ProgramacionDiariaOE OE)
	{
		ICrudDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	/**********************************************/

	@Override
	public Response insertarPersonal(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaPersonalDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarPersonal(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaPersonalDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarPersonal(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaPersonalDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroPersonal(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaPersonalDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	/*************************************************/
	

	@Override
	public Response insertarMaterial(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaterialDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarMaterial(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaterialDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarMaterial(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaterialDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroMaterial(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaterialDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/*************************************************/
	
	@Override
	public Response insertarMaquinaria(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaquinariaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarMaquinaria(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaquinariaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarMaquinaria(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaquinariaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroMaquinaria(ProgramacionDiariaOE OE) {
		ICrudDTO dto = new ProgDiariaMaquinariaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response listarProgramacionDiarias(ProgramacionDiariaOE OE)
	{
		ProgramacionDiariaDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.listarProgramacionDiarias(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response copiarProgDiaria(ProgramacionDiariaOE OE) {
		ProgramacionDiariaDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.copiarProgDiaria(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarUE(ProgramacionDiariaOE OE) {
		ProgramacionDiariaDTO dto = new ProgramacionDiariaDTO();
		ObjetoSalida os = dto.consultarUE(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	

}
