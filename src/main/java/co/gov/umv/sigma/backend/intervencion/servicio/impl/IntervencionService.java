package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ConfiguracionPersonalDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.GestionProgramacionPeriodicaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.ProgramacionPeriodicaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.TipoClaseMaterialDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.TipoPeriodoProgramacionDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IIntervencionService;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.*;

public class IntervencionService implements IIntervencionService{

	
	@Override
	public Response consultarPeriodoProgramacion(IntervencionOE OE) 
	{
		TipoPeriodoProgramacionDTO dto = new TipoPeriodoProgramacionDTO();
		ObjetoSalida os = dto.consultarPeriodoProgramacion(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}



	
	@Override
	public Response actualizarProgramacionPeriodica(IntervencionOE OE) {
		ProgramacionPeriodicaDTO dto = new ProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarProgramacionPeriodica(IntervencionOE OE)
	{
		ProgramacionPeriodicaDTO dto = new ProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response insertarProgramacionPeriodica(IntervencionOE OE) 
	{
		OE.getProgPeriodica().setKmCarrilImpacto(0L);
		OE.getProgPeriodica().setKmCarrilLineal(0L);
		OE.getProgPeriodica().setKmCarrilObra(0L);
		OE.getProgPeriodica().setTotalDiasDuracionPlaneada(0L);
				
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.insertarProgPeriodica(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response adicionarPKProgramacionPeriodica(IntervencionOE OE) 
	{
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.adicionarPKProgramacionPeriodica(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response removerPKProgramacionPeriodica(IntervencionOE OE) 
	{
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.removerPKProgramacionPeriodica(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarProgramacionPeriodicaActiva(ObjetoEntrada OE) 
	{
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.consultarProgramacionPeriodicaActiva(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarProgramacionPeriodica(IntervencionOE OE)
	{
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.eliminarProgramacionPeriodica(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarPkEnProgramacionPeriodica(ObjetoEntrada OE) 
	{
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.consultarPKProgramacionPeriodica(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}



	@Override
	public Response listarPkParaAsociar(IntervencionOE OE) {
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.listarPkParaAsociar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}



	@Override
	public Response filtrarVigenciasProgramacion(ObjetoEntrada OE) 
	{
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.filtrarVigenciasProgramacion(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}




	@Override
	public Response actualizarArchivoProgramacionPeriodica(IntervencionOE OE) {
		GestionProgramacionPeriodicaDTO dto = new GestionProgramacionPeriodicaDTO();
		ObjetoSalida os = dto.actualizarArchivoProgramacionPeriodica(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}




	@Override
	public Response insertarTipoClaseMaterial(IntervencionOE OE) {
		TipoClaseMaterialDTO dto = new TipoClaseMaterialDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response actualizarTipoClaseMaterial(IntervencionOE OE) {
		TipoClaseMaterialDTO dto = new TipoClaseMaterialDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response eliminarTipoClaseMaterial(IntervencionOE OE) {
		TipoClaseMaterialDTO dto = new TipoClaseMaterialDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


	@Override
	public Response consultarTipoClaseMaterial(IntervencionOE OE) {
		TipoClaseMaterialDTO dto = new TipoClaseMaterialDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}




	@Override
	public Response listarDirectoresApoyo(ObjetoEntrada OE) {
		ConfiguracionPersonalDTO dto = new ConfiguracionPersonalDTO();
		ObjetoSalida os = dto.listarDirectoresApoyo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}




	@Override
	public Response listarResidentes(ObjetoEntrada OE) {
		ConfiguracionPersonalDTO dto = new ConfiguracionPersonalDTO();
		ObjetoSalida os = dto.listarResidentes(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
}
