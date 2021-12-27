package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IAforoDAO;
import oracle.jdbc.OracleTypes;

public class AforoCalzadaDAO extends GenericoDAO implements IAforoDAO {
	
	private final static String PACKAGE = "pkg_aforo_calzada";

	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            /**
             * p_id_aforo                     IN   tab_aforo_calzada.id_aforo%TYPE,
        p_pk_id_calzada                IN   tab_aforo_calzada.pk_id_calzada%TYPE,
        p_aledanio                     IN   tab_aforo_calzada.aledanio%TYPE,
        p_civ                          IN   tab_aforo_calzada.civ%TYPE,
        p_eje_vial                     IN   tab_aforo_calzada.eje_vial%TYPE,
        p_desde                        IN   tab_aforo_calzada.desde%TYPE,
        p_hasta                        IN   tab_aforo_calzada.hasta%TYPE,
        p_id_localidad                 IN   tab_aforo_calzada.id_localidad%TYPE,
        p_descripcion_localidad        IN   tab_aforo_calzada.descripcion_localidad%TYPE,
        p_id_tipo_superficie           IN   tab_aforo_calzada.id_tipo_superficie%TYPE,
        p_descripcion_tipo_superficie  IN   tab_aforo_calzada.descripcion_tipo_superficie%TYPE,
        
             * */
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
			parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforocalzada().getIdAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getAforocalzada().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_aledanio", OE.getAforocalzada().getAledanio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_civ", OE.getAforocalzada().getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_eje_vial", OE.getAforocalzada().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_desde", OE.getAforocalzada().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
			parametros.add(new SentenciaParametroDAO("p_hasta", OE.getAforocalzada().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
			parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getAforocalzada().getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_descripcion_localidad", OE.getAforocalzada().getDescripcionLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getAforocalzada().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_descripcion_tipo_superficie", OE.getAforocalzada().getDescripcionTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			sentencia.setParametros(parametros);
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
	public ObjetoSalida actualizar(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
        
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
			parametros.add(new SentenciaParametroDAO("p_id_aforo_calzada", OE.getAforocalzada().getIdAforoCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforocalzada().getIdAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getAforocalzada().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_aledanio", OE.getAforocalzada().getAledanio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_civ", OE.getAforocalzada().getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_eje_vial", OE.getAforocalzada().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_desde", OE.getAforocalzada().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
			parametros.add(new SentenciaParametroDAO("p_hasta", OE.getAforocalzada().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
			parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getAforocalzada().getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_descripcion_localidad", OE.getAforocalzada().getDescripcionLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getAforocalzada().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_descripcion_tipo_superficie", OE.getAforocalzada().getDescripcionTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			sentencia.setParametros(parametros);
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
	public ObjetoSalida eliminar(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
        
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
            parametros.add(new SentenciaParametroDAO("p_id_aforo_calzada", OE.getAforocalzada().getIdAforoCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		    sentencia.setParametros(parametros);
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
	public ObjetoSalida consultarXFiltro(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE + ".prc_consultarporfiltro", OE.getUsuario());
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
