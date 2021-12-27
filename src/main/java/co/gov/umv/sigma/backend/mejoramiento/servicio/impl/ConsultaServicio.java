package co.gov.umv.sigma.backend.mejoramiento.servicio.impl;

import javax.ws.rs.core.Response;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;
import co.gov.umv.sigma.backend.mejoramiento.dto.IConsultaDTO;
import co.gov.umv.sigma.backend.mejoramiento.dto.impl.ConsultaDTO;
import co.gov.umv.sigma.backend.mejoramiento.servicio.IConsultaServicio;
import co.gov.umv.sigma.backend.produccion.dto.impl.GestionEnsayoDTO;

public class ConsultaServicio implements IConsultaServicio {

	@Override
	public Response consultarMantenimientoVial(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarMantenimientoVial(OE);		
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarGestionPendiente(ConsultaOE OE) {
		// TODO Auto-generated method stub
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarGestionPendiente(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarActividadSiguiente(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarActividadSiguiente(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarActividadSiguienteSino(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarActividadSiguienteSino(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarDisponibilidadPersonas(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarDisponibilidadPersonas(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarProgramaciones(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarProgramaciones(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarCargaTrabajoActual(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarCargaTrabajoActual(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarUsuarioGestionPrevia(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarUsuarioGestionPrevia(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarGeneralGestion(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarGeneralGestion(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarSeguimientoUTL(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarSeguimientoUTL(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarSeguimientos(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarSeguimientos(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	
	@Override
	public Response consultarDivisionTerritorial(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarDivisionTerritorial(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	@Override
	public Response consultarMantenimientoVialEventos(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarMantenimientoVialEventos(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	public Response consultarUnidadesMuestreo(ConsultaOE OE)
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarUnidadesMuestreo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response consultarFallas(ConsultaOE OE)
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarFallas(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response consultarMantenimientoVialDocumento(ConsultaOE OE)
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarMantenimientoVialDocumento(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response consultarMantenimientoVialGestion(ConsultaOE OE)
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarMantenimientoVialGestion(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response consultarOtrosFactores(ConsultaOE OE)
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarOtrosFactores(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response consultarPkConMantenimientosActivos(ConsultaOE OE)
	{
		GestionEnsayoDTO consulta = new GestionEnsayoDTO();
		ObjetoSalida os = consulta.consultarPkConMantenimientosActivos(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	public Response consultarSolicitudesAforosApiques(ConsultaOE OE)
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarSolicitudesAforosApiques(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarAreaIntervencion(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarAreaIntervencion(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarIntervencionNovedad(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarIntervencionNovedad(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarSeguimientosProximos(ConsultaOE OE) 
	{
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarSeguimientosProximos(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	/********************************************/
	@Override
	public Response consultaRadicadoVinculado(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaRadicadoVinculado(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaPredisenioAledanio(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaPredisenioAledanio(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaPredisenioApiques(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaPredisenioApiques(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaAlternativasDisenio(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaAlternativasDisenio(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaDisenioCapa(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaDisenioCapa(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaProgramacionDiaria(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaProgramacionDiaria(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaProgramacionDiariaPersonal(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaProgramacionDiariaPersonal(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaProgramacionDiariaMaquinaria(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaProgramacionDiariaMaquinaria(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaProgramacionDiariaMaterial(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaProgramacionDiariaMaterial(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaArchivosMantenimientoVial(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaArchivosMantenimientoVial(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultaCalculadoMantenimientoVial(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultaCalculadoMantenimientoVial(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}

	@Override
	public Response consultarMantenimientoVialDocumentoArchivo(ConsultaOE OE) {
		IConsultaDTO consulta = new ConsultaDTO();
		ObjetoSalida os = consulta.consultarMantenimientoVialDocumentoArchivo(OE);
		return Response.status(Response.Status.OK).entity(os).build();
	}
	
	
	
	
	
}
