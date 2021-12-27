package co.gov.umv.sigma.backend.produccion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import oracle.jdbc.OracleTypes;

public class TipoServicioEnsayoDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_TIPO_SERVICIO_ENSAYO";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_servicio", ((LaboratorioOE)OE).getTipoServicioEnsayo().getIdTipoServicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_ensayo", ((LaboratorioOE)OE).getTipoServicioEnsayo().getIdTipoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_tipo_servicio_ensayo", ((LaboratorioOE)OE).getTipoServicioEnsayo().getIdTipoServicioEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_servicio", ((LaboratorioOE)OE).getTipoServicioEnsayo().getIdTipoServicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_ensayo", ((LaboratorioOE)OE).getTipoServicioEnsayo().getIdTipoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_servicio_ensayo", ((LaboratorioOE)OE).getTipoServicioEnsayo().getIdTipoServicioEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}


	

}
