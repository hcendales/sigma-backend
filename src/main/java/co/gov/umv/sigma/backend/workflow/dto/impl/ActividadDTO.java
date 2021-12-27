package co.gov.umv.sigma.backend.workflow.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.workflow.cbo.ActividadOE;
import co.gov.umv.sigma.backend.workflow.dao.IActividadDAO;
import co.gov.umv.sigma.backend.workflow.dao.impl.ActividadDAO;
import co.gov.umv.sigma.backend.workflow.dto.IActividadDTO;

public class ActividadDTO implements IActividadDTO {

	@Override
	public ObjetoSalida insertar(ActividadOE OE) {
		IActividadDAO actividad = new ActividadDAO();		
		return actividad.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(ActividadOE OE) {
		IActividadDAO actividad = new ActividadDAO();		
		return actividad.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(ActividadOE OE) {
		IActividadDAO actividad = new ActividadDAO();		
		return actividad.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ActividadOE OE) {
		IActividadDAO modelo = new ActividadDAO();
		return modelo.consultarXFiltro(OE);
	}

}
