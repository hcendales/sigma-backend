package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AledanioOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AledanioDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.ApiqueAledanioDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IAledanioServicio;

public class AledanioServicio implements IAledanioServicio {

	
	@Override
	public Response registrarApiqueAledanio(AledanioOE OE) 
	{
		ApiqueAledanioDTO dto1 = new ApiqueAledanioDTO();
		ObjetoSalida os = dto1.registrarApiqueAledanio(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	ICrudDTO dto = new AledanioDTO();
	
	@Override
	public Response insertar(AledanioOE OE)
	{
		ObjetoSalida os = dto.insertar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(AledanioOE OE)
	{
		ObjetoSalida os = dto.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(AledanioOE OE)
	{
		ObjetoSalida os = dto.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(AledanioOE OE)
	{
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
}
