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

public class InfDiaCuadrillaObservacionDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_infdiacua_observacion";
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*
		 * pkg_informe_diario_cuadrilla
		 * p_id_informe_diario_cuadrilla    IN   tab_informe_diario_cuadrilla.id_informe_diario_cuadrilla%TYPE,
        p_id_mantenimiento_vial          IN   tab_informe_diario_cuadrilla.id_mantenimiento_vial%TYPE,
        p_fecha                          IN   tab_informe_diario_cuadrilla.fecha%TYPE,
        p_id_tipo_jornada                IN   tab_informe_diario_cuadrilla.id_tipo_jornada%TYPE,
        p_porcentaje_avance_diario_obra  IN   tab_informe_diario_cuadrilla.porcentaje_avance_diario_obra%TYPE,
        p_porcentaje_avance_acum_obra    IN   tab_informe_diario_cuadrilla.porcentaje_avance_acum_obra%TYPE,
        p_area_total_intervenida         IN   tab_informe_diario_cuadrilla.area_total_intervenida%TYPE,
        p_longitud_total_intervenida     IN   tab_informe_diario_cuadrilla.longitud_total_intervenida%TYPE,
        p_id_tipo_clima_manana           IN   tab_informe_diario_cuadrilla.id_tipo_clima_manana%TYPE,
        p_id_tipo_clima_tarde            IN   tab_informe_diario_cuadrilla.id_tipo_clima_tarde%TYPE,
        p_id_tipo_clima_noche            IN   tab_informe_diario_cuadrilla.id_tipo_clima_noche%TYPE,
        p_hora_inicio_actividades        IN   tab_informe_diario_cuadrilla.hora_inicio_actividades%TYPE,
        p_horario_fin_actividades        IN   tab_informe_diario_cuadrilla.horario_fin_actividades%TYPE,
        p_servicio_vigilancia            IN   tab_informe_diario_cuadrilla.servicio_vigilancia%TYPE,
        p_servicio_vigilancia_horas      IN   tab_informe_diario_cuadrilla.servicio_vigilancia_horas%TYPE,
        p_servicio_banio                 IN   tab_informe_diario_cuadrilla.servicio_banio%TYPE,
        p_servicio_banio_horas           IN   tab_informe_diario_cuadrilla.servicio_banio_horas%TYPE,
        p_cantidad_seniales              IN   tab_informe_diario_cuadrilla.cantidad_seniales%TYPE,
        p_cantidad_delineadores          IN   tab_informe_diario_cuadrilla.cantidad_delineadores%TYPE,
        p_id_archivo_esquema             IN   tab_informe_diario_cuadrilla.id_archivo_esquema%TYPE,
        p_id_tipo_estado_obra            IN   tab_informe_diario_cuadrilla.id_tipo_estado_obra%TYPE,
        p_id_tipo_estado_informe         IN   tab_informe_diario_cuadrilla.id_tipo_estado_informe%TYPE,
        p_id_persona_elabora             IN   tab_informe_diario_cuadrilla.id_persona_elabora%TYPE,
        p_id_persona_revisa              IN   tab_informe_diario_cuadrilla.id_persona_revisa%TYPE,
        p_id_persona_aprueba             IN   tab_informe_diario_cuadrilla.id_persona_aprueba%TYPE,
        p_observaciones                  IN   tab_informe_diario_cuadrilla.observaciones%TYPE,
        p_actividad_dia_siguiente        IN   tab_informe_diario_cuadrilla.actividad_dia_siguiente%TYPE,
        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaObservacion().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaObservacion().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
			        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_infdiacua_observacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaObservacion().getIdInfdiacuaObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaObservacion().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaObservacion().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_infdiacua_observacion", ((InformacionDiariaCuadrillaOE)OE).getInfDiacuaObservacion().getIdInfdiacuaObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
}
