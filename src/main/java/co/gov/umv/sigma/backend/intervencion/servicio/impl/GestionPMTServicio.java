package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.SolicitudPMTOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.GestionPMTDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IGestionPMTServicio;

public class GestionPMTServicio implements IGestionPMTServicio {

	GestionPMTDTO dto = new GestionPMTDTO();
	
	@Override
	public Response asociarSolicitud(SolicitudPMTOE OE) 
	{
		ObjetoSalida os = dto.asociarSolicitud(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	@Override
	public Response registrarRespuesta(SolicitudPMTOE OE) 
	{
		ObjetoSalida os = dto.registrarRespuesta(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarRadicados(SolicitudPMTOE OE) {
		ObjetoSalida os = dto.consultarRadicados(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaArchivoCOI(SolicitudPMTOE OE) {
		ObjetoSalida os = dto.consultaArchivoCOI(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response desasociarRadicado(SolicitudPMTOE OE) 
	{
		ObjetoSalida os = dto.desasociarRadicado(OE);	
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}
		
}
