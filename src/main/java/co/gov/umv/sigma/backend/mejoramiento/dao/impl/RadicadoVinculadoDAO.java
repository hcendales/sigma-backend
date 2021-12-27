package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RadicadoVinculadoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IRadicadoVinculadoDAO;
import oracle.jdbc.OracleTypes;

public class RadicadoVinculadoDAO extends GenericoDAO implements IRadicadoVinculadoDAO {
	private final static String PACKAGE = "pkg_radicado_vinculado"; 
	
	@Override
	public ObjetoSalida insertar(RadicadoVinculadoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
        
            //parametros.add(new SentenciaParametroDAO("p_id_tipo_destino_radicado", OE.getRadicadoVinculado().getIdTipoDestinoRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado", OE.getRadicadoVinculado().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha(OE.getRadicadoVinculado().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_entidad", OE.getRadicadoVinculado().getEntidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_remitente", OE.getRadicadoVinculado().getRemitente(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_dirigido_a", OE.getRadicadoVinculado().getDirigidoA(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_vencimiento", obtenerFecha(OE.getRadicadoVinculado().getFechaVencimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_vinculacion", obtenerFecha(OE.getRadicadoVinculado().getFechaVinculacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getRadicadoVinculado().getPkIdCalzada() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long idMantenimientoVial = (OE.getRadicadoVinculado().getIdMantenimientoVial() == null ) ?  null : OE.getRadicadoVinculado().getIdMantenimientoVial().getIdMantenimientoVial();            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", idMantenimientoVial , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_registro_activo", OE.getRadicadoVinculado().getRegistroActivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_desvinculacion", obtenerFecha(OE.getRadicadoVinculado().getFechaDesvinculacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_salida", OE.getRadicadoVinculado().getNumeroRadicadoSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_salida", obtenerFecha(OE.getRadicadoVinculado().getFechaRadicadoSalida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
            parametros.add(new SentenciaParametroDAO("p_id_tipo_radicado", OE.getRadicadoVinculado().getIdTipoRadicado() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;

	}

	@Override
	public ObjetoSalida actualizar(RadicadoVinculadoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_radicado_vinculado", OE.getRadicadoVinculado().getIdRadicadoVinculado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            //parametros.add(new SentenciaParametroDAO("p_id_tipo_destino_radicado", OE.getRadicadoVinculado().getIdTipoDestinoRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado", OE.getRadicadoVinculado().getNumeroRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado", obtenerFecha(OE.getRadicadoVinculado().getFechaRadicado()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_entidad", OE.getRadicadoVinculado().getEntidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_remitente", OE.getRadicadoVinculado().getRemitente(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_dirigido_a", OE.getRadicadoVinculado().getDirigidoA(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_vencimiento", obtenerFecha(OE.getRadicadoVinculado().getFechaVencimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_vinculacion", obtenerFecha(OE.getRadicadoVinculado().getFechaVinculacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getRadicadoVinculado().getPkIdCalzada() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long idMantenimientoVial = (OE.getRadicadoVinculado().getIdMantenimientoVial() == null ) ?  null : OE.getRadicadoVinculado().getIdMantenimientoVial().getIdMantenimientoVial();
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", idMantenimientoVial , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_registro_activo", OE.getRadicadoVinculado().getRegistroActivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_desvinculacion", obtenerFecha(OE.getRadicadoVinculado().getFechaDesvinculacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_salida", OE.getRadicadoVinculado().getNumeroRadicadoSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_salida", obtenerFecha(OE.getRadicadoVinculado().getFechaRadicadoSalida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
            parametros.add(new SentenciaParametroDAO("p_id_tipo_radicado", OE.getRadicadoVinculado().getIdTipoRadicado() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;	

	}

	@Override
	public ObjetoSalida eliminar(RadicadoVinculadoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_radicado_vinculado", OE.getRadicadoVinculado().getIdRadicadoVinculado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;

	}

	@Override
	public ObjetoSalida consultarXFiltro(RadicadoVinculadoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consultarporfiltro", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;

	}

}
