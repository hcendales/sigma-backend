package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IAforoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.AforoCalzadaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IAforoDTO;

public class AforocalzadaDTO implements IAforoDTO {
	IAforoDAO modelo = new AforoCalzadaDAO();
	@Override
	public ObjetoSalida nuevoAforo(AforoOE OE) {
		return null;
	}

	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(AforoOE OE) {
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(AforoOE OE) {
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(AforoOE OE) {
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida analisisAforo(AforoOE OE) {
		// TODO Auto-generated method stub
		return null;
	}

}
