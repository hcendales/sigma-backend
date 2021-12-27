package co.gov.umv.sigma.backend.mejoramiento.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;

public interface IConsultaDAO {
	public ObjetoSalida consultarMantenimientoVial(ConsultaOE OE);
	public ObjetoSalida consultarGestionPendiente(ConsultaOE OE);
	public ObjetoSalida consultarActividadSiguiente(ConsultaOE OE);
	public ObjetoSalida consultarActividadSiguienteSino(ConsultaOE OE);
	public ObjetoSalida consultarDisponibilidadPersonas(ConsultaOE OE);
	public ObjetoSalida consultarProgramaciones(ConsultaOE OE);
	public ObjetoSalida consultarCargaTrabajoActual(ConsultaOE OE);
	public ObjetoSalida consultarUsuarioGestionPrevia(ConsultaOE OE);
	public ObjetoSalida consultarGeneralGestion(ConsultaOE OE);
	public ObjetoSalida consultarSeguimientoUTL(ConsultaOE OE);
	public ObjetoSalida consultarSeguimientos(ConsultaOE OE);
	
	public ObjetoSalida consultarDivisionTerritorial(ConsultaOE OE);
	public ObjetoSalida consultarMantenimientoVialEventos(ConsultaOE OE);
	public ObjetoSalida consultarUnidadesMuestreo(ConsultaOE OE);
	public ObjetoSalida consultarFallas(ConsultaOE OE);
	public ObjetoSalida consultarMantenimientoVialDocumento(ConsultaOE OE);
	public ObjetoSalida consultarMantenimientoVialGestion(ConsultaOE OE);
	public ObjetoSalida consultarOtrosFactores(ConsultaOE OE);
	
	public ObjetoSalida consultarSolicitudesAforosApiques(ConsultaOE oE);
	public ObjetoSalida consultarAreaIntervencion(ConsultaOE oE);
	public ObjetoSalida consultarIntervencionNovedad(ConsultaOE oE);
	public ObjetoSalida consultarSeguimientosProximos(ConsultaOE OE);
	
	public ObjetoSalida consultaRadicadoVinculado(ConsultaOE oE);
	public ObjetoSalida consultaPredisenioAledanio(ConsultaOE oE);
	public ObjetoSalida consultaPredisenioApiques(ConsultaOE oE);
	public ObjetoSalida consultaAlternativasDisenio(ConsultaOE oE);
	public ObjetoSalida consultaDisenioCapa(ConsultaOE oE);
	public ObjetoSalida consultaProgramacionDiaria(ConsultaOE oE);
	public ObjetoSalida consultaProgramacionDiariaPersonal(ConsultaOE oE);
	public ObjetoSalida consultaProgramacionDiariaMaquinaria(ConsultaOE oE);
	public ObjetoSalida consultaProgramacionDiariaMaterial(ConsultaOE oE);
	public ObjetoSalida consultaArchivosMantenimientoVial(ConsultaOE oE);
	public ObjetoSalida consultaCalculadoMantenimientoVial(ConsultaOE oE);
	
	public ObjetoSalida consultarMantenimientoVialDocumentoArchivo(ConsultaOE OE);
	
}
