package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.FranjaHorariaOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.FranjasHorariasDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.RecursoDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class RecursoDTO implements ICrudDTO
{
	ICrudDAO modelo = new RecursoDAO();

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE)
	{
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE)
	{
		return modelo.actualizar(OE);
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
	
	public ObjetoSalida generarFranjas(FranjaHorariaOE OE)
	{
		FranjasHorariasDAO dao = new FranjasHorariasDAO();
		return dao.generarFranjas(OE);
	}
	
	public ObjetoSalida eliminarFranjas(FranjaHorariaOE OE)
	{
		FranjasHorariasDAO dao = new FranjasHorariasDAO();
		return dao.eliminarFranjas(OE);
	}
	
	public ObjetoSalida consultarFranjas(FranjaHorariaOE OE)
	{
		FranjasHorariasDAO dao = new FranjasHorariasDAO();
		return dao.consultarFranjas(OE);
	}

	
}
