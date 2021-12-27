package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.MantenimientoVialDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IMantenimientoVialServicio;

public class MantenimientoVialServicio implements IMantenimientoVialServicio {

	@Override
	public Response insertar(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
		
	}

	@Override
	public Response actualizar(MantenimientoVialOE OE) throws Exception{
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
		
	}

	@Override
	public Response consultarId(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.consultarId(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response crearMantenimientoVial(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.crearMantenimientoVial(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response calcularPCI(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.calcularPCI(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response actualizarCampo(MantenimientoVialOE OE) {
		IMantenimientoVialDTO servicio = new MantenimientoVialDTO();
		ObjetoSalida os = servicio.actualizarCampo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

}
