package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.core.Response;


import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dto.impl.DominioDTO;
import co.gov.umv.sigma.backend.comun.entidad.TabAforo;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IAforoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforoDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforoanalisisDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforocalzadaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.AforodatoDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IAforoServicio;

public class AforoServicio implements IAforoServicio{

	IAforoDTO dtoAforo = new AforoDTO();
	
	IAforoDTO dtoAforoDato = new AforodatoDTO();
	
	IAforoDTO dtoAforoCalzada = new AforocalzadaDTO();
	
	IAforoDTO dtoAforoAnalisis = new AforoanalisisDTO();		
	
	
	@Override
	public Response insertar(AforoOE OE) {
		ObjetoSalida os = dtoAforo.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizar(AforoOE OE) {
		ObjetoSalida os = dtoAforo.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminar(AforoOE OE) {
		ObjetoSalida os = dtoAforo.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltro(AforoOE OE) {
		ObjetoSalida os = dtoAforo.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	// ----- Aforo Dato -----
	@Override
	public Response insertarAforoDato(AforoOE OE) {
		ObjetoSalida os = dtoAforoDato.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizarAforoDato(AforoOE OE) {
		ObjetoSalida os = dtoAforoDato.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminarAforoDato(AforoOE OE) {
		ObjetoSalida os = dtoAforoDato.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltroAforoDato(AforoOE OE) {
		ObjetoSalida os = dtoAforoDato.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	// ----- Aforo Calzada -----
	@Override
	public Response insertarAforoCalzada(AforoOE OE) {
		ObjetoSalida os = dtoAforoCalzada.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizarAforoCalzada(AforoOE OE) {
		ObjetoSalida os = dtoAforoCalzada.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminarAforoCalzada(AforoOE OE) {
		ObjetoSalida os = dtoAforoCalzada.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltroAforoCalzada(AforoOE OE) {
		ObjetoSalida os = dtoAforoCalzada.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	// ----- Aforo Analisis -----
	@Override
	public Response insertarAforoAnalisis(AforoOE OE) {
		ObjetoSalida os = dtoAforoAnalisis.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response actualizarAforoAnalisis(AforoOE OE) {
		ObjetoSalida os = dtoAforoAnalisis.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response eliminarAforoAnalisis(AforoOE OE) {
		ObjetoSalida os = dtoAforoAnalisis.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

	@Override
	public Response consultarXFiltroAforoAnalisis(AforoOE OE) {
		ObjetoSalida os = dtoAforoAnalisis.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response nuevoAforo(AforoOE OE) {
		ObjetoSalida OEE = dtoAforo.nuevoAforo(OE);
		if(OEE.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(OEE).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(OEE).build();
		}
		
	}

	@Override
	public Response calcularAnalisisTransito(AforoOE OE) {
		AforoDTO aforo = new AforoDTO(); 
		ObjetoSalida os = aforo.analisisAforo(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build();
		}
		else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build();
		}
	}

}
