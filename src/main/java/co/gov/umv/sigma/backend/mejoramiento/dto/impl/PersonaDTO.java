package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.PersonaDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class PersonaDTO implements ICrudDTO {

	ICrudDAO modeloDao = new PersonaDAO();

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) 
	{
		return modeloDao.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE)
	{
		return modeloDao.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) 
	{
		return modeloDao.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE)
	{
		return modeloDao.consultarXFiltro(OE);
	}

}
