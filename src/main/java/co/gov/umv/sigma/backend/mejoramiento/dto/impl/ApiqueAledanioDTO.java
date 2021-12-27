package co.gov.umv.sigma.backend.mejoramiento.dto.impl;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;
import co.gov.umv.sigma.backend.mejoramiento.dao.impl.ApiquesAledanioDAO;

public class ApiqueAledanioDTO {

	public ObjetoSalida registrarApiqueAledanio(ObjetoEntrada OE)
	{
		ApiquesAledanioDAO dao = new ApiquesAledanioDAO();
		return dao.registrarAledanio(OE);
	}
	
}
