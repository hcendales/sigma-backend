package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AlternativaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class CapaDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_DISENIO_CAPA";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_alternativa_disenio", ((AlternativaOE)OE).getCapa().getAlternativaDisenio().getIdAlternativaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_capa", ((AlternativaOE)OE).getCapa().getIdTipoCapa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_espesor", ((AlternativaOE)OE).getCapa().getEspesor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_disenio_capa", ((AlternativaOE)OE).getCapa().getIdDisenioCapa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_alternativa_disenio", ((AlternativaOE)OE).getCapa().getAlternativaDisenio().getIdAlternativaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_capa", ((AlternativaOE)OE).getCapa().getIdTipoCapa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_espesor", ((AlternativaOE)OE).getCapa().getEspesor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_disenio_capa", ((AlternativaOE)OE).getCapa().getIdDisenioCapa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}

