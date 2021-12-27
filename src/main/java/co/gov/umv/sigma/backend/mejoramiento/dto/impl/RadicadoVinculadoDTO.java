package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.RadicadoVinculadoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IRadicadoVinculadoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.RadicadoVinculadoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IRadicadoVinculadoDTO;

public class RadicadoVinculadoDTO implements IRadicadoVinculadoDTO {

	@Override
	public ObjetoSalida insertar(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDAO modelo = new RadicadoVinculadoDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDAO modelo = new RadicadoVinculadoDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDAO modelo = new RadicadoVinculadoDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(RadicadoVinculadoOE OE) {
		IRadicadoVinculadoDAO modelo = new RadicadoVinculadoDAO();
		return modelo.consultarXFiltro(OE);
	}

}
