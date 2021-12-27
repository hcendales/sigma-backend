package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ServicioOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IServicioDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.ServicioDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IServicioDTO;

public class ServicioDTO implements IServicioDTO {

	@Override
	public ObjetoSalida consultarRadicadoOrfeo(ServicioOE OE) {
		IServicioDAO dao = new ServicioDAO();
		return dao.consultarRadicadoOrfeo(OE);
	}

}
