package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialGestionOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialGestionDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialGestionDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IMantenimientoVialGestionServicio;

public class MantenimientoVialGestionServicio implements IMantenimientoVialGestionServicio {

	@Override
	public Response insertar(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDTO servicio = new MantenimientoVialGestionDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizar(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDTO servicio = new MantenimientoVialGestionDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDTO servicio = new MantenimientoVialGestionDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(MantenimientoVialGestionOE OE) {
		IMantenimientoVialGestionDTO servicio = new MantenimientoVialGestionDTO();
		ObjetoSalida os = servicio.insertar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

}
