package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ApiqueOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.ApiqueDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IApiqueServicio;

public class ApiqueServicio implements IApiqueServicio
{
	ICrudDTO dto = new ApiqueDTO();
	
	@Override
	public Response insertar(ApiqueOE OE)
	{
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(ApiqueOE OE)
	{
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(ApiqueOE OE)
	{
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(ApiqueOE OE)
	{
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarIdMantenimientoVialEvento(ApiqueOE OE) {
		ApiqueDTO dto = new ApiqueDTO();
		ObjetoSalida os = dto.consultarIdMantenimientoVialEvento(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}


}
