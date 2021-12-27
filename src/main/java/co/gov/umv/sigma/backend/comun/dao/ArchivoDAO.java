package co.gov.umv.sigma.backend.comun.dao;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ArchivoOE;
import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import oracle.jdbc.OracleTypes;

public class ArchivoDAO extends GenericoDAO {
	private final static String PACKAGE = "pkg_archivo";
	
	public ObjetoSalida insertar(ArchivoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_nombre", OE.getArchivo().getNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_documento", OE.getArchivo().getIdDocumento().getIdDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_url_archivo", OE.getArchivo().getUrlArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	
	public ObjetoSalida actualizar(ArchivoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            System.out.println(OE.getArchivo().getIdArchivo());
            parametros.add(new SentenciaParametroDAO("p_id_archivo", OE.getArchivo().getIdArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_nombre", OE.getArchivo().getNombre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_documento", OE.getArchivo().getIdDocumento().getIdDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_url_archivo", OE.getArchivo().getUrlArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	public ObjetoSalida eliminar(ArchivoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_archivo", OE.getArchivo().getIdArchivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	
	public ObjetoSalida consultarXFiltro(ArchivoOE OE) {
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
