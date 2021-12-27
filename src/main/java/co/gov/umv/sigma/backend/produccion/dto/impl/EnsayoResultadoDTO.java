package co.gov.umv.sigma.backend.produccion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;
import co.gov.umv.sigma.backend.produccion.dao.impl.EnsayoDetalleDAO;
import co.gov.umv.sigma.backend.produccion.dao.impl.EnsayoResultadoDAO;

public class EnsayoResultadoDTO  implements ICrudDTO
{

	ICrudDAO modelo = new EnsayoResultadoDAO();
	
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) {
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) {
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE) {
		return modelo.consultarXFiltro(OE);
	}

}



