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

public class AforoDatoDAO extends GenericoDAO implements IAforoDAO {

	private final static String PACKAGE = "pkg_aforo_dato";

	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            /*
             *  p_id_aforo                  IN   tab_aforo_dato.id_aforo%TYPE,
        p_fecha_hora                IN   tab_aforo_dato.fecha_hora%TYPE,
        p_automoviles               IN   tab_aforo_dato.automoviles%TYPE,
        p_buses_van                 IN   tab_aforo_dato.buses_van%TYPE,
        p_buses_buseta              IN   tab_aforo_dato.buses_buseta%TYPE,
        p_buses_sitp_alimentadores  IN   tab_aforo_dato.buses_sitp_alimentadores%TYPE,
        p_camiones_c2p              IN   tab_aforo_dato.camiones_c2p%TYPE,
        p_camiones_c2g              IN   tab_aforo_dato.camiones_c2g%TYPE,
        p_camiones_c3_c4            IN   tab_aforo_dato.camiones_c3_c4%TYPE,
        p_camiones_c5_c5            IN   tab_aforo_dato.camiones_c5_c5%TYPE,
        p_tpd_parcial               IN   tab_aforo_dato.tpd_parcial%TYPE,
             * */
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    		parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforodato().getIdAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_fecha_hora", OE.getAforodato().getFechaHora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_automoviles", OE.getAforodato().getAutomoviles(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_buses_van", OE.getAforodato().getBusesVan(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_buses_buseta", OE.getAforodato().getBusesBuseta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_buses_sitp_alimentadores", OE.getAforodato().getBusesSitpAlimentadores(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_camiones_c2p", OE.getAforodato().getCamionesC2p(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_camiones_c2g", OE.getAforodato().getCamionesC2g(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_camiones_c3_c4", OE.getAforodato().getCamionesC3C4(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_camiones_c5_c5", OE.getAforodato().getCamionesC5C5(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_tpd_parcial", OE.getAforodato().getTpdParcial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		
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
    		parametros.add(new SentenciaParametroDAO("p_id_aforo_dato", ((AforoOE)OE).getAforodato().getIdAforoDato(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_id_aforo", OE.getAforodato().getIdAforo().getIdAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_fecha_hora", OE.getAforodato().getFechaHora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		parametros.add(new SentenciaParametroDAO("p_automoviles", OE.getAforodato().getAutomoviles(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_buses_van", OE.getAforodato().getBusesVan(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_buses_buseta", OE.getAforodato().getBusesBuseta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_buses_sitp_alimentadores", OE.getAforodato().getBusesSitpAlimentadores(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_camiones_c2p", OE.getAforodato().getCamionesC2p(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_camiones_c2g", OE.getAforodato().getCamionesC2g(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		parametros.add(new SentenciaParametroDAO("p_camiones_c3_c4", OE.getAforodato().getCamionesC3C4(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_camiones_c5_c5", OE.getAforodato().getCamionesC5C5(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		parametros.add(new SentenciaParametroDAO("p_tpd_parcial", OE.getAforodato().getTpdParcial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		
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
    		parametros.add(new SentenciaParametroDAO("p_id_aforo_dato", ((AforoOE)OE).getAforodato().getIdAforoDato(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
    		
    		
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
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consultarporfiltro", OE.getUsuario());
            
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    		parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
    		
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
