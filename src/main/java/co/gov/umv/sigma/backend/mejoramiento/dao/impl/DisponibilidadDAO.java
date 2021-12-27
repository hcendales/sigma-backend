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

public class DisponibilidadDAO  extends CrudDAO implements ICrudDAO
{
	private final static String PACKAGE = "PKG_RECURSO_DISPONIBILIDAD";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
        parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getDisponibilidad().getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_fecha_inicio",  obtenerFecha(((RecursoOE)OE).getDisponibilidad().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((RecursoOE)OE).getDisponibilidad().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));   
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros); 
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", ((RecursoOE)OE).getDisponibilidad().getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getDisponibilidad().getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_fecha_inicio",  obtenerFecha(((RecursoOE)OE).getDisponibilidad().getFechaInicio()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_fecha_fin", obtenerFecha(((RecursoOE)OE).getDisponibilidad().getFechaFin()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));   
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros); 
     }


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso_disponibilidad", ((RecursoOE)OE).getDisponibilidad().getIdRecursoDisponibilidad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros); 
     }

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}





