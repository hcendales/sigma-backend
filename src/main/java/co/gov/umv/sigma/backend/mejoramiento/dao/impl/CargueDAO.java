package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.comun.entidad.TabCargueDetalle;
import co.gov.umv.sigma.backend.mejoramiento.cbo.CargueOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICargueDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class CargueDAO  extends GenericoDAO  implements ICargueDAO, ICrudDAO
{
	private final static String PACKAGE_CARGUE = "PKG_CARGUE"; 
	
	private final static String PACKAGE_ARCHIVOS = "PKG_CARGUE_ARCHIVOS"; 
	
	private final static String PACKAGE_CARGUE_DET = "PKG_CARGUE_DETALLE"; 

	private final static String PACKAGE_CARGUE_DET_LOG = "PKG_CARGUE_DETALLE_LOG"; 

	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_cargue", ((CargueOE)OE).getIdTipoCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_nombre_archivo", ((CargueOE)OE).getNombreArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_recibido", obtenerFecha(((CargueOE)OE).getFechaRecibido()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_cantidad_registros", ((CargueOE)OE).getCantidadRegistros(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_validado", obtenerFecha(((CargueOE)OE).getFechaValidado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_validado_correcto", ((CargueOE)OE).getValidadoCorrecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cantidad_registros_novalidos", ((CargueOE)OE).getCantidadRegistrosNovalidos(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_procesado", obtenerFecha(((CargueOE)OE).getFechaProcesado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_procesado_correcto", ((CargueOE)OE).getProcesadoCorrecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cantidad_registros_error", ((CargueOE)OE).getCantidadRegistrosError(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}

	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
        	 SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_cargue", ((CargueOE)OE).getIdCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_cargue", ((CargueOE)OE).getIdTipoCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_nombre_archivo", ((CargueOE)OE).getNombreArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_recibido", obtenerFecha(((CargueOE)OE).getFechaRecibido()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_cantidad_registros", ((CargueOE)OE).getCantidadRegistros(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_validado", obtenerFecha(((CargueOE)OE).getFechaValidado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_validado_correcto", ((CargueOE)OE).getValidadoCorrecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cantidad_registros_novalidos", ((CargueOE)OE).getCantidadRegistrosNovalidos(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_procesado", obtenerFecha(((CargueOE)OE).getFechaProcesado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_procesado_correcto", ((CargueOE)OE).getProcesadoCorrecto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cantidad_registros_error", ((CargueOE)OE).getCantidadRegistrosError(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}
	
	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
        	SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_cargue", ((CargueOE)OE).getIdCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}
	
	

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
        	SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE+".prc_consultarporfiltro", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}

	
	private ObjetoSalida gestionar(CargueOE OE, String procedimiento) 
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_ARCHIVOS+procedimiento, OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_cargue", OE.getIdCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarY(sentencia, objetoSalida);
            
            if(objetoSalida.getCodError() != CodError.OPERACION_CORRECTA)
            	if(objetoSalida.getRespuesta() != null)
            		if(objetoSalida.getRespuesta().size() > 0)
            			objetoSalida.setCodError(CodError.PROCESADO_CON_ERRORES);
            		
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}
	
	
	@Override
	public ObjetoSalida procesarCargueTipo1(CargueOE OE) {
		return gestionar(OE, ".PRC_PROCESAR_CARGUE_TIPO1");
	}
	@Override
	public ObjetoSalida procesarCargueTipo2(CargueOE OE) {
		return gestionar(OE, ".PRC_PROCESAR_CARGUE_TIPO2");
	}
	@Override
	public ObjetoSalida procesarCargueTipo4(CargueOE OE) {
		return gestionar(OE, ".PRC_PROCESAR_CARGUE_TIPO4");
	}
	@Override
	public ObjetoSalida validarCargueTipo1(CargueOE OE) {
		return gestionar(OE, ".PRC_VALIDAR_CARGUE_TIPO1");
	}
	@Override
	public ObjetoSalida validarCargueTipo2(CargueOE OE) {
		return gestionar(OE, ".PRC_VALIDAR_CARGUE_TIPO2");
	}
	@Override
	public ObjetoSalida validarCargueTipo4(CargueOE OE) {
		return gestionar(OE, ".PRC_VALIDAR_CARGUE_TIPO4");
	}
		
	
	@Override
	public ObjetoSalida eliminarDetalles(CargueOE OE) 
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
        	SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE_DET+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_cargue_detalle", OE.getIdCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}

	
	@Override
	public ObjetoSalida insertaDetalle(TabCargueDetalle info, Long idCargue, String usuario)
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
        	SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE_DET+".prc_insertar", usuario);
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_cargue", idCargue, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            parametros.add(new SentenciaParametroDAO("p_campo_1", info.getCampo1(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_2", info.getCampo2(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_3", info.getCampo3(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_4", info.getCampo4(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_5", info.getCampo5(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_6", info.getCampo6(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_7", info.getCampo7(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_8", info.getCampo8(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_9", info.getCampo9(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_10", info.getCampo10(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_11", info.getCampo11(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_12", info.getCampo12(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_13", info.getCampo13(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_14", info.getCampo14(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_15", info.getCampo15(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_16", info.getCampo16(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_17", info.getCampo17(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_18", info.getCampo18(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_19", info.getCampo19(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_campo_20", info.getCampo20(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}

	

	@Override
	public ObjetoSalida consultarPorFiltro(CargueOE OE)
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
        	SentenciaDAO sentencia = new SentenciaDAO(PACKAGE_CARGUE_DET_LOG+".prc_consultarporfiltro", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
          
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
          
        }
        return objetoSalida;
	}
	

}
