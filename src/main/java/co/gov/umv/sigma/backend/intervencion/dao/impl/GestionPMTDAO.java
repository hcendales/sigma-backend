package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.CodError;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.SolicitudPMTOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class GestionPMTDAO extends CrudDAO {

	private final static String PACKAGE = "PKG_GESTION_PMT";
	
	public ObjetoSalida asociarSolicitud(SolicitudPMTOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_ids_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_pmt", OE.getIdTipoPMT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado_pmt", OE.getNumeroRadicadoUMV(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_fecha_radicado_pmt", obtenerFecha( OE.getFechaRadicadoUMV() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
    	parametros.add(new SentenciaParametroDAO("p_id_documento", OE.getIdDocumento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    	    
	    return ejecutar(OE, PACKAGE+".prc_asociar_solicitud_pmt", parametros); 
		
	}
	
	public ObjetoSalida registrarRespuesta(SolicitudPMTOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_ids_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_coi", OE.getCoi(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_estado_pmt", OE.getIdTipoEstadoPMT(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado_sdm_pmt", OE.getNumeroRadicadoRta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado_sdm_pmt", obtenerFecha( OE.getFechaRadicadoRta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_id_archivo_coi_pmt", OE.getIdArchivoCoi(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_observaciones_pmt",  OE.getObservaciones() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_registrar_respuesta_pmt", parametros); 
		
	}

	public ObjetoSalida consultarRadicados(SolicitudPMTOE OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_ids_mantenimiento_vial", OE.getIdMantenimientoVial(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		return ejecutar(OE, PACKAGE+".prc_consulta_radicados_pmt", parametros); 
		
	}

	public ObjetoSalida consultaArchivoCOI(SolicitudPMTOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_coi", OE.getCoi(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado_sdm_pmt", OE.getNumeroRadicadoRta(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_fecha_radicado_sdm_pmt", obtenerFecha( OE.getFechaRadicadoRta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		return ejecutar(OE, PACKAGE+".prc_consulta_archivo_COI", parametros); 
		
	}

	public ObjetoSalida desasociarRadicado(SolicitudPMTOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		 boolean isNumeric =  OE.getIdMantenimientoVial().matches("[+-]?\\d*(\\.\\d+)?");
		 
		//valido que sea entero
		if(!isNumeric)
		{
			ObjetoSalida os = new ObjetoSalida();
			os.setCodError(CodError.ERROR_INTERNO);
	        os.setMsgError("Id mantenimiento no es numerico");
	        return os;
		}
		
		Long idMant = new Long(OE.getIdMantenimientoVial());
		
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial", idMant, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_radicado", OE.getIdRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_tipo", OE.getTipoRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_numero_radicado", OE.getRadicado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		
		return ejecutar(OE, PACKAGE+".prc_desasociar_radicado_pmt", parametros); 
		
	}
	
	

}
