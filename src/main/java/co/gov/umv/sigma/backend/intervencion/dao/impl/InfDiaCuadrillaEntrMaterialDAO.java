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

public class InfDiaCuadrillaEntrMaterialDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_infdiacua_entr_material";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_infdiacua_entr_material   IN   tab_infdiacua_entr_material.id_infdiacua_entr_material%TYPE,
        p_id_informe_diario_cuadrilla  IN   tab_infdiacua_entr_material.id_informe_diario_cuadrilla%TYPE,
        p_id_tipo_material             IN   tab_infdiacua_entr_material.id_tipo_material%TYPE,
        p_id_tipo_clase_material       IN   tab_infdiacua_entr_material.id_tipo_clase_material%TYPE,
        p_placa                        IN   tab_infdiacua_entr_material.placa%TYPE,
        p_movil                        IN   tab_infdiacua_entr_material.movil%TYPE,
        p_volumen                      IN   tab_infdiacua_entr_material.volumen%TYPE,
        p_numero_recibo                IN   tab_infdiacua_entr_material.numero_recibo%TYPE,
        p_id_archivo_recibo            IN   tab_infdiacua_entr_material.id_archivo_recibo%TYPE,
        p_hora_entrada                 IN   tab_infdiacua_entr_material.hora_entrada%TYPE,
        p_hora_salida                  IN   tab_infdiacua_entr_material.hora_salida%TYPE,
        p_actividad_observacion        IN   tab_infdiacua_entr_material.actividad_observacion%TYPE,
        p_observaciones                IN   tab_infdiacua_entr_material.observaciones%TYPE,
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdTipoClaseMaterial() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_placa",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_movil",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_volumen",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getVolumen()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_recibo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getNumeroRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdArchivoRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora_entrada", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getHoraEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_salida", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getHoraSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_actividad_observacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getActividadObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));	        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_entr_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdInfdiacuaEntrMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdTipoClaseMaterial() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clase_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdTipoClaseMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_placa",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_movil",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_volumen",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getVolumen()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_recibo",((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getNumeroRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_recibo", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdArchivoRecibo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora_entrada", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getHoraEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_salida", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getHoraSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_actividad_observacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getActividadObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));	        
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_entr_material", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaEntrMaterial().getIdInfdiacuaEntrMaterial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
}
