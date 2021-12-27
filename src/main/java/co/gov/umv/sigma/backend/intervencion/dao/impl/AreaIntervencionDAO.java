package co.gov.umv.sigma.backend.intervencion.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.SentenciaParametroDAO;
import co.gov.umv.sigma.backend.comun.dao.SentenciaTipoParametroDAO;
import co.gov.umv.sigma.backend.intervencion.cbo.AreaIntervencionOE;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AlternativaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;
import oracle.jdbc.OracleTypes;

public class AreaIntervencionDAO extends CrudDAO implements ICrudDAO {

	private final static String PACKAGE = "pkg_area_intervencion";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_elemento", ((AreaIntervencionOE)OE).getAreaIntervencion().getElemento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		Double Longitud = (((AreaIntervencionOE)OE).getAreaIntervencion().getLongitud() == null) ? null : ((AreaIntervencionOE)OE).getAreaIntervencion().getLongitud().doubleValue();
		parametros.add(new SentenciaParametroDAO("p_longitud", Longitud, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		Double Ancho = (((AreaIntervencionOE)OE).getAreaIntervencion().getAncho() == null) ? null : ((AreaIntervencionOE)OE).getAreaIntervencion().getAncho().doubleValue();
		parametros.add(new SentenciaParametroDAO("p_ancho", Ancho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		Double Area = (((AreaIntervencionOE)OE).getAreaIntervencion().getArea() == null) ? null : ((AreaIntervencionOE)OE).getAreaIntervencion().getArea().doubleValue();
		parametros.add(new SentenciaParametroDAO("p_area", Area, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		
		return ejecutar(OE, PACKAGE+".prc_insertar", parametros);	
	}
	
	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) 
	{ 
		List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_area_intervencion", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdAreaIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_mantenimiento_vial_evento", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_elemento", ((AreaIntervencionOE)OE).getAreaIntervencion().getElemento(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_superficie", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdTipoSuperficie(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		Double Longitud = (((AreaIntervencionOE)OE).getAreaIntervencion().getLongitud() == null) ? null : ((AreaIntervencionOE)OE).getAreaIntervencion().getLongitud().doubleValue();
		parametros.add(new SentenciaParametroDAO("p_longitud", Longitud, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		Double Ancho = (((AreaIntervencionOE)OE).getAreaIntervencion().getAncho() == null) ? null : ((AreaIntervencionOE)OE).getAreaIntervencion().getAncho().doubleValue();
		parametros.add(new SentenciaParametroDAO("p_ancho", Ancho, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		Double Area = (((AreaIntervencionOE)OE).getAreaIntervencion().getArea() == null) ? null : ((AreaIntervencionOE)OE).getAreaIntervencion().getArea().doubleValue();
		parametros.add(new SentenciaParametroDAO("p_area", Area, SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		parametros.add(new SentenciaParametroDAO("p_id_tipo_intervencion", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdTipoIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
		return ejecutar(OE, PACKAGE+".prc_actualizar", parametros);
	}


	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{ 
        List<SentenciaParametroDAO> parametros = new ArrayList<SentenciaParametroDAO>();
		parametros.add(new SentenciaParametroDAO("p_id_area_intervencion", ((AreaIntervencionOE)OE).getAreaIntervencion().getIdAreaIntervencion(), SentenciaTipoParametroDAO.ENTRADA, OracleTypes.NUMBER));
        return ejecutar(OE, PACKAGE+".prc_eliminar", parametros);
	}

	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) 
	{ 
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}

}
