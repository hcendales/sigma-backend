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
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IAforoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class AforoDAO extends GenericoDAO implements IAforoDAO {

	private final static String PACKAGE = "pkg_aforo";


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
	

	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
        
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
			parametros.add(new SentenciaParametroDAO("p_fecha_aforo", obtenerFecha(((AforoOE)OE).getAforo().getFechaAforo()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
			parametros.add(new SentenciaParametroDAO("p_digital", ((AforoOE)OE).getAforo().getDigital(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_id_cargue", ((AforoOE)OE).getAforo().getIdCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_origen_informacion", ((AforoOE)OE).getAforo().getOrigenInformacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_observaciones", ((AforoOE)OE).getAforo().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_tpd_total", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getTpdTotal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			parametros.add(new SentenciaParametroDAO("p_fd_sitp_alimentadores", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdSitpAlimentadores()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			parametros.add(new SentenciaParametroDAO("p_fd_van", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdVan()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_fd_buses_busetas", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdBusesBusetas()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_fd_c2p", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC2p()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_fd_c2g", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC2g()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_fd_c3_c4", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC3C4()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_fd_c5_c5", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC5C5()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_tasa_crecimiento_r", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getTasaCrecimientoR()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_factor_direccional_fd", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFactorDireccionalFd()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_factor_distribucion_carril_fdc", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFactorDistribucionCarrilFdc()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_analisis_referencias", ((AforoOE)OE).getAforo().getAnalisisReferencias(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_analisis_observaciones", ((AforoOE)OE).getAforo().getAnalisisObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			parametros.add(new SentenciaParametroDAO("p_analisis_nee_8_2", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAnalisisNee82()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_anios_8_2", ((AforoOE)OE).getAforo().getAnios82(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_analisis2_nee_8_2", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAnalisis2Nee82()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_anios2_8_2", ((AforoOE)OE).getAforo().getAnios282(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
			parametros.add(new SentenciaParametroDAO("p_analisis_tpd_v_comerciales_3_5", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAnalisisTpdVComerciales35()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_anios_3_5", ((AforoOE)OE).getAforo().getAnios35(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			
			parametros.add(new SentenciaParametroDAO("p_t_automoviles", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAutomoviles()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_buses_van", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getBusesVan()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_buses_buseta", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getBusesBuseta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_buses_sitp_alimentadores", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getBusesSitpAlimentadores()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			parametros.add(new SentenciaParametroDAO("p_t_camiones_c2p", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC2p()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_camiones_c2g", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC2g()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_camiones_c3_c4", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC3C4()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_camiones_c5_c5", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC5C5()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_t_vc_acumulados", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getVcAcumulados()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_id_documento_pdf", ((AforoOE)OE).getAforo().getIdDocumentoPdf(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
    		parametros.add(new SentenciaParametroDAO("p_id_aforo", ((AforoOE)OE).getAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_fecha_aforo", obtenerFecha(((AforoOE)OE).getAforo().getFechaAforo()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
    		parametros.add(new SentenciaParametroDAO("p_digital", ((AforoOE)OE).getAforo().getDigital(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_id_cargue", ((AforoOE)OE).getAforo().getIdCargue(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_origen_informacion", ((AforoOE)OE).getAforo().getOrigenInformacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_observaciones", ((AforoOE)OE).getAforo().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_tpd_total", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getTpdTotal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_fd_sitp_alimentadores", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdSitpAlimentadores()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_fd_van", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdVan()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_fd_buses_busetas", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdBusesBusetas()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_fd_c2p", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC2p()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_fd_c2g", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC2g()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_fd_c3_c4", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC3C4()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_fd_c5_c5", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFdC5C5()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_tasa_crecimiento_r", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getTasaCrecimientoR()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_factor_direccional_fd", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFactorDireccionalFd()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_factor_distribucion_carril_fdc", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getFactorDistribucionCarrilFdc()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_analisis_referencias", ((AforoOE)OE).getAforo().getAnalisisReferencias(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_analisis_observaciones", ((AforoOE)OE).getAforo().getAnalisisObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_analisis_nee_8_2", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAnalisisNee82()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_anios_8_2", ((AforoOE)OE).getAforo().getAnios82(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_analisis2_nee_8_2", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAnalisis2Nee82()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_anios2_8_2", ((AforoOE)OE).getAforo().getAnios282(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		
    		parametros.add(new SentenciaParametroDAO("p_analisis_tpd_v_comerciales_3_5", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAnalisisTpdVComerciales35()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_anios_3_5", ((AforoOE)OE).getAforo().getAnios35(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
			
    		parametros.add(new SentenciaParametroDAO("p_t_automoviles", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getAutomoviles()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_buses_van", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getBusesVan()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_buses_buseta", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getBusesBuseta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_buses_sitp_alimentadores", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getBusesSitpAlimentadores()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_t_camiones_c2p", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC2p()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_camiones_c2g", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC2g()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_camiones_c3_c4", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC3C4()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_camiones_c5_c5", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getCamionesC5C5()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_t_vc_acumulados", convertirBigDecimalaDouble(((AforoOE)OE).getAforo().getVcAcumulados()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_id_documento_pdf", ((AforoOE)OE).getAforo().getIdDocumentoPdf(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));			

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
    		parametros.add(new SentenciaParametroDAO("p_id_aforo", ((AforoOE)OE).getAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		

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
	
	public ObjetoSalida calcularAnalisisTransito(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO("pkg_cargue_archivos.prc_analisis_aforo", OE.getUsuario());
            
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    		parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		

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

}
