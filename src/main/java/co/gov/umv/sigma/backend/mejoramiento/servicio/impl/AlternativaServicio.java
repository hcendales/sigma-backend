package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AlternativaOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AlternativaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.CapaDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IAlternativaServicio;

public class AlternativaServicio implements IAlternativaServicio
{
	ICrudDTO dto = new AlternativaDTO();
	
	@Override
	public Response insertar(AlternativaOE OE)
	{
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(AlternativaOE OE)
	{
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(AlternativaOE OE)
	{
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(AlternativaOE OE)
	{
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/*************  CAPAS  ******************/
	@Override
	public Response insertarCapa(AlternativaOE OE) 
	{
		ICrudDTO o = new CapaDTO();
		ObjetoSalida os = o.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarCapa(AlternativaOE OE) 
	{
		ICrudDTO o = new CapaDTO();
		ObjetoSalida os = o.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response eliminarCapa(AlternativaOE OE)
	{
		ICrudDTO o = new CapaDTO();
		ObjetoSalida os = o.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarXFiltroCapa(AlternativaOE OE)
	{
		
		ICrudDTO o = new CapaDTO();
		ObjetoSalida os = o.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}


}
