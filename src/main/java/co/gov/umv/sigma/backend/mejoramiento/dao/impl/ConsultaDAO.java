package co.gov.umv.sigma.backend.mejoramiento.dao.impl;



import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.GenericoDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ConsultaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IConsultaDAO;
import oracle.jdbc.OracleTypes;

public class ConsultaDAO extends GenericoDAO implements IConsultaDAO
{
	private final static String PACKAGE = "PKG_CONSULTAS"; 
	
	@Override
	public ObjetoSalida consultarMantenimientoVial(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_mantenimiento_vial", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", OE.getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));//ajustado que reciba varios pk_id_calzada separados por coma
            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upla", OE.getIdUPLA(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_cuadrante", OE.getIdCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upz", OE.getIdUPZ(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pk", OE.getIdTipoEstadoPk(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_uso_via", OE.getIdTipoUsoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_malla", OE.getIdTipoMalla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_prog_visita", OE.getIdTipoEstadoProgVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_responsable_visit", OE.getIdPersonaResponsableVisit(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_transitabilidad", OE.getIdTipoTransitabilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_impacto_social", OE.getIdTipoImpactoSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_determinacion_interv", OE.getIdTipoDeterminacionInterv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_aporte_metas", OE.getIdTipoAporteMetas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_coordinacion_inter", OE.getIdTipoCoordinacionInter(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_calificacion_pci", OE.getIdTipoCalificacionPCI(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_zona_eab_esp", OE.getIdZonaEABESP(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_seccion_vial", OE.getIdTipoSeccionVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_programa", OE.getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estrategia", OE.getIdTipoEstrategia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_actividad", OE.getIdTipoActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_ejecucion", OE.getIdTipoEjecucion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_clase", OE.getIdTipoClase(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_responsable_verif", OE.getIdPersonaResponsableVerif(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_director_obra", OE.getIdPersonaDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_social", OE.getIdPersonaResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_sst", OE.getIdPersonaResidenteSST(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_ambi", OE.getIdPersonaResidenteAmbiental(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_pmt", OE.getIdTipoPMT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pmt", OE.getIdTipoEstadoPMT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_persona_residente_obra", OE.getIdPersonaResidenteObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", OE.getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_tipo_via", OE.getIdTipoVia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fechavisitatecnica_desde", obtenerFecha(OE.getFechaVisitaTecnicaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_fechavisitatecnica_hasta", obtenerFecha(OE.getFechaVisitaTecnicaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fechavisitaverifica_desde", obtenerFecha(OE.getFechaVisitaVerificaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_fechavisitaverifica_hasta", obtenerFecha(OE.getFechaVisitaVerificaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_civ", OE.getCiv(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarGestionPendiente(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_gestion_pendiente", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_lista_roles", OE.getListaRoles(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarActividadSiguiente(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actividad_siguiente", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
                        
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_gestio", OE.getIdMantenimientoGestion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarActividadSiguienteSino(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actividad_siguiente_sino", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_gestio", OE.getIdMantenimientoGestion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarDisponibilidadPersonas(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_disponibilidad_personas", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
                        
            parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha(OE.getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha(OE.getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_lista_usuarios", OE.getListaUsuarios(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarProgramaciones(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_programaciones", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha(OE.getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha(OE.getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_usuario_programado", OE.getUsuarioProgramado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            
                        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarCargaTrabajoActual(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_cargatrabajo_actual", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_lista_usuarios", OE.getListaUsuarios(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR)); //RSG tenia otro parametro
            parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarUsuarioGestionPrevia(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_usuario_gestionprevia", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarGeneralGestion(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consulta_general_gestion", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_Upz", OE.getIdUPZ(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_programa", OE.getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_usuario", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER)); 
            parametros.add(new SentenciaParametroDAO("p_id_responsable_visita", OE.getIdResponsableVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER)); //RSG estaba otro parametro
            parametros.add(new SentenciaParametroDAO("p_fecha_fin_gestion_desde", obtenerFecha(OE.getFechaFinGestionDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_fecha_fin_gestion_hasta", obtenerFecha(OE.getFechaFinGestionHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
            
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarSeguimientoUTL(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consulta_seguimiento_ult", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_Upz", OE.getIdUPZ(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_programa", OE.getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_responsable_visita", OE.getIdResponsableVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_fin_gestion_desde", obtenerFecha(OE.getFechaFinGestionDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_fecha_fin_gestion_hasta", obtenerFecha(OE.getFechaFinGestionHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarSeguimientos(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consulta_seguimientos", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            
            parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_Upz", OE.getIdUPZ(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_programa", OE.getIdTipoPrograma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));            
            parametros.add(new SentenciaParametroDAO("p_id_responsable_visita", OE.getIdResponsableVisita(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_fecha_fin_gestion_desde", obtenerFecha(OE.getFechaFinGestionDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));            
            parametros.add(new SentenciaParametroDAO("p_fecha_fin_gestion_hasta", obtenerFecha(OE.getFechaFinGestionHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
                        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            //ErrorClass.getMessage(objetoSalida,ListadosDAO.class);
        }
        return objetoSalida;
	}

	
	@Override
	public ObjetoSalida consultarDivisionTerritorial(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO("PKG_DIVISION_TERRITORIAL"+".prc_consulta_division_territorial", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_cod_localidad", OE.getCodLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cod_sector", OE.getCodSector(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cod_upl", OE.getCodUPL(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_cod_cuadrante", OE.getCodCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                        
            parametros.add(new SentenciaParametroDAO("p_id_cuadrante", OE.getIdCuadrante(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_upla", OE.getIdUPLA(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
                 
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
            
        } catch (Exception e) {

            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
            
        }
        return objetoSalida;
	}

	
	
	public ObjetoSalida consultarMantenimientoVialEventos(ConsultaOE OE)
	{
		
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_mantenimiento_vial_eventos", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}
	
	public ObjetoSalida consultarUnidadesMuestreo(ConsultaOE OE)
	{
		
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_unidades_muestreo", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}
	
	
	public ObjetoSalida consultarFallas(ConsultaOE OE)
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_fallas", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_unidad_muestreo", OE.getIdUnidadMuestreo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}
	
	public ObjetoSalida consultarMantenimientoVialDocumento(ConsultaOE OE)
	{
		
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_mantenimiento_vial_docu", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}
	
	
	public ObjetoSalida consultarMantenimientoVialGestion(ConsultaOE OE)
	{
		
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_mantenimiento_vial_gestion", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}
	
	public ObjetoSalida consultarOtrosFactores(ConsultaOE OE)
	{
		
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_otros_factores", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}
	
	
	
	public ObjetoSalida consultarSolicitudesAforosApiques(ConsultaOE OE)
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_solicitudes_aforos_apiques", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_usuario", OE.getIdUsuario(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER)); 
             
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarAreaIntervencion(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_area_intervencion", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
             
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarIntervencionNovedad(ConsultaOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_intervencion_novedad", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
            
            parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento",  OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
             
            objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
        
	    } 
        catch (Exception e) 
        {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
        return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarSeguimientosProximos(ConsultaOE OE)
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_seguimientos_proximos", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_pk_id_calzada",  OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
	        parametros.add(new SentenciaParametroDAO("p_id_zona",  OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        parametros.add(new SentenciaParametroDAO("p_id_localidad",  OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        parametros.add(new SentenciaParametroDAO("p_id_upz",  OE.getIdUPZ(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        parametros.add(new SentenciaParametroDAO("p_id_barrio",  OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        parametros.add(new SentenciaParametroDAO("p_dias_ultima_visita",  OE.getDiasUltimaVisita() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
	    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	/******************************************************/
	
	@Override
	public ObjetoSalida consultaRadicadoVinculado(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_RADICADO_VINCULADO", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	                
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaPredisenioAledanio(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_PREDISENIO_ALEDANIOS", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento",  OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	             
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaPredisenioApiques(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_PREDISENIO_APIQUES", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento",  OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    	        
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaAlternativasDisenio(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_ALTERNATIVAS_DISENIO", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento",  OE.getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		       
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaDisenioCapa(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_DISENIO_CAPA", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_alternativa_disenio",  OE.getIdAlternativaDisenio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			      
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaProgramacionDiaria(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_PROGRAMACION_DIARIA", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		         
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaProgramacionDiariaPersonal(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_PROGDIARIA_PERSONAL", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", OE.getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			   
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaProgramacionDiariaMaquinaria(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_PROGDIARIA_MAQUINARIA", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", OE.getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			    
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaProgramacionDiariaMaterial(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_PROGDIARIA_MATERIAL", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_programacion_diaria", OE.getIdProgramacionDiaria(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			  
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaArchivosMantenimientoVial(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".PRC_ARCHIVOS_MANTENIMIENTO", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			     
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultaCalculadoMantenimientoVial(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_consulta_calculados_mv", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			     
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}

	@Override
	public ObjetoSalida consultarMantenimientoVialDocumentoArchivo(ConsultaOE OE) {
		ObjetoSalida objetoSalida = new ObjetoSalida();
	    try 
	    {
	        SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_mant_vial_doctos_archivos", OE.getUsuario());
	        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	        sentencia.setParametros(parametros);
	        
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
			     
	        objetoSalida = this.ejecutarProcedure(sentencia, objetoSalida);
		    
	    } 
	    catch (Exception e) 
	    {
	        objetoSalida.setCodError(CodError.ERROR_INTERNO);
	        objetoSalida.setMsgError(e.getMessage());
	    }
	    return objetoSalida;
	}
	
	
}
