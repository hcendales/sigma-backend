package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.GestionRecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RecursoOE;
import oracle.jdbc.OracleTypes;

public class GestionRecursoDAO extends CrudDAO 
{
	
	private final static String PACKAGE = "PKG_GESTION_RECURSOS";

	
	
	public ObjetoSalida listarDisponibilidadRecurso(RecursoOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
      
	    if( ((RecursoOE)OE).getRecurso().getPersona() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_persona", ((RecursoOE)OE).getRecurso().getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_persona", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getEquipo() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_equipo", ((RecursoOE)OE).getRecurso().getEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_equipo", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getLugar() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_lugar", ((RecursoOE)OE).getRecurso().getLugar().getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_lugar", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    
		
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
        return ejecutar(OE, PACKAGE+".prc_ListarDisponibilidadRecurso", parametros); 
	}
	
	
	public ObjetoSalida listarDisponibilidadxTipoRecurso(RecursoOE OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
      
    	parametros.add(new SentenciaParametroDAO("p_tipoRecurso", OE.getTipoRecurso() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
        return ejecutar(OE, PACKAGE+".prc_ListarDisponibilidadXTipoRecurso", parametros); 
	}
	


	public ObjetoSalida crearRecursoConDisponibilidad(RecursoOE OE) 
	{

		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
      
		parametros.add(new SentenciaParametroDAO("p_id_tipo_recurso", ((RecursoOE)OE).getRecurso().getIdTipoRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		if( ((RecursoOE)OE).getRecurso().getPersona() != null )
			parametros.add(new SentenciaParametroDAO("p_id_persona", ((RecursoOE)OE).getRecurso().getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		else 
			parametros.add(new SentenciaParametroDAO("p_id_persona", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		if( ((RecursoOE)OE).getRecurso().getEquipo() != null )
			parametros.add(new SentenciaParametroDAO("p_id_equipo", ((RecursoOE)OE).getRecurso().getEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		else 
			parametros.add(new SentenciaParametroDAO("p_id_equipo", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		if( ((RecursoOE)OE).getRecurso().getLugar() != null )
			parametros.add(new SentenciaParametroDAO("p_id_lugar", ((RecursoOE)OE).getRecurso().getLugar().getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		else 
			parametros.add(new SentenciaParametroDAO("p_id_lugar", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha( ((RecursoOE)OE).getRecurso().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((RecursoOE)OE).getRecurso().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		parametros.add(new SentenciaParametroDAO("p_hora_inicio", ((RecursoOE)OE).getRecurso().getHoraInicioProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_hora_fin", ((RecursoOE)OE).getRecurso().getHoraFinProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));

		parametros.add(new SentenciaParametroDAO("p_intervalo", ((RecursoOE)OE).getRecurso().getIntervaloProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		parametros.add(new SentenciaParametroDAO("p_franja_inicio", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_franja_fin", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
		return ejecutar(OE, PACKAGE+".prc_GenerarRecursoyFranjas", parametros); 
	}
	
	public ObjetoSalida relacionaryAsignarRecursoOtraActividad(GestionRecursoOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", OE.getRelacion().getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad_relacionado", OE.getRelacion().getIdRecursoDisponibilidadRelacionado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_persona", OE.getRelacion().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_asignacion",OE.getRelacion().getIdTipoAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_relacionaryAsignarRecursoOtraActividad", parametros);	
	}
	
	public ObjetoSalida desasociarRecursoOtraActividad(GestionRecursoOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", OE.getRelacion().getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad_relacionado", OE.getRelacion().getIdRecursoDisponibilidadRelacionado(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_asignacion",OE.getRelacion().getIdTipoAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_desasociarRecursoRelacionado", parametros);	
	}

	public ObjetoSalida ListarEquiposDisponibles(ObjetoEntrada OE) {
		return consultaXFiltro(OE, PACKAGE+".prc_ListarEquiposDisponibles");
	}

	public ObjetoSalida listarRelacionEquipos(ObjetoEntrada OE) {
		return consultaXFiltro(OE, PACKAGE+".prc_ListarRelacionEquipos");
	}
	
	
	public ObjetoSalida listarRecursosRelacionadosParaAsignacion(GestionRecursoOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_persona", OE.getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_equipo", OE.getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_lugar", OE.getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_tipo_asignacion", OE.getTiposAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
				
		return ejecutar(OE, PACKAGE+".prc_ListarRecursosRelacionadosParaAsignacion", parametros);	
	}


	public ObjetoSalida buscarFranjasEquiposPersonas(GestionRecursoOE OE) {
		return consultaXFiltro(OE, PACKAGE+".prc_BuscarFranjasEquiposConPersonas");
	}


	public ObjetoSalida crearRecurso(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
        parametros.add(new SentenciaParametroDAO("p_id_tipo_recurso", ((RecursoOE)OE).getRecurso().getIdTipoRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_intervalo_programacion", ((RecursoOE)OE).getRecurso().getIntervaloProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getPersona() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_persona", ((RecursoOE)OE).getRecurso().getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_persona", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getEquipo() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_equipo", ((RecursoOE)OE).getRecurso().getEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_equipo", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getLugar() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_lugar", ((RecursoOE)OE).getRecurso().getLugar().getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_lugar", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
       
        parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha( ((RecursoOE)OE).getRecurso().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((RecursoOE)OE).getRecurso().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_hora_inicio_programacion", ((RecursoOE)OE).getRecurso().getHoraInicioProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_hora_fin_programacion", ((RecursoOE)OE).getRecurso().getHoraFinProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_descripcion", ((RecursoOE)OE).getRecurso().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
        return ejecutar(OE, PACKAGE+".prc_crear_recurso", parametros); 
	}


	public ObjetoSalida actualizarRecurso(RecursoOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
        parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_recurso", ((RecursoOE)OE).getRecurso().getIdTipoRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_intervalo_programacion", ((RecursoOE)OE).getRecurso().getIntervaloProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));

        if( ((RecursoOE)OE).getRecurso().getPersona() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_persona", ((RecursoOE)OE).getRecurso().getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_persona", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getEquipo() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_equipo", ((RecursoOE)OE).getRecurso().getEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_equipo", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getRecurso().getLugar() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_lugar", ((RecursoOE)OE).getRecurso().getLugar().getIdLugar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else 
        	parametros.add(new SentenciaParametroDAO("p_id_lugar", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        parametros.add(new SentenciaParametroDAO("p_fecha_inicio", obtenerFecha( ((RecursoOE)OE).getRecurso().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((RecursoOE)OE).getRecurso().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_hora_inicio_programacion", ((RecursoOE)OE).getRecurso().getHoraInicioProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_hora_fin_programacion", ((RecursoOE)OE).getRecurso().getHoraFinProgramacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        parametros.add(new SentenciaParametroDAO("p_descripcion", ((RecursoOE)OE).getRecurso().getDescripcion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        return ejecutar(OE, PACKAGE+".prc_actualizar_recurso", parametros); 
	}


	public ObjetoSalida gestionarNovedad(RecursoOE OE) 
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    
		parametros.add(new SentenciaParametroDAO("p_id_recurso_novedad", ((RecursoOE)OE).getNovedad().getIdRecursoNovedad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
		if( ((RecursoOE)OE).getEliminar() != 1L )
		{
			parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getNovedad().getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        parametros.add(new SentenciaParametroDAO("p_id_tipo_novedad", ((RecursoOE)OE).getNovedad().getIdTipoNovedad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	        parametros.add(new SentenciaParametroDAO("p_hora_desde", obtenerFecha( ((RecursoOE)OE).getNovedad().getHoraDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
	        parametros.add(new SentenciaParametroDAO("p_hora_hasta", obtenerFecha( ((RecursoOE)OE).getNovedad().getHoraHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
	        parametros.add(new SentenciaParametroDAO("p_observaciones", ((RecursoOE)OE).getNovedad().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
		}
		
        parametros.add(new SentenciaParametroDAO("p_eliminar", ((RecursoOE)OE).getEliminar(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        return ejecutar(OE, PACKAGE+".prc_gestionarNovedad", parametros);
	}


	public ObjetoSalida listarDisponibilidadTotalXTipo(RecursoOE OE)
	{
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	      
    	parametros.add(new SentenciaParametroDAO("p_tipoRecurso", OE.getTipoRecurso() , SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( OE.getFechaDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( OE.getFechaHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        
        return ejecutar(OE, PACKAGE+".prc_ListarDisponibilidadTotalXTipoRecurso", parametros); 
	}


	

}
