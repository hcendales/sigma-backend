package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AledanioOE;
import oracle.jdbc.OracleTypes;

public class ApiquesAledanioDAO extends CrudDAO {
	
	private final static String PACKAGE = "PKG_APIQUES";

	public ObjetoSalida registrarAledanio(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada_aledanio", ((AledanioOE)OE).getAledanio().getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mv_evento", ((AledanioOE)OE).getAledanio().getIdMvEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	
		
		return ejecutar(OE, PACKAGE+".pr_registrar_aledanio", parametros);	
	}

}
