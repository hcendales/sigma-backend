package co.gov.umv.sigma.backend.intervencion.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.InformacionDiariaCuadrillaOE;
import co.gov.umv.sigma.backend.intervencion.dao.impl.InfDiaCuadrillaEntrMaterialDAO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaCalidadDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaCantidadObraDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaEntrMaterialDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaMaquinariaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaMezclaDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaObservacionDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaPersonalDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InfDiaCuadrillaSalMaterialDTO;
import co.gov.umv.sigma.backend.intervencion.dto.impl.InformacionDiariaCuadrillaDTO;
import co.gov.umv.sigma.backend.intervencion.servicio.IInformeDiarioCuadrillaServicio;

public class InformeDiarioCuadrillaServicio implements IInformeDiarioCuadrillaServicio {
	
	InformacionDiariaCuadrillaDTO dtoIDC = new InformacionDiariaCuadrillaDTO();
	InfDiaCuadrillaPersonalDTO dtoPersonal = new InfDiaCuadrillaPersonalDTO();
	InfDiaCuadrillaCantidadObraDTO dtoCantidad = new InfDiaCuadrillaCantidadObraDTO();
	InfDiaCuadrillaSalMaterialDTO dtoSalMaterial = new InfDiaCuadrillaSalMaterialDTO();
	InfDiaCuadrillaEntrMaterialDTO dtoEntrMaterial = new InfDiaCuadrillaEntrMaterialDTO();
	InfDiaCuadrillaCalidadDTO dtoCalidad = new InfDiaCuadrillaCalidadDTO();
	InfDiaCuadrillaMaquinariaDTO dtoMaquinaria = new InfDiaCuadrillaMaquinariaDTO();
	InfDiaCuadrillaMezclaDTO dtoMezcla = new InfDiaCuadrillaMezclaDTO();
	InfDiaCuadrillaObservacionDTO dtoObservacion = new InfDiaCuadrillaObservacionDTO();
	
	@Override
	public Response insertar(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoIDC.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
		
	}

	@Override
	public Response actualizar(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoIDC.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminar(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoIDC.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltro(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoIDC.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarPersonal(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoPersonal.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarPersonal(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoPersonal.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarPersonal(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoPersonal.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltroPersonal(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoPersonal.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarMaquinaria(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMaquinaria.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarMaquinaria(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMaquinaria.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarMaquinaria(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMaquinaria.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltroMaquinaria(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMaquinaria.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarentradaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoEntrMaterial.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarentradaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoEntrMaterial.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarentradaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoEntrMaterial.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltroentradaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoEntrMaterial.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarsalidaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoSalMaterial.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarsalidaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoSalMaterial.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarsalidaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoSalMaterial.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltrosalidaMaterial(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoSalMaterial.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarmezcla(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMezcla.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarmezcla(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMezcla.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarmezcla(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMezcla.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltromezcla(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoMezcla.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarcantidadObra(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCantidad.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarcantidadObra(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCantidad.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarcantidadObra(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCantidad.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltrocantidadObra(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCantidad.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarcalidad(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCalidad.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarcalidad(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCalidad.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarcalidad(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCalidad.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltrocalidad(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoCalidad.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

	@Override
	public Response insertarobservacion(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoObservacion.insertar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response actualizarobservacion(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoObservacion.actualizar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response eliminarobservacion(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoObservacion.eliminar(OE);
		if(os.esRespuestaOperacionCorrecta()) {
			return Response.status(Response.Status.OK).entity(os).build() ;
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(os).build() ;
		}
	}

	@Override
	public Response consultarXFiltroObservacion(InformacionDiariaCuadrillaOE OE) {
		ObjetoSalida os = dtoObservacion.consultarXFiltro(OE);
		return Response.status(Response.Status.OK).entity(os).build() ;
	}

}
