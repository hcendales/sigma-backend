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

public class ZonaCoberturaEquipoDAO extends CrudDAO  implements ICrudDAO
{

	private final static String PACKAGE = "PKG_ZONACOBERTURA_EQUIPO";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		
		parametros.add(new SentenciaParametroDAO("p_id_tipo_zonacobertura", ((IntervencionOE)OE).getZonaCoberturaEquipo().getIdTipoZonaCobertura(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_equipo", ((IntervencionOE)OE).getZonaCoberturaEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((IntervencionOE)OE).getZonaCoberturaEquipo().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((IntervencionOE)OE).getZonaCoberturaEquipo().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
					
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
	
		parametros.add(new SentenciaParametroDAO("p_id_zonacobertura_equipo", ((IntervencionOE)OE).getZonaCoberturaEquipo().getIdZonaCoberturaEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_zonacobertura", ((IntervencionOE)OE).getZonaCoberturaEquipo().getIdTipoZonaCobertura(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_equipo", ((IntervencionOE)OE).getZonaCoberturaEquipo().getIdEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_fecha_desde", obtenerFecha( ((IntervencionOE)OE).getZonaCoberturaEquipo().getFechaDesde()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		parametros.add(new SentenciaParametroDAO("p_fecha_hasta", obtenerFecha( ((IntervencionOE)OE).getZonaCoberturaEquipo().getFechaHasta()), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
		
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
    	
    	parametros.add(new SentenciaParametroDAO("p_id_zonacobertura_equipo", ((IntervencionOE)OE).getZonaCoberturaEquipo().getIdZonaCoberturaEquipo(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
    					
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}
