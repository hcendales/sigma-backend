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

public class AforoAnalisisDAO extends GenericoDAO implements IAforoDAO {

	private final static String PACKAGE = "pkg_aforo_analisis";

	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());        
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        	parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforoanalisis().getIdAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_periodo_disenio", OE.getAforoanalisis().getPeriodoDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_anio", OE.getAforoanalisis().getAnio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_tpd", convertirBigDecimalaDouble(OE.getAforoanalisis().getTpd()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			parametros.add(new SentenciaParametroDAO("p_buses_van", convertirBigDecimalaDouble(OE.getAforoanalisis().getBusesVan()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_buses_buseta", convertirBigDecimalaDouble(OE.getAforoanalisis().getBusesBuseta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_buses_sitp_alimentadores", convertirBigDecimalaDouble(OE.getAforoanalisis().getBusesSitpAlimentadores()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));					
			parametros.add(new SentenciaParametroDAO("p_camiones_c2p", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC2p()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_camiones_c2g", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC2g()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_camiones_c3_c4", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC3C4()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_camiones_c5_c5", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC5C5()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_vc_acumulados", convertirBigDecimalaDouble(OE.getAforoanalisis().getVcAcumulados()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_nee_anios", convertirBigDecimalaDouble(OE.getAforoanalisis().getNeeAnios()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_nee_acumulados", convertirBigDecimalaDouble(OE.getAforoanalisis().getNeeAcumulados()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
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
    		parametros.add(new SentenciaParametroDAO("p_id_aforo_analisis", OE.getAforoanalisis().getIdAforoAnalisis(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforoanalisis().getIdAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_periodo_disenio", OE.getAforoanalisis().getPeriodoDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_anio", OE.getAforoanalisis().getAnio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_tpd", convertirBigDecimalaDouble(OE.getAforoanalisis().getTpd()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			parametros.add(new SentenciaParametroDAO("p_buses_van", convertirBigDecimalaDouble(OE.getAforoanalisis().getBusesVan()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_buses_buseta", convertirBigDecimalaDouble(OE.getAforoanalisis().getBusesBuseta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_buses_sitp_alimentadores", convertirBigDecimalaDouble(OE.getAforoanalisis().getBusesSitpAlimentadores()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));					
			parametros.add(new SentenciaParametroDAO("p_camiones_c2p", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC2p()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_camiones_c2g", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC2g()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_camiones_c3_c4", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC3C4()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_camiones_c5_c5", convertirBigDecimalaDouble(OE.getAforoanalisis().getCamionesC5C5()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_vc_acumulados", convertirBigDecimalaDouble(OE.getAforoanalisis().getVcAcumulados()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_nee_anios", convertirBigDecimalaDouble(OE.getAforoanalisis().getNeeAnios()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_nee_acumulados", convertirBigDecimalaDouble(OE.getAforoanalisis().getNeeAcumulados()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
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
    		parametros.add(new SentenciaParametroDAO("p_id_aforo_analisis", ((AforoOE)OE).getAforoanalisis().getIdAforoAnalisis(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		

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
