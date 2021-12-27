package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FallaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IFallaDAO;
import oracle.jdbc.OracleTypes;

public class FallaDAO extends GenericoDAO implements IFallaDAO {
	private final static String PACKAGE = "pkg_falla"; 
	@Override
	public ObjetoSalida insertar(FallaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            Float distancia = (OE.getFalla().getDistancia() == null) ? null : OE.getFalla().getDistancia().floatValue();
            parametros.add(new SentenciaParametroDAO("p_distancia", distancia, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getFalla().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_falla", OE.getFalla().getIdTipoFalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_severidad", OE.getFalla().getIdTipoSeveridad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float longitud = (OE.getFalla().getLongitud() == null) ? null : OE.getFalla().getLongitud().floatValue();           
            parametros.add(new SentenciaParametroDAO("p_longitud", longitud, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float ancho = (OE.getFalla().getAncho() == null) ? null : OE.getFalla().getAncho().floatValue();
            parametros.add(new SentenciaParametroDAO("p_ancho", ancho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float area = (OE.getFalla().getArea() == null) ? null : OE.getFalla().getArea().floatValue();
            parametros.add(new SentenciaParametroDAO("p_area", area, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", OE.getFalla().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_losas", OE.getFalla().getNumeroLosas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getFalla().getIdUnidadMuestreo().getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
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
	public ObjetoSalida actualizar(FallaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_falla", OE.getFalla().getIdFalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            Float distancia = (OE.getFalla().getDistancia() == null) ? null : OE.getFalla().getDistancia().floatValue();
            parametros.add(new SentenciaParametroDAO("p_distancia", distancia, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getFalla().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_falla", OE.getFalla().getIdTipoFalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_severidad", OE.getFalla().getIdTipoSeveridad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float longitud = (OE.getFalla().getLongitud() == null) ? null : OE.getFalla().getLongitud().floatValue();           
            parametros.add(new SentenciaParametroDAO("p_longitud", longitud, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float ancho = (OE.getFalla().getAncho() == null) ? null : OE.getFalla().getAncho().floatValue();
            parametros.add(new SentenciaParametroDAO("p_ancho", ancho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float area = (OE.getFalla().getArea() == null) ? null : OE.getFalla().getArea().floatValue();
            parametros.add(new SentenciaParametroDAO("p_area", area, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", OE.getFalla().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_losas", OE.getFalla().getNumeroLosas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getFalla().getIdUnidadMuestreo().getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
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
	public ObjetoSalida eliminar(FallaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_falla", OE.getFalla().getIdFalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
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
	public ObjetoSalida consultarXFiltro(FallaOE OE) {
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
