package co.gov.umv.sigma.backend.workflow.dao;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;

public interface IDocumentoDAO {
	public ObjetoSalida insertar(DocumentoOE OE);
	public ObjetoSalida actualizar(DocumentoOE OE);
	public ObjetoSalida eliminar(DocumentoOE OE);
	public ObjetoSalida consultarXFiltro(DocumentoOE OE);
	
}
