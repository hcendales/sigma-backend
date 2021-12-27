package co.gov.umv.sigma.backend.comun.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.comun.dao.DocumentoMVDAO;
import co.gov.umv.sigma.backend.workflow.cbo.DocumentoOE;
public class DocumentoMVDTO {

	DocumentoMVDAO dao = new DocumentoMVDAO();
	
	public ObjetoSalida nuevaVersion(DocumentoOE OE) {
		return dao.nuevaVersion(OE);
	}

	public ObjetoSalida listarXTipo(DocumentoOE OE) {
		return dao.listarXTipo(OE);
	}

	

}
