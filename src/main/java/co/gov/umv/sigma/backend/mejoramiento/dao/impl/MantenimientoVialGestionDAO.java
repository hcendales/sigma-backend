package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialGestionOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialGestionDAO;
import oracle.jdbc.OracleTypes;

public class MantenimientoVialGestionDAO extends GenericoDAO implements IMantenimientoVialGestionDAO {

	private final static String PACKAGE = "pkg_mantenimiento_vial_gestion"; 
	@Override
	public ObjetoSalida insertar(MantenimientoVialGestionOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientoVialGestion().getIdMantenimientoVial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getMantenimientoVialGestion().getIdActividad().getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_asignacion", obtenerFecha(OE.getMantenimientoVialGestion().getFechaAsignacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_vencimiento", obtenerFecha(OE.getMantenimientoVialGestion().getFechaVencimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_gestion", OE.getMantenimientoVialGestion().getIdTipoEstadoGestion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona", OE.getMantenimientoVialGestion().getIdPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_area", OE.getMantenimientoVialGestion().getIdTipoArea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo", OE.getMantenimientoVialGestion().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha(OE.getMantenimientoVialGestion().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(OE.getMantenimientoVialGestion().getFechaFin()) , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_observacion", OE.getMantenimientoVialGestion().getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        
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
	public ObjetoSalida actualizar(MantenimientoVialGestionOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_gestion", OE.getMantenimientoVialGestion().getIdMantenimientoVialGestion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientoVialGestion().getIdMantenimientoVial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getMantenimientoVialGestion().getIdActividad().getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_asignacion", obtenerFecha(OE.getMantenimientoVialGestion().getFechaAsignacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_vencimiento", obtenerFecha(OE.getMantenimientoVialGestion().getFechaVencimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_gestion", OE.getMantenimientoVialGestion().getIdTipoEstadoGestion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona", OE.getMantenimientoVialGestion().getIdPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_area", OE.getMantenimientoVialGestion().getIdTipoArea(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo", OE.getMantenimientoVialGestion().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha(OE.getMantenimientoVialGestion().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(OE.getMantenimientoVialGestion().getFechaFin()) , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_observacion", OE.getMantenimientoVialGestion().getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
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
	public ObjetoSalida eliminar(MantenimientoVialGestionOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_gestion", OE.getMantenimientoVialGestion().getIdMantenimientoVialGestion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
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
	public ObjetoSalida consultarXFiltro(MantenimientoVialGestionOE OE) {
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
