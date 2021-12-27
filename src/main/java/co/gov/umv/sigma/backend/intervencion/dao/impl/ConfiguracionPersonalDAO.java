package co.gov.umv.sigma.backend.intervencion.dao.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.CrudDAO;

public class ConfiguracionPersonalDAO extends CrudDAO {

	private final static String PACKAGE = "PKG_CONF_PERSONAL_INTERVENCION";
	
	
	public ObjetoSalida listarResidentes(ObjetoEntrada OE) {
		return consultaXFiltro(OE, PACKAGE+".prc_ListarResidentes");
	}

	public ObjetoSalida listarDirectoresApoyo(ObjetoEntrada OE) {
		return consultaXFiltro(OE, PACKAGE+".prc_ListarDirectoresApoyo");
	}

}
