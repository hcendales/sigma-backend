package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dao.impl.TipoPeriodoProgramacionDAO;

public class TipoPeriodoProgramacionDTO {

	public ObjetoSalida consultarPeriodoProgramacion(IntervencionOE OE) 
	{
		TipoPeriodoProgramacionDAO dao = new TipoPeriodoProgramacionDAO();
		
		OE.setFiltro(" vigencia = " + OE.getVigencia() + " and id_tipo_periodicidad = " + OE.getIdPeriodicidad());
		
		return dao.consultarXFiltro(OE);
	}



}
