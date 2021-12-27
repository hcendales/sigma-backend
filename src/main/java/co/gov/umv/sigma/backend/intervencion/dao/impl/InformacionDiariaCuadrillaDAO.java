package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.InformacionDiariaCuadrillaOE;
import co.gov.umv.sigma.backend.intervencion.cbo.InformacionDiariaCuadrillaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class InformacionDiariaCuadrillaDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_informe_diario_cuadrilla";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		/*        
		 * 
		 * 
		 * */
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha", obtenerFecha(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getFecha()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_jornada", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoJornada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_porcentaje_avance_diario_obra",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getPorcentajeAvanceDiarioObra()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_porcentaje_avance_acum_obra",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getPorcentajeAvanceAcumObra()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_area_total_intervenida",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getAreaTotalIntervenida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_longitud_total_intervenida",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getLongitudTotalIntervenida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clima_manana", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoClimaManana(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clima_tarde", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoClimaTarde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clima_noche", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoClimaNoche(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_hora_inicio_actividades", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getHoraInicioActividades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_horario_fin_actividades", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getHorarioFinActividades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));		
		parametros.add(new SentenciaParametroDAO("p_servicio_vigilancia", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioVigilancia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_servicio_vigilancia_horas", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioVigilanciaHoras()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_servicio_banio", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioBanio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_servicio_banio_horas", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioBanioHoras(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_cantidad_seniales", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getCantidadSeniales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad_delineadores", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getCantidadDelineadores(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_esquema", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdArchivoEsquema(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_obra", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoEstadoObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_informe", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoEstadoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));				
		parametros.add(new SentenciaParametroDAO("p_id_persona_elabora", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdPersonaElabora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_revisa", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdPersonaRevisa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_aprueba", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdPersonaAprueba(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_actividad_dia_siguiente", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getActividadDiaSiguiente(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha", obtenerFecha( ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getFecha() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_jornada", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoJornada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_porcentaje_avance_diario_obra",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getPorcentajeAvanceDiarioObra()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_porcentaje_avance_acum_obra",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getPorcentajeAvanceAcumObra()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_area_total_intervenida",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getAreaTotalIntervenida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_longitud_total_intervenida",convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getLongitudTotalIntervenida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clima_manana", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoClimaManana(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clima_tarde", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoClimaTarde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_clima_noche", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoClimaNoche(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		parametros.add(new SentenciaParametroDAO("p_hora_inicio_actividades", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getHoraInicioActividades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_horario_fin_actividades", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getHorarioFinActividades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		parametros.add(new SentenciaParametroDAO("p_servicio_vigilancia", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioVigilancia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_servicio_vigilancia_horas", convertirBigDecimalaDouble(((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioVigilanciaHoras()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_servicio_banio", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioBanio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_servicio_banio_horas", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getServicioBanioHoras(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		parametros.add(new SentenciaParametroDAO("p_cantidad_seniales", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getCantidadSeniales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_cantidad_delineadores", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getCantidadDelineadores(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_esquema", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdArchivoEsquema(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_obra", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoEstadoObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_informe", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdTipoEstadoInforme(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));				

		parametros.add(new SentenciaParametroDAO("p_id_persona_elabora", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdPersonaElabora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_revisa", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdPersonaRevisa(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_aprueba", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdPersonaAprueba(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_actividad_dia_siguiente", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getActividadDiaSiguiente(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
        parametros.add(new SentenciaParametroDAO("p_id_informe_diario_cuadrilla", ((InformacionDiariaCuadrillaOE)OE).getInformeDiarioCuadrilla().getIdInformeDiarioCuadrilla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
}
