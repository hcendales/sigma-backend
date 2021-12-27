package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class RecursoDAO extends CrudDAO  implements ICrudDAO
{
	private final static String PACKAGE = "PKG_RECURSO";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
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
        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros); 
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
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
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros); 
    }


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros); 
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	
	
	
	
	public static void main (String [] args) 
	{
		//java.util.Date a = new  java.util.Date();
		
		java.util.Date a = DateUtils.truncate(new java.util.Date(), Calendar.DATE);
		System.out.println(a.getTime());
			
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(a);
		calendar.add(java.util.Calendar.DAY_OF_YEAR, 2);
		java.util.Date fin = calendar.getTime();
		System.out.println(calendar.getTime());
		System.out.println(fin.getTime());
		
	}
}	
	



