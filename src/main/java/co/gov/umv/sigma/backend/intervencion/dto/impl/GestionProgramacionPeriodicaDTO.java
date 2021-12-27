package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.IntervencionOE;
import co.gov.umv.sigma.backend.intervencion.dao.impl.GestionProgramacionPeriodicaDAO;

public class GestionProgramacionPeriodicaDTO
{

	GestionProgramacionPeriodicaDAO dao = new GestionProgramacionPeriodicaDAO();
	
	

	public ObjetoSalida adicionarPKProgramacionPeriodica(IntervencionOE OE) {
		return dao.adicionarPKProgramacionPeriodica(OE);
	}
	
	public ObjetoSalida removerPKProgramacionPeriodica(IntervencionOE OE) {
		return dao.removerPKProgramacionPeriodica(OE);
	}

	public ObjetoSalida consultarProgramacionPeriodicaActiva(ObjetoEntrada OE) {
		return dao.consultarProgramacionPeriodicaActiva(OE);
	}

	public ObjetoSalida eliminarProgramacionPeriodica(IntervencionOE OE) {
		return dao.eliminarProgramacionPeriodica(OE);
	}

	public ObjetoSalida consultarPKProgramacionPeriodica(ObjetoEntrada OE) {
		return dao.consultarPKProgramacionPeriodica(OE);
	}

	public ObjetoSalida insertarProgPeriodica(IntervencionOE OE) {
		return dao.insertarProgPeriodica(OE);
	}

	public ObjetoSalida listarPkParaAsociar(IntervencionOE OE) {
		return dao.listarPkParaAsociar(OE);
	}

	public ObjetoSalida filtrarVigenciasProgramacion(ObjetoEntrada OE) {
		return dao.filtrarVigenciasProgramacion(OE);
	}

	public ObjetoSalida actualizarArchivoProgramacionPeriodica(IntervencionOE OE) 
	{
		return dao.actualizarArchivoProgramacionPeriodica(OE);
	}

}
