package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.dao.impl.InformacionDiariaCuadrillaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class InformacionDiariaCuadrillaDTO implements ICrudDTO {
	ICrudDAO modelo = new InformacionDiariaCuadrillaDAO();
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return modelo.consultarXFiltro(OE);
	}

}
