package co.gov.umv.sigma.backend.seguridad.dto;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public interface ITokenDTO {
	public ObjetoSalida generarToken(UMVPersonLogin OE);
	
}
