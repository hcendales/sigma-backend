package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.SolicitudPMTOE;
import co.gov.umv.sigma.backend.intervencion.dao.impl.GestionPMTDAO;

public class GestionPMTDTO
{

	GestionPMTDAO dao = new GestionPMTDAO();
	
	public ObjetoSalida asociarSolicitud(SolicitudPMTOE OE)
	{
		return dao.asociarSolicitud(OE);
	}
	
	public ObjetoSalida registrarRespuesta(SolicitudPMTOE OE)
	{
		return dao.registrarRespuesta(OE);
	}

	public ObjetoSalida consultarRadicados(SolicitudPMTOE OE) {
		return dao.consultarRadicados(OE);
	}

	public ObjetoSalida consultaArchivoCOI(SolicitudPMTOE OE) {
		return dao.consultaArchivoCOI(OE);
	}

	public ObjetoSalida desasociarRadicado(SolicitudPMTOE OE) {
		return dao.desasociarRadicado(OE);
	}

	

}
