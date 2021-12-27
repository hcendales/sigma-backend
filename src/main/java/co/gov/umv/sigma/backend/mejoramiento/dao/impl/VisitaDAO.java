package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.VisitaOE;
import oracle.jdbc.OracleTypes;

public class VisitaDAO extends CrudDAO 
{

	public ObjetoSalida desasignarVisitaVehiculo(VisitaOE OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", OE.getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona", OE.getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, "PKG_PROGRAMACION.prc_DesasignarVehiculoVisita", parametros);	
	}

	public ObjetoSalida consultarVisitaVehiculo(VisitaOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		return ejecutar(OE, "PKG_PROGRAMACION.prc_consultar_visitas_vehiculos", parametros);	
	}

	public ObjetoSalida asignarVisitaVehiculo(VisitaOE OE) {
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", OE.getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona", OE.getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, "PKG_PROGRAMACION.prc_AsignarVehiculoVisita", parametros);	
	}

	public ObjetoSalida consultarDisponibilidadAsignada(VisitaOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", OE.getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, "PKG_PROGRAMACION.prc_consultar_disponibilidad_asignada", parametros);	
	}

	public ObjetoSalida consultarVisitaProgramada(VisitaOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_origen", OE.getIdTipoOrigen(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_zona", OE.getIdZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_localidad", OE.getIdLocalidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_upz", OE.getIdUpz(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_barrio", OE.getIdBarrio(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_actividad", OE.getIdActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_pk_id_calzada", OE.getPkIdCalzada(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_responsable", OE.getIdResponsable(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_movil", OE.getMovil(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));      
		
		parametros.add(new SentenciaParametroDAO("p_fechaDesde", obtenerFecha( OE.getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));      
		parametros.add(new SentenciaParametroDAO("p_fechaHasta", obtenerFecha( OE.getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));      
		parametros.add(new SentenciaParametroDAO("p_conductor", OE.getConductor(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));      
		parametros.add(new SentenciaParametroDAO("p_placa_vehiculo", OE.getPlacaVehiculo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));      
			
	     
		return ejecutar(OE, "PKG_PROGRAMACION.prc_consultar_cons_visi_prog", parametros);	
	}


}
