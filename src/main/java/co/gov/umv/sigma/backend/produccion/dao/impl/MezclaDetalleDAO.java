package co.gov.umv.sigma.backend.produccion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import co.gov.umv.sigma.backend.produccion.cbo.ProduccionOE;
import oracle.jdbc.OracleTypes;

public class MezclaDetalleDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_MEZCLA_FORMULA";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_mezcla", ((ProduccionOE)OE).getMezclaFormula().getIdTipoMezcla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_especificacion", ((ProduccionOE)OE).getMezclaFormula().getEspecificacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_inicial", obtenerFecha( ((ProduccionOE)OE).getMezclaFormula().getFechaInicial()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_final",   obtenerFecha( ((ProduccionOE)OE).getMezclaFormula().getFechaFinal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_masa_unitaria", ((ProduccionOE)OE).getMezclaFormula().getMasaUnitaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_unidad_medida", ((ProduccionOE)OE).getMezclaFormula().getUnidadMedida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_costo_unitario", ((ProduccionOE)OE).getMezclaFormula().getCostoUnitario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_mezcla_formula", ((ProduccionOE)OE).getMezclaFormula().getIdMezclaFormula(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_mezcla", ((ProduccionOE)OE).getMezclaFormula().getIdTipoMezcla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_especificacion", ((ProduccionOE)OE).getMezclaFormula().getEspecificacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_inicial", obtenerFecha( ((ProduccionOE)OE).getMezclaFormula().getFechaInicial()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_final",   obtenerFecha( ((ProduccionOE)OE).getMezclaFormula().getFechaFinal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_masa_unitaria", ((ProduccionOE)OE).getMezclaFormula().getMasaUnitaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_unidad_medida", ((ProduccionOE)OE).getMezclaFormula().getUnidadMedida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_costo_unitario", ((ProduccionOE)OE).getMezclaFormula().getCostoUnitario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_mezcla_formula", ((ProduccionOE)OE).getMezclaFormula().getIdMezclaFormula(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
				
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	
	
}
