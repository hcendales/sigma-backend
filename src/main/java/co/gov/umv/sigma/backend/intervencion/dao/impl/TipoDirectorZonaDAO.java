package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class TipoDirectorZonaDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "PKG_TIPO_DIRECTOR_ZONA";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_zonacobertura", ((IntervencionOE)OE).getDirectorZona().getIdTipoZonacobertura(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_director", ((IntervencionOE)OE).getDirectorZona().getIdPersonaDirector(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo", ((IntervencionOE)OE).getDirectorZona().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_rol", ((IntervencionOE)OE).getDirectorZona().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((IntervencionOE)OE).getDirectorZona().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((IntervencionOE)OE).getDirectorZona().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_tipo_director_zona", ((IntervencionOE)OE).getDirectorZona().getIdTipoDirectorZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_zonacobertura", ((IntervencionOE)OE).getDirectorZona().getIdTipoZonacobertura(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_persona_director", ((IntervencionOE)OE).getDirectorZona().getIdPersonaDirector(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_cargo", ((IntervencionOE)OE).getDirectorZona().getIdTipoCargo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_rol", ((IntervencionOE)OE).getDirectorZona().getIdTipoRol(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((IntervencionOE)OE).getDirectorZona().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((IntervencionOE)OE).getDirectorZona().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
    	parametros.add(new SentenciaParametroDAO("p_id_tipo_director_zona", ((IntervencionOE)OE).getDirectorZona().getIdTipoDirectorZona(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    		
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

}
