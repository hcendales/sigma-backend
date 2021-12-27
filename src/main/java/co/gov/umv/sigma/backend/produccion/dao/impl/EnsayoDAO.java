package co.gov.umv.sigma.backend.produccion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import co.gov.umv.sigma.backend.produccion.cbo.LaboratorioOE;
import oracle.jdbc.OracleTypes;

public class EnsayoDAO  extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_ENSAYO";
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_documento", ((LaboratorioOE)OE).getEnsayo().getIdDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_servicio", ((LaboratorioOE)OE).getEnsayo().getIdTipoServicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_grupo", ((LaboratorioOE)OE).getEnsayo().getIdTipoGrupo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_subgrupo", ((LaboratorioOE)OE).getEnsayo().getSubgrupo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", ((LaboratorioOE)OE).getEnsayo().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_codigo_ensayo", ((LaboratorioOE)OE).getEnsayo().getCodigoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_solicitud", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaSolicitud()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_programada", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaProgramada()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_recepcion", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaRecepcion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_instalacion_mezcla", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaInstalacionMezcla()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_version", ((LaboratorioOE)OE).getEnsayo().getVersion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora", ((LaboratorioOE)OE).getEnsayo().getHora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_persona_director_obra", ((LaboratorioOE)OE).getEnsayo().getIdPersonaDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_residente_social", ((LaboratorioOE)OE).getEnsayo().getIdPersonaResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_telefono_director_obra", ((LaboratorioOE)OE).getEnsayo().getTelefonoDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_telefono_residente_social", ((LaboratorioOE)OE).getEnsayo().getTelefonoResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_direccion", ((LaboratorioOE)OE).getEnsayo().getDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_mes", ((LaboratorioOE)OE).getEnsayo().getMes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_anio", ((LaboratorioOE)OE).getEnsayo().getAnio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_consecutivo", ((LaboratorioOE)OE).getEnsayo().getConsecutivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_placa", ((LaboratorioOE)OE).getEnsayo().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_lote", ((LaboratorioOE)OE).getEnsayo().getIdLote(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_jornada", ((LaboratorioOE)OE).getEnsayo().getIdJornada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_capas", ((LaboratorioOE)OE).getEnsayo().getIdCapas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_frecuencia", ((LaboratorioOE)OE).getEnsayo().getIdFrecuencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_perfil", ((LaboratorioOE)OE).getEnsayo().getIdPerfil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_planta", ((LaboratorioOE)OE).getEnsayo().getIdPlanta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_obra", ((LaboratorioOE)OE).getEnsayo().getIdObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_solicitud", ((LaboratorioOE)OE).getEnsayo().getIdUsuarioSolicitud(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_recibe_muestra", ((LaboratorioOE)OE).getEnsayo().getIdUsuarioRecibeMuestra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_procedencia_muestra", ((LaboratorioOE)OE).getEnsayo().getProcedenciaMuestra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_cantidad_frecuencia", ((LaboratorioOE)OE).getEnsayo().getCantidadFrecuencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_observacion", ((LaboratorioOE)OE).getEnsayo().getIdTipoObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_apiques", ((LaboratorioOE)OE).getEnsayo().getApiques(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_actividad", ((LaboratorioOE)OE).getEnsayo().getActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_espesor", ((LaboratorioOE)OE).getEnsayo().getEspesor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_origen", ((LaboratorioOE)OE).getEnsayo().getOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_mezcla_formula", ((LaboratorioOE)OE).getEnsayo().getMezclaFormula(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_descripcion", ((LaboratorioOE)OE).getEnsayo().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observacion", ((LaboratorioOE)OE).getEnsayo().getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_novedades", ((LaboratorioOE)OE).getEnsayo().getNovedades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_cantidad", ((LaboratorioOE)OE).getEnsayo().getIdTipoCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_prioridad", ((LaboratorioOE)OE).getEnsayo().getPrioridad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_responsable_toma", ((LaboratorioOE)OE).getEnsayo().getIdResponsableToma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_toma", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaToma()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_situacion", ((LaboratorioOE)OE).getEnsayo().getSituacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayo().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_documento", ((LaboratorioOE)OE).getEnsayo().getIdDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_servicio", ((LaboratorioOE)OE).getEnsayo().getIdTipoServicio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_grupo", ((LaboratorioOE)OE).getEnsayo().getIdTipoGrupo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_subgrupo", ((LaboratorioOE)OE).getEnsayo().getSubgrupo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", ((LaboratorioOE)OE).getEnsayo().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_codigo_ensayo", ((LaboratorioOE)OE).getEnsayo().getCodigoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_solicitud", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaSolicitud()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_programada", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaProgramada()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_recepcion", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaRecepcion()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_instalacion_mezcla", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaInstalacionMezcla()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_version", ((LaboratorioOE)OE).getEnsayo().getVersion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_hora", ((LaboratorioOE)OE).getEnsayo().getHora(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_persona_director_obra", ((LaboratorioOE)OE).getEnsayo().getIdPersonaDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_residente_social", ((LaboratorioOE)OE).getEnsayo().getIdPersonaResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_telefono_director_obra", ((LaboratorioOE)OE).getEnsayo().getTelefonoDirectorObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_telefono_residente_social", ((LaboratorioOE)OE).getEnsayo().getTelefonoResidenteSocial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_direccion", ((LaboratorioOE)OE).getEnsayo().getDireccion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_mes", ((LaboratorioOE)OE).getEnsayo().getMes(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_anio", ((LaboratorioOE)OE).getEnsayo().getAnio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_consecutivo", ((LaboratorioOE)OE).getEnsayo().getConsecutivo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_placa", ((LaboratorioOE)OE).getEnsayo().getPlaca(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_lote", ((LaboratorioOE)OE).getEnsayo().getIdLote(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_jornada", ((LaboratorioOE)OE).getEnsayo().getIdJornada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_capas", ((LaboratorioOE)OE).getEnsayo().getIdCapas(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_frecuencia", ((LaboratorioOE)OE).getEnsayo().getIdFrecuencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_perfil", ((LaboratorioOE)OE).getEnsayo().getIdPerfil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_planta", ((LaboratorioOE)OE).getEnsayo().getIdPlanta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_obra", ((LaboratorioOE)OE).getEnsayo().getIdObra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_solicitud", ((LaboratorioOE)OE).getEnsayo().getIdUsuarioSolicitud(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_usuario_recibe_muestra", ((LaboratorioOE)OE).getEnsayo().getIdUsuarioRecibeMuestra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_procedencia_muestra", ((LaboratorioOE)OE).getEnsayo().getProcedenciaMuestra(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_cantidad_frecuencia", ((LaboratorioOE)OE).getEnsayo().getCantidadFrecuencia(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_observacion", ((LaboratorioOE)OE).getEnsayo().getIdTipoObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_apiques", ((LaboratorioOE)OE).getEnsayo().getApiques(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_actividad", ((LaboratorioOE)OE).getEnsayo().getActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_espesor", ((LaboratorioOE)OE).getEnsayo().getEspesor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_origen", ((LaboratorioOE)OE).getEnsayo().getOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_mezcla_formula", ((LaboratorioOE)OE).getEnsayo().getMezclaFormula(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_descripcion", ((LaboratorioOE)OE).getEnsayo().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_observacion", ((LaboratorioOE)OE).getEnsayo().getObservacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_novedades", ((LaboratorioOE)OE).getEnsayo().getNovedades(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_cantidad", ((LaboratorioOE)OE).getEnsayo().getIdTipoCantidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_prioridad", ((LaboratorioOE)OE).getEnsayo().getPrioridad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_responsable_toma", ((LaboratorioOE)OE).getEnsayo().getIdResponsableToma(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_toma", obtenerFecha( ((LaboratorioOE)OE).getEnsayo().getFechaToma()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_situacion", ((LaboratorioOE)OE).getEnsayo().getSituacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayo().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}


	public ObjetoSalida eliminarXCodigoEnsayo(LaboratorioOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_codigo_ensayo", ((LaboratorioOE)OE).getEnsayo().getCodigoEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar_por_codigo", parametros);
	}


	public ObjetoSalida consultarOrdenPrioridad(LaboratorioOE OE) {
		return consultaXFiltro(OE, PACKAGE+".prc_consultarOrdenPrioridad");
	}


	public ObjetoSalida actualizarCampo(LaboratorioOE OE) 
	{
		ObjetoSalida objetoSalida = new ObjetoSalida();
        try 
        {
            SentenciaDAO sentencia = new SentenciaDAO(PACKAGE+".prc_actualizar_campo", OE.getUsuario());
            List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
            sentencia.setParametros(parametros);
        	parametros.add(new SentenciaParametroDAO("p_id_ensayo", ((LaboratorioOE)OE).getEnsayo().getIdEnsayo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        	parametros.add(new SentenciaParametroDAO("p_nombre_campo", OE.getNombreCampo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
            parametros.add(new SentenciaParametroDAO("p_valor_campo", OE.getValorCampo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));            
            objetoSalida = this.ejecutarX(sentencia, objetoSalida);
            
        } catch (Exception e) {
        	e.printStackTrace();
            objetoSalida.setCodError(CodError.ERROR_INTERNO);
            objetoSalida.setMsgError(e.getMessage());
        }
        return objetoSalida;	
    
	}


	

}
