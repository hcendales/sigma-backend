package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ServicioOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IServicioDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.ServicioDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IServicioServicio;

public class ServicioServicio implements IServicioServicio {

	@Override
	public Response consultarRadicadoOrfeo(ServicioOE OE) {
		
		IServicioDTO dto = new ServicioDTO();
		ObjetoSalida os = dto.consultarRadicadoOrfeo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

}
