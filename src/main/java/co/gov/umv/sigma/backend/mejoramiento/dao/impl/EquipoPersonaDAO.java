package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.mejoramiento.cbo.EquipoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import oracle.jdbc.OracleTypes;

public class EquipoPersonaDAO  extends CrudDAO  implements ICrudDAO
{
	private final static String PACKAGE = "PKG_EQUIPO_PERSONA";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
         
	    parametros.add(new SentenciaParametroDAO("p_id_equipo", ((EquipoOE)OE).getPersona().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_persona", ((EquipoOE)OE).getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((EquipoOE)OE).getPersona().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
	    parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((EquipoOE)OE).getPersona().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
	    parametros.add(new SentenciaParametroDAO("p_observaciones", ((EquipoOE)OE).getPersona().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);  
   }
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        
        parametros.add(new SentenciaParametroDAO("p_id_equipo_persona", ((EquipoOE)OE).getPersona().getIdEquipoPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_equipo", ((EquipoOE)OE).getPersona().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_id_persona", ((EquipoOE)OE).getPersona().getIdPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
	    parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((EquipoOE)OE).getPersona().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
	    parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((EquipoOE)OE).getPersona().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
	    parametros.add(new SentenciaParametroDAO("p_observaciones", ((EquipoOE)OE).getPersona().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
                  
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);  
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{     
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	    
		parametros.add(new SentenciaParametroDAO("p_id_equipo_persona", ((EquipoOE)OE).getPersona().getIdEquipoPersona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	
	

}
