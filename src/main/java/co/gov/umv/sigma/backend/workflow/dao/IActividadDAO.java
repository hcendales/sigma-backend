package co.gov.umv.sigma.backend.workflow.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.workflow.cbo.ActividadOE;

public interface IActividadDAO {
	public ObjetoSalida insertar(ActividadOE OE);
	public ObjetoSalida actualizar(ActividadOE OE);
	public ObjetoSalida eliminar(ActividadOE OE);
	public ObjetoSalida consultarXFiltro(ActividadOE OE);
}
