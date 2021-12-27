package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.CargueOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICargueDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.CargueDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.ICargueServicio;



public class CargueServicio implements ICargueServicio{

	@Override
	public Response procesar(CargueOE OE) 
	{
		ICargueDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.procesar(OE);	
		
		if(os == null)
		{
			os = new ObjetoSalida();
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError("No se pudo procesar el cargue. valide los parámetros de entrada.");
		}
		
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response validar(CargueOE OE) 
	{
		ICargueDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.validar(OE);	
		
		if(os == null)
		{
			os = new ObjetoSalida();
			os.setCodError(CodError.ERROR_INTERNO);
			os.setMsgError("No se pudo validar el cargue. valide los parámetros de entrada.");
		}
		
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response insertar(MultipartFormDataInput OE)
	{
		ICargueDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.insertarArchivo(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response actualizar(CargueOE OE)
	{
		ICrudDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.actualizar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminar(CargueOE OE)
	{
		ICrudDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.eliminar(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response consultarXFiltro(CargueOE OE)
	{
		ICrudDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response eliminarDetalles(CargueOE OE)
	{
		ICargueDTO cargue = new CargueDTO();
		ObjetoSalida os = cargue.eliminarDetalles(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
}
