package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionNovedadOE;
import co.gov.umv.sigma.backend.intervencion.dto.impl.IntervencionNovedadDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IIntervencionNovedadServicio;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class IntervencionNovedadServicio implements IIntervencionNovedadServicio {
	ICrudDTO dto = new IntervencionNovedadDTO();
	@Override
	public Response insertar(IntervencionNovedadOE OE) {
		ObjetoSalida os = dto.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizar(IntervencionNovedadOE OE) {
		ObjetoSalida os = dto.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(IntervencionNovedadOE OE) {
		ObjetoSalida os = dto.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}			
	}

	@Override
	public Response consultarXFiltro(IntervencionNovedadOE OE) {
		ObjetoSalida os = dto.consultarXFiltro(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarIdMantenimientoVialEvento(IntervencionNovedadOE OE) 
	{
		IntervencionNovedadDTO dto = new IntervencionNovedadDTO();
		ObjetoSalida os = dto.consultarIdMantenimientoVialEvento(OE);	
		return Response.status(Response.Status.OK).entity(os).build();
		
		
	}

}
