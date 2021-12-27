package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.AreaIntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.AreaIntervencionDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IAreaIntervencionServicio;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ApiqueOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;


public class AreaIntervencionServicio implements IAreaIntervencionServicio {
	ICrudDTO dto = new AreaIntervencionDTO();
	@Override
	public Response insertar(AreaIntervencionOE OE) {		
		ObjetoSalida os = dto.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}

	}

	@Override
	public Response actualizar(AreaIntervencionOE OE) {
		ObjetoSalida os = dto.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(AreaIntervencionOE OE) {
		ObjetoSalida os = dto.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(AreaIntervencionOE OE) {
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarIdMantenimientoVialEvento(AreaIntervencionOE OE) 
	{
		OE.setFiltro("id_mantenimiento_vial_evento="+OE.getAreaIntervencion().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento());
		
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
		
	}

}
