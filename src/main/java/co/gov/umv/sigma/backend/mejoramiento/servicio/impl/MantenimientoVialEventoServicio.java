package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialEventoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialEventoDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IMantenimientoVialEventoServicio;


public class MantenimientoVialEventoServicio implements IMantenimientoVialEventoServicio {

	@Override
	public Response crearMantenimientoVialEvento(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.crearMantenimientoVialEvento(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response insertar(MantenimientoVialEventoOE OE) {
		
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizar(MantenimientoVialEventoOE OE) throws Exception {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;		
	}

	@Override
	public Response consultarId(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.consultarId(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response calcularPCI(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.calcularPCI(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response actualizarCampo(MantenimientoVialEventoOE OE) {
		IMantenimientoVialEventoDTO servicio = new MantenimientoVialEventoDTO();
		ObjetoSalida os = servicio.actualizarCampo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}
}
