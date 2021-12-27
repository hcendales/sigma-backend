package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.VisitaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.VisitaDAO;

public class VisitaDTO {

	VisitaDAO modelo = new VisitaDAO();
	
	public ObjetoSalida desasignarVisitaVehiculo(VisitaOE OE) {
		return modelo.desasignarVisitaVehiculo(OE);
	}

	public ObjetoSalida consultarVisitaVehiculo(VisitaOE OE) {
		return modelo.consultarVisitaVehiculo(OE);
	}

	public ObjetoSalida asignarVisitaVehiculo(VisitaOE OE) {
		return modelo.asignarVisitaVehiculo(OE);
	}

	public ObjetoSalida consultarDisponibilidadAsignada(VisitaOE OE) {
		return modelo.consultarDisponibilidadAsignada(OE);
	}

	public ObjetoSalida consultarVisitaProgramada(VisitaOE OE) {
		return modelo.consultarVisitaProgramada(OE);
	}

}
