package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialEventoDAO;
import oracle.jdbc.OracleTypes;

public final class MantenimientoVialEventoDAO extends GenericoDAO implements IMantenimientoVialEventoDAO {
	private final static String PACKAGE = "pkg_mantenimiento_vial_evento";
	@Override
	public ObjetoSalida crearMantenimientoVialEvento(MantenimientoVialEventoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_GESTION.pr_crear_mantenimiento_vial_evento", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);

            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_evento", OE.getMantenimientoVialEvento().getEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida insertar(MantenimientoVialEventoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_insertar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);

            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientoVialEvento().getIdMantenimientoVial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_evento", OE.getMantenimientoVialEvento().getEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_creacion_evento", obtenerFecha(OE.getMantenimientoVialEvento().getFechaCreacionEvento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_visita", obtenerFecha(OE.getMantenimientoVialEvento().getFechaVisita()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Long idResponsableVisita = (OE.getMantenimientoVialEvento().getIdResponsableVisita() == null ) ? null : OE.getMantenimientoVialEvento().getIdResponsableVisita(); 
            parametros.add(new SentenciaParametroDAO("p_id_responsable_visita", idResponsableVisita, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long idDocumentoVisita = (OE.getMantenimientoVialEvento().getIdDocumentoVisita() == null ) ? null : OE.getMantenimientoVialEvento().getIdDocumentoVisita();
            parametros.add(new SentenciaParametroDAO("p_id_documento_visita", idDocumentoVisita, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observaciones",OE.getMantenimientoVialEvento().getObservaciones() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_ancho_pk", OE.getMantenimientoVialEvento().getAnchoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_area_pk", OE.getMantenimientoVialEvento().getAreaPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_longitud_horizontal_pk", OE.getMantenimientoVialEvento().getLongitudHorizontalPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_uso_via", OE.getMantenimientoVialEvento().getIdTipoUsoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_malla", OE.getMantenimientoVialEvento().getIdTipoMalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getMantenimientoVialEvento().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_eje_vial", OE.getMantenimientoVialEvento().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_desde", OE.getMantenimientoVialEvento().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_hasta", OE.getMantenimientoVialEvento().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_posible_danio_redes", OE.getMantenimientoVialEvento().getPosibleDanioRedes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_rutas_transporte", OE.getMantenimientoVialEvento().getRutasTransporte(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_transitabilidad", OE.getMantenimientoVialEvento().getIdTipoTransitabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_impacto_social", OE.getMantenimientoVialEvento().getIdTipoImpactoSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_determinacion_interv", OE.getMantenimientoVialEvento().getIdTipoDeterminacionInterv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_coordinacion_interinst", OE.getMantenimientoVialEvento().getIdTipoCoordinacionInterinst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_aporte_metas", OE.getMantenimientoVialEvento().getIdTipoAporteMetas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_pmt", OE.getMantenimientoVialEvento().getIdTipoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_pci", OE.getMantenimientoVialEvento().getPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_km_carril_impacto", OE.getMantenimientoVialEvento().getKmCarrilImpacto(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_km_carril_obra", OE.getMantenimientoVialEvento().getKmCarrilObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_km_carril", OE.getMantenimientoVialEvento().getKmCarril(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double kmLineal = (OE.getMantenimientoVialEvento().getKmLineal() == null) ? null : OE.getMantenimientoVialEvento().getKmLineal().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_km_lineal", kmLineal, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_requiere_aforo", OE.getMantenimientoVialEvento().getRequiereAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_requiere_apiques", OE.getMantenimientoVialEvento().getRequiereAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitudes_adicionales", OE.getMantenimientoVialEvento().getSolicitudesAdicionales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_observacion_adicionales", OE.getMantenimientoVialEvento().getSolicitudesAdicionales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_viable_intervencion", OE.getMantenimientoVialEvento().getViableIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_observacion_viable_intervencion", OE.getMantenimientoVialEvento().getObservacionViableIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_clasificacion_subrasant", OE.getMantenimientoVialEvento().getIdTipoClasificacionSubrasant(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie_disenio", OE.getMantenimientoVialEvento().getIdTipoSuperficieDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_final_disenio", OE.getMantenimientoVialEvento().getIdTipoIntervencionFinalDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_metodologia_disenio", OE.getMantenimientoVialEvento().getIdTipoMetodologiaDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_material_granular", OE.getMantenimientoVialEvento().getIdTipoMaterialGranular(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double espesor = (OE.getMantenimientoVialEvento().getEspesorDisenio() == null) ? null : OE.getMantenimientoVialEvento().getEspesorDisenio().doubleValue(); 
            parametros.add(new SentenciaParametroDAO("p_espesor_disenio", espesor,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double cbrinicialpct = ( OE.getMantenimientoVialEvento().getCbrInicialPct() == null) ? null : OE.getMantenimientoVialEvento().getCbrInicialPct().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_cbr_inicial_pct", cbrinicialpct,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double cbrdiseniopct = ( OE.getMantenimientoVialEvento().getCbrInicialPct() == null) ? null : OE.getMantenimientoVialEvento().getCbrInicialPct().doubleValue();            
            parametros.add(new SentenciaParametroDAO("p_cbr_disenio_pct", cbrdiseniopct,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));          
            Double ksdisenio = (OE.getMantenimientoVialEvento().getKsDisenio() == null) ? null : OE.getMantenimientoVialEvento().getKsDisenio().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_ks_disenio", OE.getMantenimientoVialEvento().getKsDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));               
            Double needisenio = (OE.getMantenimientoVialEvento().getNeeDisenio() == null) ? null : OE.getMantenimientoVialEvento().getNeeDisenio().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_nee_disenio", needisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));              
            Double tpdvcdisenio = (OE.getMantenimientoVialEvento().getTpdvcDisenio() == null ) ? null : OE.getMantenimientoVialEvento().getTpdvcDisenio().doubleValue();  
            parametros.add(new SentenciaParametroDAO("p_tpdvc_disenio", tpdvcdisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double numeroestructuralefectivodisenio = (OE.getMantenimientoVialEvento().getNumeroEstructuralEfectivoDisenio() == null ) ? null : OE.getMantenimientoVialEvento().getNumeroEstructuralEfectivoDisenio().doubleValue();              
    		parametros.add(new SentenciaParametroDAO("p_numero_estructural_efectivo_disenio", numeroestructuralefectivodisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_id_tipo_geosinteticos", OE.getMantenimientoVialEvento().getIdTipoGeosinteticos(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));              
			parametros.add(new SentenciaParametroDAO("p_id_tipo_sistema_drenaje", OE.getMantenimientoVialEvento().getIdTipoSistemaDrenaje(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));              
			parametros.add(new SentenciaParametroDAO("p_id_tipo_programa", OE.getMantenimientoVialEvento().getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estrategia", OE.getMantenimientoVialEvento().getIdTipoEstrategia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_administracion", OE.getMantenimientoVialEvento().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));               
            parametros.add(new SentenciaParametroDAO("p_id_tipo_requerimiento", OE.getMantenimientoVialEvento().getIdTipoRequerimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                
            parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad_detallada", OE.getMantenimientoVialEvento().getIdTipoActividadDetallada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));          
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_total", OE.getMantenimientoVialEvento().getIdTipoIntervencionTotal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_codigo_actividad_agrupada", OE.getMantenimientoVialEvento().getCodigoActividadAgrupada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Double indicePriorizacion = (OE.getMantenimientoVialEvento().getIndicePriorizacion() == null) ? null : OE.getMantenimientoVialEvento().getIndicePriorizacion().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_indice_priorizacion", indicePriorizacion, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));      
            parametros.add(new SentenciaParametroDAO("p_priorizacion_trimestre", OE.getMantenimientoVialEvento().getPriorizacionTrimestre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));   
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", OE.getMantenimientoVialEvento().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));     
            Double intervencionHuecos = (OE.getMantenimientoVialEvento().getIntervencionHuecos() == null ) ? null : OE.getMantenimientoVialEvento().getIntervencionHuecos().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_huecos", intervencionHuecos, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                  
            parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha(OE.getMantenimientoVialEvento().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_ejecucion", obtenerFecha(OE.getMantenimientoVialEvento().getFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_suspension", obtenerFecha(OE.getMantenimientoVialEvento().getFechaSuspension()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_terminacion", obtenerFecha(OE.getMantenimientoVialEvento().getFechaTerminacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_seguimiento", obtenerFecha(OE.getMantenimientoVialEvento().getFechaSeguimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_id_director_obra",OE.getMantenimientoVialEvento().getIdDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_obra",OE.getMantenimientoVialEvento().getIdResidenteObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_social",OE.getMantenimientoVialEvento().getIdResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_sst",OE.getMantenimientoVialEvento().getIdResidenteSst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_ambiental",OE.getMantenimientoVialEvento().getIdResidenteAmbiental(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_ingeniero_disenio",OE.getMantenimientoVialEvento().getIdIngenieroDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_ingeniero_apoyo",OE.getMantenimientoVialEvento().getIdIngenieroApoyo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_requiere_actualizacion_diag", OE.getMantenimientoVialEvento().getRequiereActualizacionDiag(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_intervencion", OE.getMantenimientoVialEvento().getNumeroRadicadoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_intervencion", obtenerFecha(OE.getMantenimientoVialEvento().getFechaRadicadoIntervencion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_sol_reserva", OE.getMantenimientoVialEvento().getNumeroRadicadoSolReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_sol_reserva", obtenerFecha(OE.getMantenimientoVialEvento().getFechaRadicadoSolReserva()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_res_reserva", OE.getMantenimientoVialEvento().getNumeroRadicadoResReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_res_reserva", obtenerFecha(OE.getMantenimientoVialEvento().getFechaRadicadoResReserva()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_en_seguimiento", OE.getMantenimientoVialEvento().getEnSeguimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_respuesta_aforo", OE.getMantenimientoVialEvento().getRespuestaAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_respuesta_apiques", OE.getMantenimientoVialEvento().getRespuestaApiques(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida actualizar(MantenimientoVialEventoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getMantenimientoVialEvento().getIdMantenimientoVial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                        
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getMantenimientoVialEvento().getIdMantenimientoVial().getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_evento", OE.getMantenimientoVialEvento().getEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_creacion_evento", obtenerFecha(OE.getMantenimientoVialEvento().getFechaCreacionEvento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_visita", obtenerFecha(OE.getMantenimientoVialEvento().getFechaVisita()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            Long idResponsableVisita = (OE.getMantenimientoVialEvento().getIdResponsableVisita() == null ) ? null : OE.getMantenimientoVialEvento().getIdResponsableVisita(); 
            parametros.add(new SentenciaParametroDAO("p_id_responsable_visita", idResponsableVisita, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Long idDocumentoVisita = (OE.getMantenimientoVialEvento().getIdDocumentoVisita() == null ) ? null : OE.getMantenimientoVialEvento().getIdDocumentoVisita();
            parametros.add(new SentenciaParametroDAO("p_id_documento_visita", idDocumentoVisita, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_observaciones",OE.getMantenimientoVialEvento().getObservaciones() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_ancho_pk", OE.getMantenimientoVialEvento().getAnchoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_area_pk", OE.getMantenimientoVialEvento().getAreaPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_longitud_horizontal_pk", OE.getMantenimientoVialEvento().getLongitudHorizontalPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_uso_via", OE.getMantenimientoVialEvento().getIdTipoUsoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_malla", OE.getMantenimientoVialEvento().getIdTipoMalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getMantenimientoVialEvento().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_eje_vial", OE.getMantenimientoVialEvento().getEjeVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_desde", OE.getMantenimientoVialEvento().getDesde(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_hasta", OE.getMantenimientoVialEvento().getHasta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_posible_danio_redes", OE.getMantenimientoVialEvento().getPosibleDanioRedes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_rutas_transporte", OE.getMantenimientoVialEvento().getRutasTransporte(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_transitabilidad", OE.getMantenimientoVialEvento().getIdTipoTransitabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_impacto_social", OE.getMantenimientoVialEvento().getIdTipoImpactoSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_determinacion_interv", OE.getMantenimientoVialEvento().getIdTipoDeterminacionInterv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_coordinacion_interinst", OE.getMantenimientoVialEvento().getIdTipoCoordinacionInterinst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_aporte_metas", OE.getMantenimientoVialEvento().getIdTipoAporteMetas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_pmt", OE.getMantenimientoVialEvento().getIdTipoPmt(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_pci", OE.getMantenimientoVialEvento().getPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double kmCarrilImpacto = (OE.getMantenimientoVialEvento().getKmCarrilImpacto() == null) ? null : OE.getMantenimientoVialEvento().getKmCarrilImpacto().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_km_carril_impacto", kmCarrilImpacto, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double kmCarrilObra = (OE.getMantenimientoVialEvento().getKmCarrilObra() == null ) ? null : OE.getMantenimientoVialEvento().getKmCarrilObra().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_km_carril_obra", kmCarrilObra, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double kmCarril = (OE.getMantenimientoVialEvento().getKmCarril() == null) ? null : OE.getMantenimientoVialEvento().getKmCarril().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_km_carril", kmCarril, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double kmLineal = (OE.getMantenimientoVialEvento().getKmLineal() == null) ? null : OE.getMantenimientoVialEvento().getKmLineal().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_km_lineal", kmLineal, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_requiere_aforo", OE.getMantenimientoVialEvento().getRequiereAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_requiere_apiques", OE.getMantenimientoVialEvento().getRequiereAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_solicitudes_adicionales", OE.getMantenimientoVialEvento().getSolicitudesAdicionales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_observacion_adicionales", OE.getMantenimientoVialEvento().getSolicitudesAdicionales(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_viable_intervencion", OE.getMantenimientoVialEvento().getViableIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_observacion_viable_intervencion", OE.getMantenimientoVialEvento().getObservacionViableIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_clasificacion_subrasant", OE.getMantenimientoVialEvento().getIdTipoClasificacionSubrasant(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie_disenio", OE.getMantenimientoVialEvento().getIdTipoSuperficieDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_final_disenio", OE.getMantenimientoVialEvento().getIdTipoIntervencionFinalDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_metodologia_disenio", OE.getMantenimientoVialEvento().getIdTipoMetodologiaDisenio(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_material_granular", OE.getMantenimientoVialEvento().getIdTipoMaterialGranular(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double espesor = (OE.getMantenimientoVialEvento().getEspesorDisenio() == null) ? null : OE.getMantenimientoVialEvento().getEspesorDisenio().doubleValue(); 
            parametros.add(new SentenciaParametroDAO("p_espesor_disenio", espesor,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double cbrinicialpct = ( OE.getMantenimientoVialEvento().getCbrInicialPct() == null) ? null : OE.getMantenimientoVialEvento().getCbrInicialPct().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_cbr_inicial_pct", cbrinicialpct,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double cbrdiseniopct = ( OE.getMantenimientoVialEvento().getCbrInicialPct() == null) ? null : OE.getMantenimientoVialEvento().getCbrInicialPct().doubleValue();            
            parametros.add(new SentenciaParametroDAO("p_cbr_disenio_pct", cbrdiseniopct,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));          
            Double ksdisenio = (OE.getMantenimientoVialEvento().getKsDisenio() == null) ? null : OE.getMantenimientoVialEvento().getKsDisenio().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_ks_disenio", ksdisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));               
            Double needisenio = (OE.getMantenimientoVialEvento().getNeeDisenio() == null) ? null : OE.getMantenimientoVialEvento().getNeeDisenio().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_nee_disenio", needisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));              
            Double tpdvcdisenio = (OE.getMantenimientoVialEvento().getTpdvcDisenio() == null ) ? null : OE.getMantenimientoVialEvento().getTpdvcDisenio().doubleValue();  
            parametros.add(new SentenciaParametroDAO("p_tpdvc_disenio", tpdvcdisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            Double numeroestructuralefectivodisenio = (OE.getMantenimientoVialEvento().getNumeroEstructuralEfectivoDisenio() == null ) ? null : OE.getMantenimientoVialEvento().getNumeroEstructuralEfectivoDisenio().doubleValue();              
    		parametros.add(new SentenciaParametroDAO("p_numero_estructural_efectivo_disenio", numeroestructuralefectivodisenio,SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			parametros.add(new SentenciaParametroDAO("p_id_tipo_geosinteticos", OE.getMantenimientoVialEvento().getIdTipoGeosinteticos(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));              
			parametros.add(new SentenciaParametroDAO("p_id_tipo_sistema_drenaje", OE.getMantenimientoVialEvento().getIdTipoSistemaDrenaje(),SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));              
			parametros.add(new SentenciaParametroDAO("p_id_tipo_programa", OE.getMantenimientoVialEvento().getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estrategia", OE.getMantenimientoVialEvento().getIdTipoEstrategia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_tipo_administracion", OE.getMantenimientoVialEvento().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));               
            parametros.add(new SentenciaParametroDAO("p_id_tipo_requerimiento", OE.getMantenimientoVialEvento().getIdTipoRequerimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                
            parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad_detallada", OE.getMantenimientoVialEvento().getIdTipoActividadDetallada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));          
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion_total", OE.getMantenimientoVialEvento().getIdTipoIntervencionTotal(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_codigo_actividad_agrupada", OE.getMantenimientoVialEvento().getCodigoActividadAgrupada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            Double indicePriorizacion = (OE.getMantenimientoVialEvento().getIndicePriorizacion() == null) ? null : OE.getMantenimientoVialEvento().getIndicePriorizacion().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_indice_priorizacion", indicePriorizacion, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));      
            parametros.add(new SentenciaParametroDAO("p_priorizacion_trimestre", OE.getMantenimientoVialEvento().getPriorizacionTrimestre(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));   
            parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", OE.getMantenimientoVialEvento().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));     
            Double intervencionHuecos = (OE.getMantenimientoVialEvento().getIntervencionHuecos() == null ) ? null : OE.getMantenimientoVialEvento().getIntervencionHuecos().doubleValue();
            parametros.add(new SentenciaParametroDAO("p_intervencion_huecos", intervencionHuecos, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));                  
            parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha(OE.getMantenimientoVialEvento().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_ejecucion", obtenerFecha(OE.getMantenimientoVialEvento().getFechaEjecucion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_suspension", obtenerFecha(OE.getMantenimientoVialEvento().getFechaSuspension()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_terminacion", obtenerFecha(OE.getMantenimientoVialEvento().getFechaTerminacion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fecha_seguimiento", obtenerFecha(OE.getMantenimientoVialEvento().getFechaSeguimiento()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_id_director_obra",OE.getMantenimientoVialEvento().getIdDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_obra",OE.getMantenimientoVialEvento().getIdResidenteObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_social",OE.getMantenimientoVialEvento().getIdResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_sst",OE.getMantenimientoVialEvento().getIdResidenteSst(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_residente_ambiental",OE.getMantenimientoVialEvento().getIdResidenteAmbiental(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_ingeniero_disenio",OE.getMantenimientoVialEvento().getIdIngenieroDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_ingeniero_apoyo",OE.getMantenimientoVialEvento().getIdIngenieroApoyo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_requiere_actualizacion_diag", OE.getMantenimientoVialEvento().getRequiereActualizacionDiag(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_intervencion", OE.getMantenimientoVialEvento().getNumeroRadicadoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_intervencion", obtenerFecha(OE.getMantenimientoVialEvento().getFechaRadicadoIntervencion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_sol_reserva", OE.getMantenimientoVialEvento().getNumeroRadicadoSolReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_sol_reserva", obtenerFecha(OE.getMantenimientoVialEvento().getFechaRadicadoSolReserva()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_numero_radicado_res_reserva", OE.getMantenimientoVialEvento().getNumeroRadicadoResReserva(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_fecha_radicado_res_reserva", obtenerFecha(OE.getMantenimientoVialEvento().getFechaRadicadoResReserva()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_en_seguimiento", OE.getMantenimientoVialEvento().getEnSeguimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_respuesta_aforo", OE.getMantenimientoVialEvento().getRespuestaAforo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_respuesta_apiques", OE.getMantenimientoVialEvento().getRespuestaApiques(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida eliminar(MantenimientoVialEventoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_eliminar", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
                        
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
	public ObjetoSalida consultarXFiltro(MantenimientoVialEventoOE OE) {
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
	public ObjetoSalida actualizarPCI(MantenimientoVialEventoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_pci", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_pci", OE.getMantenimientoVialEvento().getPci(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            //parametros.add(new SentenciaParametroDAO("p_id_tipo_calificacion_pci", OE.getMantenimientovial().getIdTipoAdministracion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
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
	public ObjetoSalida actualizarCampo(MantenimientoVialEventoOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_campo", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
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
