
package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IConsultaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.ConsultaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IConsultaDTO;

public class ConsultaDTO implements IConsultaDTO {

	@Override
	public ObjetoSalida consultarMantenimientoVial(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();		
		return modelo.consultarMantenimientoVial(OE);
	}

	@Override
	public ObjetoSalida consultarGestionPendiente(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarGestionPendiente(OE);
	}

	@Override
	public ObjetoSalida consultarActividadSiguiente(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarActividadSiguiente(OE);
	}

	@Override
	public ObjetoSalida consultarActividadSiguienteSino(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarActividadSiguienteSino(OE);
	}

	@Override
	public ObjetoSalida consultarDisponibilidadPersonas(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarDisponibilidadPersonas(OE);
	}

	@Override
	public ObjetoSalida consultarProgramaciones(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarProgramaciones(OE);
	}

	@Override
	public ObjetoSalida consultarCargaTrabajoActual(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarCargaTrabajoActual(OE);
	}

	@Override
	public ObjetoSalida consultarUsuarioGestionPrevia(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarUsuarioGestionPrevia(OE);
	}

	@Override
	public ObjetoSalida consultarGeneralGestion(ConsultaOE OE) 
	{
		ObjetoSalida OS = new ObjetoSalida();
		try 
		{
			validoParamPk(OE);
			IConsultaDAO modelo = new ConsultaDAO();
			OS = modelo.consultarGeneralGestion(OE);
		} 
		catch (Exception e) 
		{
			OS.setCodError(CodError.ERROR_INTERNO);
			OS.setMsgError(e.getMessage());
		}
		
		return OS;
	}

	@Override
	public ObjetoSalida consultarSeguimientoUTL(ConsultaOE OE) 
	{
		ObjetoSalida OS = new ObjetoSalida();
		try 
		{
			validoParamPk(OE);
			IConsultaDAO modelo = new ConsultaDAO();
			OS = modelo.consultarSeguimientoUTL(OE);
		} 
		catch (Exception e) 
		{
			OS.setCodError(CodError.ERROR_INTERNO);
			OS.setMsgError(e.getMessage());
		}
		
		return OS;
	}

	@Override
	public ObjetoSalida consultarSeguimientos(ConsultaOE OE) 
	{
		ObjetoSalida OS = new ObjetoSalida();
		try 
		{
			validoParamPk(OE);
			IConsultaDAO modelo = new ConsultaDAO();
			OS = modelo.consultarSeguimientos(OE);
		} 
		catch (Exception e) 
		{
			OS.setCodError(CodError.ERROR_INTERNO);
			OS.setMsgError(e.getMessage());
		}
		
		return OS;
	}
	
	private void validoParamPk(ConsultaOE OE) throws Exception 
	{
		if(OE.getPkIdCalzada() != null)
		{
			//se valida que No se pueden enviar mas de 1000 valores de pk.
			String[] pks = OE.getPkIdCalzada().split(","); 
			if(pks.length > 1000)
				throw new Exception("No se pueden enviar mas de 1000 valores de pk");
			
		}
		
	}

	@Override
	public ObjetoSalida consultarDivisionTerritorial(ConsultaOE OE) 
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarDivisionTerritorial(OE);
	}

	@Override
	public ObjetoSalida consultarMantenimientoVialEventos(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarMantenimientoVialEventos(OE);
	}

	
	public ObjetoSalida consultarUnidadesMuestreo(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarUnidadesMuestreo(OE);
	}
	
	public ObjetoSalida consultarFallas(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarFallas(OE);
	}
	
	public ObjetoSalida consultarMantenimientoVialDocumento(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarMantenimientoVialDocumento(OE);
	}
	
	public ObjetoSalida consultarMantenimientoVialGestion(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarMantenimientoVialGestion(OE);
	}
	
	public ObjetoSalida consultarOtrosFactores(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarOtrosFactores(OE);
	}

		
	public ObjetoSalida consultarSolicitudesAforosApiques(ConsultaOE OE)
	{
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarSolicitudesAforosApiques(OE);
	}

	@Override
	public ObjetoSalida consultarAreaIntervencion(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarAreaIntervencion(OE);
	}

	@Override
	public ObjetoSalida consultarIntervencionNovedad(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarIntervencionNovedad(OE);
	}

	@Override
	public ObjetoSalida consultarSeguimientosProximos(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarSeguimientosProximos(OE);
	}
	
	/***************************************************/

	@Override
	public ObjetoSalida consultaRadicadoVinculado(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaRadicadoVinculado(OE);
	}

	@Override
	public ObjetoSalida consultaPredisenioAledanio(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaPredisenioAledanio(OE);
	}

	@Override
	public ObjetoSalida consultaPredisenioApiques(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaPredisenioApiques(OE);
	}

	@Override
	public ObjetoSalida consultaAlternativasDisenio(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaAlternativasDisenio(OE);
	}

	@Override
	public ObjetoSalida consultaDisenioCapa(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaDisenioCapa(OE);
	}

	@Override
	public ObjetoSalida consultaProgramacionDiaria(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaProgramacionDiaria(OE);
	}

	@Override
	public ObjetoSalida consultaProgramacionDiariaPersonal(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaProgramacionDiariaPersonal(OE);
	}

	@Override
	public ObjetoSalida consultaProgramacionDiariaMaquinaria(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaProgramacionDiariaMaquinaria(OE);
	}

	@Override
	public ObjetoSalida consultaProgramacionDiariaMaterial(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaProgramacionDiariaMaterial(OE);
	}

	@Override
	public ObjetoSalida consultaArchivosMantenimientoVial(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaArchivosMantenimientoVial(OE);
	}

	@Override
	public ObjetoSalida consultaCalculadoMantenimientoVial(ConsultaOE oE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultaCalculadoMantenimientoVial(oE);
	}

	@Override
	public ObjetoSalida consultarMantenimientoVialDocumentoArchivo(ConsultaOE OE) {
		IConsultaDAO modelo = new ConsultaDAO();
		return modelo.consultarMantenimientoVialDocumentoArchivo(OE);
	}
	
}
