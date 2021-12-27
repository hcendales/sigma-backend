package co.gov.umv.sigma.backend.utilidad.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.utilidad.cbo.ListaOE;
import co.gov.umv.sigma.backend.utilidad.dto.IGeneralDTO;
import co.gov.umv.sigma.backend.utilidad.dto.impl.GeneralDTO;
import co.gov.umv.sigma.backend.utilidad.servicio.IGeneralServicio;

public class GeneralServicio implements IGeneralServicio {

	@Override
	public Response listar(ListaOE OE) {
		IGeneralDTO listado = new GeneralDTO();
		ObjetoSalida os = listado.listar(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response listarDominio(ListaOE OE) {
		// TODO Auto-generated method stub
		return null;
	}

}
