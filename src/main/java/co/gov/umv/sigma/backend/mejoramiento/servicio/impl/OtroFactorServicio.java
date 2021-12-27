package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.OtroFactorOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IOtroFactorDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.OtroFactorDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IOtroFactorServicio;

public class OtroFactorServicio implements IOtroFactorServicio {

	@Override
	public Response insertar(OtroFactorOE OE) {
		IOtroFactorDTO servicio = new OtroFactorDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizar(OtroFactorOE OE) {
		IOtroFactorDTO servicio = new OtroFactorDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(OtroFactorOE OE) {
		IOtroFactorDTO servicio = new OtroFactorDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(OtroFactorOE OE) {
		IOtroFactorDTO servicio = new OtroFactorDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

	@Override
	public Response consultarIdMantenimiento(OtroFactorOE OE) {
		IOtroFactorDTO servicio = new OtroFactorDTO();
		ObjetoSalida os = servicio.consultarIdMantenimiento(OE);
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

}
