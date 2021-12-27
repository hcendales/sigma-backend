package co.gov.umv.sigma.backend.utilidad.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.utilidad.cbo.ListaOE;
import co.gov.umv.sigma.backend.utilidad.dao.IGeneralDAO;
import co.gov.umv.sigma.backend.utilidad.dao.impl.GeneralDAO;
import co.gov.umv.sigma.backend.utilidad.dto.IGeneralDTO;

public class GeneralDTO implements IGeneralDTO {

	@Override
	public ObjetoSalida listar(ListaOE OE) {
		IGeneralDAO modelo = new GeneralDAO(); 
		return modelo.listar(OE);
	}

	@Override
	public ObjetoSalida listarDominio(ListaOE OE) {
		IGeneralDAO modelo = new GeneralDAO(); 
		return modelo.listarDominio(OE);
	}

}
