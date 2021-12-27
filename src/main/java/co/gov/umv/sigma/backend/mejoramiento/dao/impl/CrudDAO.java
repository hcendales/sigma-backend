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
import oracle.jdbc.OracleTypes;

public class CrudDAO extends GenericoDAO
{
	
	protected ObjetoSalida ejecutar(ObjetoEntrada OE, String procedimiento, List<SentenciaParametroDAO> parametros )
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(procedimiento, OE.getUsuario());
	        sentencia.setParametros(parametros);
	        objetoSalida = this.ejecutarX(sentencia, objetoSalida);
	      
	    } catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}
	
	
	protected ObjetoSalida consultaXFiltro(ObjetoEntrada OE, String procedimiento) 
	{ 
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try {
	        SentenciaDAO sentencia = new SentenciaDAO(procedimiento, OE.getUsuario());
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
