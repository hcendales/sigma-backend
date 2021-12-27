package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.ProgramacionDiariaOE;
import co.gov.umv.sigma.backend.intervencion.dao.impl.GestionProgramacionDiariaDAO;
import co.gov.umv.sigma.backend.intervencion.dao.impl.ProgramacionDiariaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class ProgramacionDiariaDTO implements ICrudDTO
{
	ICrudDAO modelo = new ProgramacionDiariaDAO();
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE)
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		((ProgramacionDiariaOE)OE).getProgDiaria().setIdProgramacionDiaria(0L);
		return dao.gestionarProgDiaria(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE)
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		return dao.gestionarProgDiaria(OE);
	}
	
	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE)
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		return dao.eliminarProgDiaria(OE);
	}
	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE)
	{
		return modelo.consultarXFiltro(OE);
	}

	public ObjetoSalida listarProgramacionDiarias(ProgramacionDiariaOE OE) 
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		return dao.listarProgramacionesDiarias(OE);
	}

	public ObjetoSalida copiarProgDiaria(ObjetoEntrada OE) 
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		return dao.copiarProgDiaria(OE);
	}
	
	public ObjetoSalida consultarUE(ObjetoEntrada OE) 
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		return dao.consultarUE(OE);
	}

}