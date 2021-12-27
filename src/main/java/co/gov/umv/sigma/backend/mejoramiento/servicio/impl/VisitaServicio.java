package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.VisitaOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.VisitaDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IVisitaServicio;

public class VisitaServicio implements IVisitaServicio
{
	VisitaDTO dto = new VisitaDTO();
	
	@Override
	public Response consultarVisitaVehiculo(VisitaOE OE) {
		ObjetoSalida os = dto.consultarVisitaVehiculo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response asignarVisitaVehiculo(VisitaOE OE) {
		ObjetoSalida os = dto.asignarVisitaVehiculo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response desasignarVisitaVehiculo(VisitaOE OE) {
		ObjetoSalida os = dto.desasignarVisitaVehiculo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarDisponibilidadAsignada(VisitaOE OE) 
	{
		ObjetoSalida os = dto.consultarDisponibilidadAsignada(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarVisitaProgramada(VisitaOE OE) {
		ObjetoSalida os = dto.consultarVisitaProgramada(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

}
