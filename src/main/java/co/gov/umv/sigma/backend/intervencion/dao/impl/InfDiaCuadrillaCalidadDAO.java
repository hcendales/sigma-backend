package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.InformacionDiariaCuadrillaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class InfDiaCuadrillaCalidadDAO extends CrudDAO implements ICrudDAO {
	
	private final static String PACKAGE = "pkg_infdiacua_calidad";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_infdiacua_calidad         IN   tab_infdiacua_calidad.id_infdiacua_calidad%TYPE,
        p_id_informe_diario_cuadrilla  IN   tab_infdiacua_calidad.id_informe_diario_cuadrilla%TYPE,
        p_numero_muestras_tomadas      IN   tab_infdiacua_calidad.numero_muestras_tomadas%TYPE,
        p_id_tipo_material             IN   tab_infdiacua_calidad.id_tipo_material%TYPE,
        p_id_tipo_ensayo               IN   tab_infdiacua_calidad.id_tipo_ensayo%TYPE,
        p_resultado_ensayo                    IN   tab_infdiacua_calidad.resultado%TYPE,
        
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_muestras_tomadas", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getNumeroMuestrasTomadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdTipoMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_ensayo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdTipoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_resultado_ensayo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getResultado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_calidad", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdInfdiacuaCalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_muestras_tomadas", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getNumeroMuestrasTomadas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdTipoMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_ensayo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdTipoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_resultado_ensayo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getResultado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_calidad", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaCalidad().getIdInfdiacuaCalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
}
