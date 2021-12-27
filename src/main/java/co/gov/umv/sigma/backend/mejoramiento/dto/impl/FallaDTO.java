package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FallaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IFallaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.FallaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IFallaDTO;

public class FallaDTO implements IFallaDTO {

	@Override
	public ObjetoSalida insertar(FallaOE OE) {
		IFallaDAO modelo = new FallaDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(FallaOE OE) {
		IFallaDAO modelo = new FallaDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(FallaOE OE) {
		IFallaDAO modelo = new FallaDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(FallaOE OE) {
		IFallaDAO modelo = new FallaDAO();
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida consultarIdUnidadMuestreo(FallaOE OE) {
		IFallaDAO modelo = new FallaDAO();
		String filtro = "id_unidad_muestreo = " + OE.getFalla().getIdUnidadMuestreo().getIdUnidadMuestreo();
		OE.setFiltro(filtro);
		return modelo.consultarXFiltro(OE);
	}

}
