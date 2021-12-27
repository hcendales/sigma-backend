package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialDAO;
import oracle.jdbc.OracleTypes;

public class MantenimientoVialDAO extends GenericoDAO implements IMantenimientoVialDAO {
	
	private final static String PACKAGE = "pkg_mantenimiento_vial"; 
	@Override
	public ObjetoSalida insertar(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", OE.getMantenimientovial().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha", obtenerFecha(OE.getMantenimientovial().getFecha()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_solicitud_nombre", OE.getMantenimientovial().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_fecha", obtenerFecha(OE.getMantenimientovial().getFecha()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_solicitud_vencimiento", obtenerFecha(OE.getMantenimientovial().getSolicitudVencimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_solicitud_radicado_entrada", OE.getMantenimientovial().getSolicitudRadicadoEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_direccion", OE.getMantenimientovial().getSolicitudDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_radicado_salida", OE.getMantenimientovial().getSolicitudRadicadoSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_fecha_salida", obtenerFecha(OE.getMantenimientovial().getSolicitudFechaSalida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Long pkidcalzada = (OE.getMantenimientovial().getPkIdCalzada() == null) ? null : OE.getMantenimientovial().getPkIdCalzada().longValue();
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", pkidcalzada , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getMantenimientovial().getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getMantenimientovial().getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upla", OE.getMantenimientovial().getIdUpla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getMantenimientovial().getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_cuadrante", OE.getMantenimientovial().getIdCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upz", OE.getMantenimientovial().getIdUpz(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_ancho_pk", OE.getMantenimientovial().getAnchoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_area_pk", OE.getMantenimientovial().getAreaPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_longitud_horizontal_pk", OE.getMantenimientovial().getLongitudHorizontalPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pk", OE.getMantenimientovial().getIdTipoEstadoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            parametros.add(new SentenciaParametroDAO("p_id_tipo_uso_via", OE.getMantenimientovial().getIdTipoUsoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_malla", OE.getMantenimientovial().getIdTipoMalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_civ", OE.getMantenimientovial().getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_eje_vial", OE.getMantenimientovial().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_desde", OE.getMantenimientovial().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_hasta", OE.getMantenimientovial().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_entrada", OE.getMantenimientovial().getNumeroRadicadoEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_prog_visita", OE.getMantenimientovial().getIdTipoEstadoProgVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_visita_tecnica", obtenerFecha(OE.getMantenimientovial().getFechaVisitaTecnica()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_persona_responsable_visita", OE.getMantenimientovial().getIdPersonaResponsableVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            parametros.add(new SentenciaParametroDAO("p_rutas_transporte", OE.getMantenimientovial().getRutasTransporte(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_transitabilidad", OE.getMantenimientovial().getIdTipoTransitabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_impacto_social", OE.getMantenimientovial().getIdTipoImpactoSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_determinacion_interv", OE.getMantenimientovial().getIdTipoDeterminacionInterv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_coordinacion_interinst", OE.getMantenimientovial().getIdTipoCoordinacionInterinst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_aporte_metas", OE.getMantenimientovial().getIdTipoAporteMetas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observaciones_diagnostico", OE.getMantenimientovial().getObservacionesDiagnostico(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_pci", OE.getMantenimientovial().getPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_calificacion_pci", OE.getMantenimientovial().getIdTipoCalificacionPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_salida", OE.getMantenimientovial().getNumeroRadicadoSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

            parametros.add(new SentenciaParametroDAO("p_numero_radicado_intervencion", OE.getMantenimientovial().getNumeroRadicadoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_zona_eab_esp", OE.getMantenimientovial().getIdZonaEabEsp(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_seccion_vial", OE.getMantenimientovial().getIdTipoSeccionVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_km_carril_impacto", OE.getMantenimientovial().getKmCarrilImpacto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_programa", OE.getMantenimientovial().getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estrategia", OE.getMantenimientovial().getIdTipoEstrategia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad", OE.getMantenimientovial().getIdTipoActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            Float indicePriorizacion =  (OE.getMantenimientovial().getIndicePriorizacion() ==  null) ? null : OE.getMantenimientovial().getIndicePriorizacion().floatValue();
            parametros.add(new SentenciaParametroDAO("p_indice_priorizacion", indicePriorizacion, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_intervencion", obtenerFecha(OE.getMantenimientovial().getFechaRadicadoIntervencion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Float intervencionLongitud = (OE.getMantenimientovial().getIntervencionLongitud() == null) ? null : OE.getMantenimientovial().getIntervencionLongitud().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_longitud", intervencionLongitud, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionAncho = (OE.getMantenimientovial().getIntervencionAncho() == null ) ? null : OE.getMantenimientovial().getIntervencionAncho().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_ancho", intervencionAncho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionArea = (OE.getMantenimientovial().getIntervencionArea() ==  null) ? null : OE.getMantenimientovial().getIntervencionArea().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_area", intervencionArea, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionKmCarril = (OE.getMantenimientovial().getIntervencionKmCarril() == null) ? null : OE.getMantenimientovial().getIntervencionKmCarril().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_intervencion_km_carril",intervencionKmCarril, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_intervencion_tipo", OE.getMantenimientovial().getIntervencionTipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_intervencion_respuesta_idu", OE.getMantenimientovial().getIntervencionRespuestaIdu(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_intervencion_placa_referencia", OE.getMantenimientovial().getIntervencionPlacaReferencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_intervencion_fecha_ejecucion", obtenerFecha(OE.getMantenimientovial().getIntervencionFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_posible_danio_redes", OE.getMantenimientovial().getPosibleDanioRedes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_ejecucion", OE.getMantenimientovial().getIdTipoEjecucion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_clase", OE.getMantenimientovial().getIdTipoClase(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            parametros.add(new SentenciaParametroDAO("p_fecha_terminacion", obtenerFecha(OE.getMantenimientovial().getFechaTerminacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_seguimiento", obtenerFecha(OE.getMantenimientovial().getFechaSeguimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_visita_verificacion", obtenerFecha(OE.getMantenimientovial().getFechaVisitaTecnica()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_persona_responsable_verif", OE.getMantenimientovial().getIdPersonaResponsableVerif(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_director_obra", OE.getMantenimientovial().getIdPersonaDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_social", OE.getMantenimientovial().getIdPersonaResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_sst", OE.getMantenimientovial().getIdPersonaResidenteSst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_ambiental", OE.getMantenimientovial().getIdPersonaResidenteAmbiental(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observaciones_intervencion", OE.getMantenimientovial().getObservacionesIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_requiere_actualizacion_diag", OE.getMantenimientovial().getRequiereActualizacionDiag(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

            parametros.add(new SentenciaParametroDAO("p_id_tipo_pmt", OE.getMantenimientovial().getIdTipoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_coi", OE.getMantenimientovial().getCoi(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pmt", OE.getMantenimientovial().getIdTipoEstadoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_pmt", OE.getMantenimientovial().getNumeroRadicadoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_pmt", obtenerFecha(OE.getMantenimientovial().getFechaRadicadoPmt()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", OE.getMantenimientovial().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_obra", OE.getMantenimientovial().getIdPersonaResidenteObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_sol_reserva", OE.getMantenimientovial().getNumeroRadicadoSolReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_res_reserva", OE.getMantenimientovial().getNumeroRadicadoResReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_en_seguimiento", OE.getMantenimientovial().getEnSeguimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_rutas_transporte", OE.getMantenimientovial().getIdTipoRutasTransporte(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getMantenimientovial().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_via", OE.getMantenimientovial().getIdTipoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_administracion", OE.getMantenimientovial().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_requerimiento", OE.getMantenimientovial().getIdTipoRequerimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_grupo", OE.getMantenimientovial().getIdTipoGrupo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_priorizacion_trimestre", OE.getMantenimientovial().getPriorizacionTrimestre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_observaciones_priorizacion", OE.getMantenimientovial().getObservacionesPriorizacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_total", OE.getMantenimientovial().getIdTipoIntervencionTotal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionHuecos = (OE.getMantenimientovial().getIntervencionHuecos() == null) ? null : OE.getMantenimientovial().getIntervencionHuecos().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_huecos", intervencionHuecos, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDpmr = (OE.getMantenimientovial().getPuntajeDpmr() == null) ? null : OE.getMantenimientovial().getPuntajeDpmr().floatValue(); 
            parametros.add(new SentenciaParametroDAO("p_puntaje_dpmr", puntajeDpmr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            Float puntajeDpg = (OE.getMantenimientovial().getPuntajeDpg() == null) ? null : OE.getMantenimientovial().getPuntajeDpg().floatValue(); 
            parametros.add(new SentenciaParametroDAO("p_puntaje_dpg", puntajeDpg, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajePeticion = (OE.getMantenimientovial().getPuntajePeticion() == null) ? null : OE.getMantenimientovial().getPuntajePeticion().floatValue();             
            parametros.add(new SentenciaParametroDAO("p_puntaje_peticion", puntajePeticion, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeSitioSocial = (OE.getMantenimientovial().getPuntajeSitioSocial() == null) ? null : OE.getMantenimientovial().getPuntajeSitioSocial().floatValue();             
            parametros.add(new SentenciaParametroDAO("p_puntaje_sitio_social", puntajeSitioSocial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeUsoSocial = (OE.getMantenimientovial().getPuntajeUsoSocial() == null) ? null : OE.getMantenimientovial().getPuntajeUsoSocial().floatValue();             
            parametros.add(new SentenciaParametroDAO("p_puntaje_uso_social", puntajeUsoSocial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDimenSocial = (OE.getMantenimientovial().getPuntajeDimenSocial() == null) ? null : OE.getMantenimientovial().getPuntajeDimenSocial().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_dimen_social", puntajeDimenSocial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeUsoEconomico = (OE.getMantenimientovial().getPuntajeUsoEconomico() == null) ? null : OE.getMantenimientovial().getPuntajeUsoEconomico().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_uso_economico", puntajeUsoEconomico, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeSitioEconom = (OE.getMantenimientovial().getPuntajeSitioEconom() == null) ? null : OE.getMantenimientovial().getPuntajeSitioEconom().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_sitio_econom", puntajeSitioEconom, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDimenEconom = (OE.getMantenimientovial().getPuntajeDimenEconom() == null) ? null : OE.getMantenimientovial().getPuntajeDimenEconom().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_dimen_econom", puntajeDimenEconom, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeMalla = (OE.getMantenimientovial().getPuntajeMalla() == null) ? null : OE.getMantenimientovial().getPuntajeMalla().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_malla", puntajeMalla, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeRutas = (OE.getMantenimientovial().getPuntajeRutas() == null) ? null : OE.getMantenimientovial().getPuntajeRutas().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_rutas", puntajeRutas, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            Float puntajeSiniest = (OE.getMantenimientovial().getPuntajeSiniest() == null) ? null : OE.getMantenimientovial().getPuntajeSiniest().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_siniest", puntajeSiniest, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDimenTecnica = (OE.getMantenimientovial().getPuntajeDimenTecnica() == null) ? null : OE.getMantenimientovial().getPuntajeDimenTecnica().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_dimen_tecnica", puntajeDimenTecnica, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeIp = (OE.getMantenimientovial().getPuntajeIp() == null) ? null : OE.getMantenimientovial().getPuntajeIp().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_ip", puntajeIp, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_rangos_ip", OE.getMantenimientovial().getRangosIp(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Float ipRelativo = (OE.getMantenimientovial().getIpRelativo() == null) ? null : OE.getMantenimientovial().getIpRelativo().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_ip_relativo", ipRelativo, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeIpMax = (OE.getMantenimientovial().getPuntajeRutas() == null) ? null : OE.getMantenimientovial().getPuntajeRutas().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_ip_max", puntajeIpMax, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizar(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientovial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", OE.getMantenimientovial().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha", obtenerFecha(OE.getMantenimientovial().getFecha()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_solicitud_nombre", OE.getMantenimientovial().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_fecha", obtenerFecha(OE.getMantenimientovial().getFecha()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_solicitud_vencimiento", obtenerFecha(OE.getMantenimientovial().getSolicitudVencimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_solicitud_radicado_entrada", OE.getMantenimientovial().getSolicitudRadicadoEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_direccion", OE.getMantenimientovial().getSolicitudDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_radicado_salida", OE.getMantenimientovial().getSolicitudRadicadoSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_fecha_salida", obtenerFecha(OE.getMantenimientovial().getSolicitudFechaSalida()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Long pkidcalzada = (OE.getMantenimientovial().getPkIdCalzada() == null) ? null : OE.getMantenimientovial().getPkIdCalzada().longValue();
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", pkidcalzada , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getMantenimientovial().getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getMantenimientovial().getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upla", OE.getMantenimientovial().getIdUpla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getMantenimientovial().getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_cuadrante", OE.getMantenimientovial().getIdCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upz", OE.getMantenimientovial().getIdUpz(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_ancho_pk", OE.getMantenimientovial().getAnchoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_area_pk", OE.getMantenimientovial().getAreaPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_longitud_horizontal_pk", OE.getMantenimientovial().getLongitudHorizontalPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pk", OE.getMantenimientovial().getIdTipoEstadoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            parametros.add(new SentenciaParametroDAO("p_id_tipo_uso_via", OE.getMantenimientovial().getIdTipoUsoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_malla", OE.getMantenimientovial().getIdTipoMalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_civ", OE.getMantenimientovial().getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_eje_vial", OE.getMantenimientovial().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_desde", OE.getMantenimientovial().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_hasta", OE.getMantenimientovial().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_entrada", OE.getMantenimientovial().getNumeroRadicadoEntrada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_prog_visita", OE.getMantenimientovial().getIdTipoEstadoProgVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_visita_tecnica", obtenerFecha(OE.getMantenimientovial().getFechaVisitaTecnica()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_persona_responsable_visita", OE.getMantenimientovial().getIdPersonaResponsableVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

            parametros.add(new SentenciaParametroDAO("p_rutas_transporte", OE.getMantenimientovial().getRutasTransporte(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_transitabilidad", OE.getMantenimientovial().getIdTipoTransitabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_impacto_social", OE.getMantenimientovial().getIdTipoImpactoSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_determinacion_interv", OE.getMantenimientovial().getIdTipoDeterminacionInterv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_coordinacion_interinst", OE.getMantenimientovial().getIdTipoCoordinacionInterinst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_aporte_metas", OE.getMantenimientovial().getIdTipoAporteMetas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observaciones_diagnostico", OE.getMantenimientovial().getObservacionesDiagnostico(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_pci", OE.getMantenimientovial().getPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_calificacion_pci", OE.getMantenimientovial().getIdTipoCalificacionPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_salida", OE.getMantenimientovial().getNumeroRadicadoSalida(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

            parametros.add(new SentenciaParametroDAO("p_numero_radicado_intervencion", OE.getMantenimientovial().getNumeroRadicadoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_zona_eab_esp", OE.getMantenimientovial().getIdZonaEabEsp(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_seccion_vial", OE.getMantenimientovial().getIdTipoSeccionVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_km_carril_impacto", OE.getMantenimientovial().getKmCarrilImpacto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_programa", OE.getMantenimientovial().getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estrategia", OE.getMantenimientovial().getIdTipoEstrategia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad", OE.getMantenimientovial().getIdTipoActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            Float indicePriorizacion =  (OE.getMantenimientovial().getIndicePriorizacion() ==  null) ? null : OE.getMantenimientovial().getIndicePriorizacion().floatValue();
            parametros.add(new SentenciaParametroDAO("p_indice_priorizacion", indicePriorizacion, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_intervencion", obtenerFecha(OE.getMantenimientovial().getFecha()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Float intervencionLongitud = (OE.getMantenimientovial().getIntervencionLongitud() == null) ? null : OE.getMantenimientovial().getIntervencionLongitud().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_longitud", intervencionLongitud, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionAncho = (OE.getMantenimientovial().getIntervencionAncho() == null ) ? null : OE.getMantenimientovial().getIntervencionAncho().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_ancho", intervencionAncho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionArea = (OE.getMantenimientovial().getIntervencionArea() ==  null) ? null : OE.getMantenimientovial().getIntervencionArea().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_area", intervencionArea, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionKmCarril = (OE.getMantenimientovial().getIntervencionKmCarril() == null) ? null : OE.getMantenimientovial().getIntervencionKmCarril().floatValue() ;
            parametros.add(new SentenciaParametroDAO("p_intervencion_km_carril",intervencionKmCarril, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_intervencion_tipo", OE.getMantenimientovial().getIntervencionTipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_intervencion_respuesta_idu", OE.getMantenimientovial().getIntervencionRespuestaIdu(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_intervencion_placa_referencia", OE.getMantenimientovial().getIntervencionPlacaReferencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_intervencion_fecha_ejecucion", obtenerFecha(OE.getMantenimientovial().getIntervencionFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_posible_danio_redes", OE.getMantenimientovial().getPosibleDanioRedes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_ejecucion", OE.getMantenimientovial().getIdTipoEjecucion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_clase", OE.getMantenimientovial().getIdTipoClase(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            parametros.add(new SentenciaParametroDAO("p_fecha_terminacion", obtenerFecha(OE.getMantenimientovial().getFechaTerminacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_seguimiento", obtenerFecha(OE.getMantenimientovial().getFechaSeguimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_visita_verificacion", obtenerFecha(OE.getMantenimientovial().getFechaVisitaTecnica()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_persona_responsable_verif", OE.getMantenimientovial().getIdPersonaResponsableVerif(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_director_obra", OE.getMantenimientovial().getIdPersonaDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_social", OE.getMantenimientovial().getIdPersonaResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_sst", OE.getMantenimientovial().getIdPersonaResidenteSst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_ambiental", OE.getMantenimientovial().getIdPersonaResidenteAmbiental(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observaciones_intervencion", OE.getMantenimientovial().getObservacionesIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_requiere_actualizacion_diag", OE.getMantenimientovial().getRequiereActualizacionDiag(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

            parametros.add(new SentenciaParametroDAO("p_id_tipo_pmt", OE.getMantenimientovial().getIdTipoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_coi", OE.getMantenimientovial().getCoi(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                        
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pmt", OE.getMantenimientovial().getIdTipoEstadoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_pmt", OE.getMantenimientovial().getNumeroRadicadoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_pmt", obtenerFecha(OE.getMantenimientovial().getFechaRadicadoPmt()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_programacion_periodica", OE.getMantenimientovial().getIdProgramacionPeriodica(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_obra", OE.getMantenimientovial().getIdPersonaResidenteObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_sol_reserva", OE.getMantenimientovial().getNumeroRadicadoSolReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_res_reserva", OE.getMantenimientovial().getNumeroRadicadoResReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_en_seguimiento", OE.getMantenimientovial().getEnSeguimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_rutas_transporte", OE.getMantenimientovial().getIdTipoRutasTransporte(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getMantenimientovial().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_via", OE.getMantenimientovial().getIdTipoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_administracion", OE.getMantenimientovial().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_requerimiento", OE.getMantenimientovial().getIdTipoRequerimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_grupo", OE.getMantenimientovial().getIdTipoGrupo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_priorizacion_trimestre", OE.getMantenimientovial().getPriorizacionTrimestre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_observaciones_priorizacion", OE.getMantenimientovial().getObservacionesPriorizacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_total", OE.getMantenimientovial().getIdTipoIntervencionTotal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float intervencionHuecos = (OE.getMantenimientovial().getIntervencionHuecos() == null) ? null : OE.getMantenimientovial().getIntervencionHuecos().floatValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_huecos", intervencionHuecos, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDpmr = (OE.getMantenimientovial().getPuntajeDpmr() == null) ? null : OE.getMantenimientovial().getPuntajeDpmr().floatValue(); 
            parametros.add(new SentenciaParametroDAO("p_puntaje_dpmr", puntajeDpmr, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            Float puntajeDpg = (OE.getMantenimientovial().getPuntajeDpg() == null) ? null : OE.getMantenimientovial().getPuntajeDpg().floatValue(); 
            parametros.add(new SentenciaParametroDAO("p_puntaje_dpg", puntajeDpg, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajePeticion = (OE.getMantenimientovial().getPuntajePeticion() == null) ? null : OE.getMantenimientovial().getPuntajePeticion().floatValue();             
            parametros.add(new SentenciaParametroDAO("p_puntaje_peticion", puntajePeticion, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeSitioSocial = (OE.getMantenimientovial().getPuntajeSitioSocial() == null) ? null : OE.getMantenimientovial().getPuntajeSitioSocial().floatValue();             
            parametros.add(new SentenciaParametroDAO("p_puntaje_sitio_social", puntajeSitioSocial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeUsoSocial = (OE.getMantenimientovial().getPuntajeUsoSocial() == null) ? null : OE.getMantenimientovial().getPuntajeUsoSocial().floatValue();             
            parametros.add(new SentenciaParametroDAO("p_puntaje_uso_social", puntajeUsoSocial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDimenSocial = (OE.getMantenimientovial().getPuntajeDimenSocial() == null) ? null : OE.getMantenimientovial().getPuntajeDimenSocial().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_dimen_social", puntajeDimenSocial, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeUsoEconomico = (OE.getMantenimientovial().getPuntajeUsoEconomico() == null) ? null : OE.getMantenimientovial().getPuntajeUsoEconomico().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_uso_economico", puntajeUsoEconomico, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeSitioEconom = (OE.getMantenimientovial().getPuntajeSitioEconom() == null) ? null : OE.getMantenimientovial().getPuntajeSitioEconom().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_sitio_econom", puntajeSitioEconom, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDimenEconom = (OE.getMantenimientovial().getPuntajeDimenEconom() == null) ? null : OE.getMantenimientovial().getPuntajeDimenEconom().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_dimen_econom", puntajeDimenEconom, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeMalla = (OE.getMantenimientovial().getPuntajeMalla() == null) ? null : OE.getMantenimientovial().getPuntajeMalla().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_malla", puntajeMalla, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeRutas = (OE.getMantenimientovial().getPuntajeRutas() == null) ? null : OE.getMantenimientovial().getPuntajeRutas().floatValue();
            parametros.add(new SentenciaParametroDAO("p_puntaje_rutas", puntajeRutas, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            Float puntajeSiniest = (OE.getMantenimientovial().getPuntajeSiniest() == null) ? null : OE.getMantenimientovial().getPuntajeSiniest().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_siniest", puntajeSiniest, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeDimenTecnica = (OE.getMantenimientovial().getPuntajeDimenTecnica() == null) ? null : OE.getMantenimientovial().getPuntajeDimenTecnica().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_dimen_tecnica", puntajeDimenTecnica, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeIp = (OE.getMantenimientovial().getPuntajeIp() == null) ? null : OE.getMantenimientovial().getPuntajeIp().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_ip", puntajeIp, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_rangos_ip", OE.getMantenimientovial().getRangosIp(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Float ipRelativo = (OE.getMantenimientovial().getIpRelativo() == null) ? null : OE.getMantenimientovial().getIpRelativo().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_ip_relativo", ipRelativo, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Float puntajeIpMax = (OE.getMantenimientovial().getPuntajeRutas() == null) ? null : OE.getMantenimientovial().getPuntajeRutas().floatValue();            
            parametros.add(new SentenciaParametroDAO("p_puntaje_ip_max", puntajeIpMax, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;	
    }

	@Override
	public ObjetoSalida eliminar(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientovial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarXFiltro(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consultarporfiltro", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_filtro", OE.getFiltro(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
                        
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida crearMantenimientoVial(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_GESTION.pr_crear_mantenimiento_vial", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
      
            Long pkidcalzada = (OE.getMantenimientovial().getPkIdCalzada() == null) ? null : OE.getMantenimientovial().getPkIdCalzada().longValue();
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", pkidcalzada , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", OE.getMantenimientovial().getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_usuario", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observacion", OE.getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitud_radicado", OE.getSolicitudRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_programa", OE.getMantenimientovial().getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estrategia", OE.getMantenimientovial().getIdTipoEstrategia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_administracion", OE.getMantenimientovial().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizarPCI(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_pci", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            /*p_id_mantenimiento_vial           IN   tab_mantenimiento_vial.id_mantenimiento_vial%TYPE,
        p_pci                             IN   tab_mantenimiento_vial.pci%TYPE,
        p_id_tipo_calificacion_pci        IN   tab_mantenimiento_vial.id_tipo_calificacion_pci%TYPE,
        */
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientovial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_pci", OE.getMantenimientovial().getPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_calificacion_pci", OE.getMantenimientovial().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizarCampo(MantenimientoVialOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_campo", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            /*p_id_mantenimiento_vial           IN   tab_mantenimiento_vial.id_mantenimiento_vial%TYPE,
        p_nombre_campo     IN   VARCHAR2,
        p_valor_campo     IN   VARCHAR2,
        */
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientovial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_nombre_campo", OE.getNombreCampo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_valor_campo", OE.getValorCampo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;	
        
	}

}
