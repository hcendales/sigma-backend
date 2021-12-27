package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class ProgramacionPeriodicaDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_PROGRAMACION_PERIODICA";

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
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
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);    
			
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", ((IntervencionOE)OE).getProgPeriodica().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_periodo_programacion", ((IntervencionOE)OE).getProgPeriodica().getIdTipoPeriodoProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_km_carril_impacto", ((IntervencionOE)OE).getProgPeriodica().getKmCarrilImpacto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_km_carril_lineal", ((IntervencionOE)OE).getProgPeriodica().getKmCarrilLineal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_km_carril_obra", ((IntervencionOE)OE).getProgPeriodica().getKmCarrilObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_total_dias_duracion_planeada", ((IntervencionOE)OE).getProgPeriodica().getTotalDiasDuracionPlaneada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_total_numero_cuadrillas", ((IntervencionOE)OE).getProgPeriodica().getTotalNumeroCuadrillas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_archivo", ((IntervencionOE)OE).getProgPeriodica().getIdArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((IntervencionOE)OE).getProgPeriodica().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);    
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", ((IntervencionOE)OE).getProgPeriodica().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);    
	}

}