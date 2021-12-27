package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AledanioOE;

public class AledanioDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_PREDISENIO_ALEDANIO";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((AledanioOE)OE).getAledanio().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada_aledanio", ((AledanioOE)OE).getAledanio().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mv_evento_aledanio", ((AledanioOE)OE).getAledanio().getIdMvEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_predisenio_aledanio", ((AledanioOE)OE).getAledanio().getIdPredisenioAledanio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((AledanioOE)OE).getAledanio().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada_aledanio", ((AledanioOE)OE).getAledanio().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mv_evento_aledanio", ((AledanioOE)OE).getAledanio().getIdMvEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_predisenio_aledanio", ((AledanioOE)OE).getAledanio().getIdPredisenioAledanio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}
