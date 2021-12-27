package co.gov.umv.sigma.backend.intervencion.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.intervencion.cbo.ProgramacionDiariaOE;
import co.gov.umv.sigma.backend.intervencion.dao.impl.GestionProgramacionDiariaDAO;
import co.gov.umv.sigma.backend.intervencion.dao.impl.ProgDiariaPersonalDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class ProgDiariaPersonalDTO implements ICrudDTO
{
	ICrudDAO modelo = new ProgDiariaPersonalDAO();
	
	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE)
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		((ProgramacionDiariaOE)OE).getPersonal().setIdProgdiariaPersonal(0L);
		return dao.gestionarPersonal(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE)
	{
		GestionProgramacionDiariaDAO dao = new GestionProgramacionDiariaDAO();
		return dao.gestionarPersonal(OE);
	}
	
	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE)
	{
		return modelo.eliminar(OE);
	}
	
	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE)
	{
		return modelo.consultarXFiltro(OE);
	}


}