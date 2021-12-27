package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.cbo.ApiqueOE;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.ApiqueDAO;
import co.gov.umv.sigma.backend.mejoramiento.dto.ICrudDTO;

public class ApiqueDTO implements ICrudDTO
{
	ICrudDAO modelo = new ApiqueDAO();
	
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
	
	public ObjetoSalida consultarIdMantenimientoVialEvento(ApiqueOE OE)
	{
		String filtro = "ID_MANTENIMIENTO_VIAL_EVENTO = " + OE.getApique().getMantenimientoVialEvento().getIdMantenimientoVialEvento();
		OE.setFiltro(filtro);
		return modelo.consultarXFiltro(OE);
	}
}
