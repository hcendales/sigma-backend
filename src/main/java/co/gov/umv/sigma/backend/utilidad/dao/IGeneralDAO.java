package co.gov.umv.sigma.backend.utilidad.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.utilidad.cbo.ListaOE;

public interface IGeneralDAO {
	public ObjetoSalida listar(ListaOE OE);
	public ObjetoSalida listarDominio(ListaOE OE);
}
