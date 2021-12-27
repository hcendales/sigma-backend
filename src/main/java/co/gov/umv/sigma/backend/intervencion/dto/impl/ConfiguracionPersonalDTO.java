package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.dao.impl.ConfiguracionPersonalDAO;

public class ConfiguracionPersonalDTO {

	ConfiguracionPersonalDAO dao = new ConfiguracionPersonalDAO();
	
	public ObjetoSalida listarResidentes(ObjetoEntrada OE) {
		return dao.listarResidentes(OE);
	}

	public ObjetoSalida listarDirectoresApoyo(ObjetoEntrada OE) {
		return dao.listarDirectoresApoyo(OE);
	}

}
