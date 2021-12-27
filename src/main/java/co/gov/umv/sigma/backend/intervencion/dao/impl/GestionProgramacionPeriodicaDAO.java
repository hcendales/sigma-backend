package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class GestionProgramacionPeriodicaDAO  extends CrudDAO  {

	private final static String PACKAGE = "PKG_GESTION_PROGRAMACION_PERIODICA";

	
	public ObjetoSalida adicionarPKProgramacionPeriodica(IntervencionOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", ((IntervencionOE)OE).getDetalle().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((IntervencionOE)OE).getDetalle().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_adicionarPKProgramacionPeriodica", parametros);  
	}

	
	public ObjetoSalida removerPKProgramacionPeriodica(IntervencionOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica_mv", ((IntervencionOE)OE).getDetalle().getIdProgramacionPeriodicaMV(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_eliminarPKProgramacionPeriodica", parametros);  
	}


	public ObjetoSalida consultarProgramacionPeriodicaActiva(ObjetoEntrada OE) 
	{
		return consultaXFiltro(OE, PACKAGE+".prc_consultarProgramacionPeriodicaActiva");
		
	}


	public ObjetoSalida eliminarProgramacionPeriodica(IntervencionOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", ((IntervencionOE)OE).getProgPeriodica().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_eliminarProgramacionPeriodica", parametros);  
	}


	public ObjetoSalida consultarPKProgramacionPeriodica(ObjetoEntrada OE) {
			return consultaXFiltro(OE, PACKAGE+".prc_consultarPKProgramacionPeriodica");
		
	}


	public ObjetoSalida insertarProgPeriodica(IntervencionOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_tipo_periodo_programacion", ((IntervencionOE)OE).getProgPeriodica().getIdTipoPeriodoProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_km_carril_impacto", ((IntervencionOE)OE).getProgPeriodica().getKmCarrilImpacto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_km_carril_lineal", ((IntervencionOE)OE).getProgPeriodica().getKmCarrilLineal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_km_carril_obra", ((IntervencionOE)OE).getProgPeriodica().getKmCarrilObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_total_dias_duracion_planeada", ((IntervencionOE)OE).getProgPeriodica().getTotalDiasDuracionPlaneada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_total_numero_cuadrillas", ((IntervencionOE)OE).getProgPeriodica().getTotalNumeroCuadrillas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_archivo", ((IntervencionOE)OE).getProgPeriodica().getIdArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((IntervencionOE)OE).getProgPeriodica().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_insertarProgramacionPeriodica", parametros);    
			
	}


	public ObjetoSalida listarPkParaAsociar(IntervencionOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", ((IntervencionOE)OE).getProgPeriodica().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_usuario", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	
		return ejecutar(OE, PACKAGE+".prc_listarPkParaAsociar", parametros);  
	}


	public ObjetoSalida filtrarVigenciasProgramacion(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        return ejecutar(OE, PACKAGE+".prc_filtrarVigenciasProgramacion", parametros);
	}


	public ObjetoSalida actualizarArchivoProgramacionPeriodica(IntervencionOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", ((IntervencionOE)OE).getProgPeriodica().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_archivo", ((IntervencionOE)OE).getProgPeriodica().getIdArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((IntervencionOE)OE).getProgPeriodica().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	
		return ejecutar(OE, PACKAGE+".prc_actualizarArchivoProgramacionPeriodica", parametros);    
	}

}
