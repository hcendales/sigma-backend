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

public class NovedadDAO  extends CrudDAO implements ICrudDAO
{
	private final static String PACKAGE = "PKG_RECURSO_NOVEDAD";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getNovedad().getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_novedad", ((RecursoOE)OE).getNovedad().getIdTipoNovedad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_hora_desde", obtenerFecha( ((RecursoOE)OE).getNovedad().getHoraDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_hora_hasta", obtenerFecha( ((RecursoOE)OE).getNovedad().getHoraHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_observaciones", ((RecursoOE)OE).getNovedad().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        return ejecutar(OE, PACKAGE+".prc_insertar", parametros);
     }
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso_novedad", ((RecursoOE)OE).getNovedad().getIdRecursoNovedad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_recurso", ((RecursoOE)OE).getNovedad().getRecurso().getIdRecurso(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_id_tipo_novedad", ((RecursoOE)OE).getNovedad().getIdTipoNovedad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        parametros.add(new SentenciaParametroDAO("p_hora_desde", obtenerFecha( ((RecursoOE)OE).getNovedad().getHoraDesde() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_hora_hasta", obtenerFecha( ((RecursoOE)OE).getNovedad().getHoraHasta() ), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.DATE));
        parametros.add(new SentenciaParametroDAO("p_observaciones", ((RecursoOE)OE).getNovedad().getObservaciones(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.VARCHAR));
        return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
    }


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
	    List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
        parametros.add(new SentenciaParametroDAO("p_id_recurso_novedad", ((RecursoOE)OE).getNovedad().getIdRecursoNovedad(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

}





