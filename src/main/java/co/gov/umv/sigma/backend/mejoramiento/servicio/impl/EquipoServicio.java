package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EquipoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.EquipoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.EquipoPersonaDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IEquipoServicio;

public class EquipoServicio implements IEquipoServicio
{
	ICrudDTO dto = new EquipoDTO();
	
	@Override
	public Response insertar(EquipoOE OE)
	{
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(EquipoOE OE)
	{
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(EquipoOE OE)
	{
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(EquipoOE OE)
	{
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response insertarPersona(EquipoOE OE) 
	{
		ICrudDTO dto = new EquipoPersonaDTO();
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarPersona(EquipoOE OE)
	{
		ICrudDTO dto = new EquipoPersonaDTO();
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarPersona(EquipoOE OE) 
	{
		ICrudDTO dto = new EquipoPersonaDTO();
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroPersona(EquipoOE OE) 
	{
		ICrudDTO dto = new EquipoPersonaDTO();
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
}
