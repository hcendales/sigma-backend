package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialDocuDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialDocuDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IMantenimientoVialDocuServicio;

public class MantenimientoVialDocuServicio implements IMantenimientoVialDocuServicio {

	@Override
	public Response insertar(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDTO servicio = new MantenimientoVialDocuDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizar(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDTO servicio = new MantenimientoVialDocuDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDTO servicio = new MantenimientoVialDocuDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDTO servicio = new MantenimientoVialDocuDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

}
