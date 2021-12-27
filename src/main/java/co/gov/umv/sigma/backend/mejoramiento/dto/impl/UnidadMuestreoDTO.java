package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.UnidadMuestreoOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.IUnidadMuestreoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.UnidadMuestreoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.IUnidadMuestreoDTO;

public class UnidadMuestreoDTO implements IUnidadMuestreoDTO {

	@Override
	public ObjetoSalida insertar(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida consultarIdMantenimiento(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		String filtro = "id_mantenimiento_vial_evento = " + OE.getUnidadMuestreo().getIdMantenimientoVialEvento().getIdMantenimientoVialEvento();
		OE.setFiltro(filtro);
		return modelo.consultarXFiltro(OE);
	}

	@Override
	public ObjetoSalida actualizarPCI(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		return modelo.actualizarPCI(OE);
	}

	@Override
	public ObjetoSalida actualizarCampo(UnidadMuestreoOE OE) {
		IUnidadMuestreoDAO modelo = new UnidadMuestreoDAO();
		return modelo.actualizarCampo(OE);
	}

}
