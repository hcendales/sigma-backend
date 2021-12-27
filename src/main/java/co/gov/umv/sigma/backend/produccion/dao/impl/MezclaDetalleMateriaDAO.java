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

public class MezclaDetalleMateriaDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_MEZCLA_FORMULA_MATERIA";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_mezcla_formula", ((ProduccionOE)OE).getMezclaFormulaMateria().getIdMezclaFormula(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_materia", ((ProduccionOE)OE).getMezclaFormulaMateria().getIdTipoMateria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_masa_unitaria", ((ProduccionOE)OE).getMezclaFormulaMateria().getMasaUnitaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_formula_trabajo", ((ProduccionOE)OE).getMezclaFormulaMateria().getFormulaTrabajo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_porcentaje", ((ProduccionOE)OE).getMezclaFormulaMateria().getPorcentaje(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad", ((ProduccionOE)OE).getMezclaFormulaMateria().getCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_volumen", ((ProduccionOE)OE).getMezclaFormulaMateria().getVolumen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_costo_unitario", ((ProduccionOE)OE).getMezclaFormulaMateria().getCostoUnitario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_signo", ((ProduccionOE)OE).getMezclaFormulaMateria().getSigno(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_inicial", obtenerFecha( ((ProduccionOE)OE).getMezclaFormulaMateria().getFechaInicial()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_final",   obtenerFecha( ((ProduccionOE)OE).getMezclaFormulaMateria().getFechaFinal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_mezcla_formula_materia", ((ProduccionOE)OE).getMezclaFormulaMateria().getIdMezclaFormulaMateria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mezcla_formula", ((ProduccionOE)OE).getMezclaFormulaMateria().getIdMezclaFormula(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_materia", ((ProduccionOE)OE).getMezclaFormulaMateria().getIdTipoMateria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_masa_unitaria", ((ProduccionOE)OE).getMezclaFormulaMateria().getMasaUnitaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_formula_trabajo", ((ProduccionOE)OE).getMezclaFormulaMateria().getFormulaTrabajo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_porcentaje", ((ProduccionOE)OE).getMezclaFormulaMateria().getPorcentaje(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad", ((ProduccionOE)OE).getMezclaFormulaMateria().getCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_volumen", ((ProduccionOE)OE).getMezclaFormulaMateria().getVolumen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_costo_unitario", ((ProduccionOE)OE).getMezclaFormulaMateria().getCostoUnitario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_signo", ((ProduccionOE)OE).getMezclaFormulaMateria().getSigno(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_inicial", obtenerFecha( ((ProduccionOE)OE).getMezclaFormulaMateria().getFechaInicial()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_final",   obtenerFecha( ((ProduccionOE)OE).getMezclaFormulaMateria().getFechaFinal()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
			
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_mezcla_formula_materia", ((ProduccionOE)OE).getMezclaFormulaMateria().getIdMezclaFormulaMateria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
				
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	
	
}
