package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RecursoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class AsignacionDAO extends CrudDAO implements ICrudDAO
{
	private final static String PACKAGE = "PKG_RECURSO_ASIGNACION";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_tipo_asignacion", ((RecursoOE)OE).getAsignacion().getIdTipoAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getAsignacion().getRecursoDisponibilidad() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", ((RecursoOE)OE).getAsignacion().getRecursoDisponibilidad().getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else
        	parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        	
        if( ((RecursoOE)OE).getAsignacion().getMantenimientoVialEvento() != null )
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((RecursoOE)OE).getAsignacion().getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else
        	parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getAsignacion().getOtraActividad() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_otra_actividad", ((RecursoOE)OE).getAsignacion().getOtraActividad().getIdOtraActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else
        	parametros.add(new SentenciaParametroDAO("p_id_otra_actividad", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
       
        parametros.add(new SentenciaParametroDAO("p_id_produccion_mezcla", ((RecursoOE)OE).getAsignacion().getIdProduccionMezcla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_equipo_mantenimiento", ((RecursoOE)OE).getAsignacion().getIdEquipoMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
        parametros.add(new SentenciaParametroDAO("p_id_recurso_asignacion", ((RecursoOE)OE).getAsignacion().getIdRecursoAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_asignacion", ((RecursoOE)OE).getAsignacion().getIdTipoAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
     
        if( ((RecursoOE)OE).getAsignacion().getRecursoDisponibilidad() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", ((RecursoOE)OE).getAsignacion().getRecursoDisponibilidad().getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else
        	parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        	
        if( ((RecursoOE)OE).getAsignacion().getMantenimientoVialEvento() != null )
	        parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((RecursoOE)OE).getAsignacion().getMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else
        	parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        
        if( ((RecursoOE)OE).getAsignacion().getOtraActividad() != null )
        	parametros.add(new SentenciaParametroDAO("p_id_otra_actividad", ((RecursoOE)OE).getAsignacion().getOtraActividad().getIdOtraActividad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        else
        	parametros.add(new SentenciaParametroDAO("p_id_otra_actividad", null, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
       
        parametros.add(new SentenciaParametroDAO("p_id_produccion_mezcla", ((RecursoOE)OE).getAsignacion().getIdProduccionMezcla(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_equipo_mantenimiento", ((RecursoOE)OE).getAsignacion().getIdEquipoMantenimiento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
    }


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso_asignacion", ((RecursoOE)OE).getAsignacion().getIdRecursoAsignacion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
    }

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}


