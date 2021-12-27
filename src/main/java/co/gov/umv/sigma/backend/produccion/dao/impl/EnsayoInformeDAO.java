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

public class EnsayoInformeDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_ENSAYO_INFORME";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getInforme().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_resultado", ((LaboratorioOE)OE).getInforme().getIdTipoResultado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_ejecucion", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_resultado", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaResultado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_laboratorio", ((LaboratorioOE)OE).getInforme().getIdUsuarioLaboratorio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((LaboratorioOE)OE).getInforme().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_nombre_ensayo", ((LaboratorioOE)OE).getInforme().getNombreEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_documento_informe", ((LaboratorioOE)OE).getInforme().getIdDocumentoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_novedades", ((LaboratorioOE)OE).getInforme().getNovedades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_programacion", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaProgramacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado", ((LaboratorioOE)OE).getInforme().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_asunto", ((LaboratorioOE)OE).getInforme().getAsunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		parametros.add(new SentenciaParametroDAO("p_fecha_envio", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaEnvio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
			
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_informe", ((LaboratorioOE)OE).getInforme().getIdEnsayoinforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getInforme().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_resultado", ((LaboratorioOE)OE).getInforme().getIdTipoResultado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_ejecucion", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_resultado", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaResultado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_laboratorio", ((LaboratorioOE)OE).getInforme().getIdUsuarioLaboratorio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((LaboratorioOE)OE).getInforme().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_nombre_ensayo", ((LaboratorioOE)OE).getInforme().getNombreEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_documento_informe", ((LaboratorioOE)OE).getInforme().getIdDocumentoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_novedades", ((LaboratorioOE)OE).getInforme().getNovedades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_programacion", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaProgramacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado", ((LaboratorioOE)OE).getInforme().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_asunto", ((LaboratorioOE)OE).getInforme().getAsunto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

		parametros.add(new SentenciaParametroDAO("p_fecha_envio", obtenerFecha( ((LaboratorioOE)OE).getInforme().getFechaEnvio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo_informe", ((LaboratorioOE)OE).getInforme().getIdEnsayoinforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
				
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	
	public ObjetoSalida eliminarPorEnsayo(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getInforme().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_eliminar_por_ensayo", parametros);
	}


	public ObjetoSalida eliminarXCodigoEnsayo(LaboratorioOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_codigo_ensayo", ((LaboratorioOE)OE).getEnsayo().getCodigoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar_por_codigo", parametros);
	}
	

}