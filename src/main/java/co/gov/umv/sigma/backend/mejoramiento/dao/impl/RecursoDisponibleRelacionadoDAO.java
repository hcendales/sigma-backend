package co.gov.umv.sigma.backend.mejoramiento.dao.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dao.ICrudDAO;

public class RecursoDisponibleRelacionadoDAO extends CrudDAO  implements ICrudDAO
{
	private final static String PACKAGE = "PKG_RECURSO_DISPONIBILIDAD_RELACION";

	@Override
	public ObjetoSalida insertar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetoSalida actualizar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetoSalida eliminar(ObjetoEntrada OE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetoSalida consultarXFiltro(ObjetoEntrada OE)
	{
		return consultaXFiltro(OE, PACKAGE+".prc_consultarporfiltro");
	}
	

	
	

}
