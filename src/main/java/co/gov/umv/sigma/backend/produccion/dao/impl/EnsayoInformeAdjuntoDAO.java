package co.gov.umv.sigma.backend.produccion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import oracle.jdbc.OracleTypes;

public class EnsayoInformeAdjuntoDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_ENSAYO_INFORME_ADJUNTO";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_informe", ((LaboratorioOE)OE).getInformeAdjunto().getIdEnsayoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha( ((LaboratorioOE)OE).getInformeAdjunto().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_cargue", obtenerFecha( ((LaboratorioOE)OE).getInformeAdjunto().getFechaCargue()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado", ((LaboratorioOE)OE).getInformeAdjunto().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_asunto", ((LaboratorioOE)OE).getInformeAdjunto().getAsunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_descarga", ((LaboratorioOE)OE).getInformeAdjunto().getDescarga(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_informe_adjunto", ((LaboratorioOE)OE).getInformeAdjunto().getIdEnsayoInformeAdjunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_informe", ((LaboratorioOE)OE).getInformeAdjunto().getIdEnsayoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha( ((LaboratorioOE)OE).getInformeAdjunto().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_cargue", obtenerFecha( ((LaboratorioOE)OE).getInformeAdjunto().getFechaCargue()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado", ((LaboratorioOE)OE).getInformeAdjunto().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_asunto", ((LaboratorioOE)OE).getInformeAdjunto().getAsunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_descarga", ((LaboratorioOE)OE).getInformeAdjunto().getDescarga(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_informe_adjunto", ((LaboratorioOE)OE).getInformeAdjunto().getIdEnsayoInformeAdjunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
				
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}