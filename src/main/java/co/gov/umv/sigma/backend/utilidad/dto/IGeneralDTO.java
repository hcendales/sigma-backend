package co.gov.umv.sigma.backend.utilidad.dto;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.utilidad.cbo.ListaOE;

public interface IGeneralDTO {
	public ObjetoSalida listar(ListaOE OE);
	public ObjetoSalida listarDominio(ListaOE OE);
}
