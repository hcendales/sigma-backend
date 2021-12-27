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

public class TipoPeriodoProgramacionDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_TIPO_PERIODO_PROGRAMACION";

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_vigencia", ((IntervencionOE)OE).getTipoProgramacion().getVigencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_periodicidad", ((IntervencionOE)OE).getTipoProgramacion().getIdTipoPeriodicidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((IntervencionOE)OE).getTipoProgramacion().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((IntervencionOE)OE).getTipoProgramacion().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_dias_laborales", ((IntervencionOE)OE).getTipoProgramacion().getDiasLaborales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_nombre_periodo", ((IntervencionOE)OE).getTipoProgramacion().getNombrePeriodo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);    
			
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_periodo_programacion", ((IntervencionOE)OE).getTipoProgramacion().getIdTipoPeriodoProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_vigencia", ((IntervencionOE)OE).getTipoProgramacion().getVigencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_periodicidad", ((IntervencionOE)OE).getTipoProgramacion().getIdTipoPeriodicidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((IntervencionOE)OE).getTipoProgramacion().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((IntervencionOE)OE).getTipoProgramacion().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_dias_laborales", ((IntervencionOE)OE).getTipoProgramacion().getDiasLaborales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_nombre_periodo", ((IntervencionOE)OE).getTipoProgramacion().getNombrePeriodo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);    
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();

		parametros.add(new SentenciaParametroDAO("p_id_tipo_periodo_programacion", ((IntervencionOE)OE).getTipoProgramacion().getIdTipoPeriodoProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);    
	}

}
