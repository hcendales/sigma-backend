package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.OtroFactorOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IOtroFactorDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.OtroFactorDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IOtroFactorDTO;

public class OtroFactorDTO implements IOtroFactorDTO {

	@Override
	public ObjetoSalida insertar(OtroFactorOE OE) {
		IOtroFactorDAO modelo = new OtroFactorDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(OtroFactorOE OE) {
		IOtroFactorDAO modelo = new OtroFactorDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(OtroFactorOE OE) {
		IOtroFactorDAO modelo = new OtroFactorDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(OtroFactorOE OE) {
		IOtroFactorDAO modelo = new OtroFactorDAO();
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida consultarIdMantenimiento(OtroFactorOE OE) {
		IOtroFactorDAO modelo = new OtroFactorDAO();
		String filtro = "id_mantenimiento_vial_evento = " + OE.getOtroFactor().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento();
		OE.setFiltro(filtro);
		return modelo.consultarXFiltro(OE);
	}

}
