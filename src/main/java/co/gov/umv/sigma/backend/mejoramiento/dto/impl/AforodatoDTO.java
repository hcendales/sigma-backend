package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.AforoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IAforoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.AforoDatoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IAforoDTO;

public class AforodatoDTO implements IAforoDTO {
	IAforoDAO modeloDetalle = new AforoDatoDAO();
	
	@Override
	public ObjetoSalida nuevoAforo(AforoOE OE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetoSalida insertar(AforoOE OE) {
		return modeloDetalle.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(AforoOE OE) {
		return modeloDetalle.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(AforoOE OE) {
		return modeloDetalle.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(AforoOE OE) {
		return modeloDetalle.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida analisisAforo(AforoOE OE) {
		// TODO Auto-generated method stub
		return null;
	}

}
