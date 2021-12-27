package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialDocuOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IMantenimientoVialDocuDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.MantenimientoVialDocuDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IMantenimientoVialDocuDTO;

public class MantenimientoVialDocuDTO implements IMantenimientoVialDocuDTO {

	@Override
	public ObjetoSalida insertar(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDAO modelo = new MantenimientoVialDocuDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDAO modelo = new MantenimientoVialDocuDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDAO modelo = new MantenimientoVialDocuDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(MantenimientoVialDocuOE OE) {
		IMantenimientoVialDocuDAO modelo = new MantenimientoVialDocuDAO();
		return modelo.consultarXFiltro(OE);
	}

}
