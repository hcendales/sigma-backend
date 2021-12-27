package co.gov.umv.sigma.backend.workflow.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;
import co.gov.umv.sigma.backend.workflow.dao.IDocumentoDAO;
import co.gov.umv.sigma.backend.workflow.dao.impl.DocumentoDAO;
import co.gov.umv.sigma.backend.workflow.dto.IDocumentoDTO;

public class DocumentoDTO implements IDocumentoDTO {

	@Override
	public ObjetoSalida insertar(DocumentoOE OE) {
		IDocumentoDAO modelo = new DocumentoDAO();
		return modelo.insertar(OE);
	}

	@Override
	public ObjetoSalida actualizar(DocumentoOE OE) {
		IDocumentoDAO modelo = new DocumentoDAO();
		return modelo.actualizar(OE);
	}

	@Override
	public ObjetoSalida eliminar(DocumentoOE OE) {
		IDocumentoDAO modelo = new DocumentoDAO();
		return modelo.eliminar(OE);
	}

	@Override
	public ObjetoSalida consultarXFiltro(DocumentoOE OE) {
		IDocumentoDAO modelo = new DocumentoDAO();
		return modelo.consultarXFiltro(OE);
	}

}
