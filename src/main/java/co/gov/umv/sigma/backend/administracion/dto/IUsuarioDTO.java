package co.gov.umv.sigma.backend.administracion.dto;

import co.gov.umv.sigma.backend.administracion.cbo.UMVPersonLogin;
import co.gov.umv.sigma.backend.administracion.cbo.UsuarioOE;
import co.gov.umv.sigma.backend.comun.cbo.ObjetoSalida;

public interface IUsuarioDTO {
	public ObjetoSalida login(UMVPersonLogin OE);
	public ObjetoSalida insertar(UsuarioOE OE);
	public ObjetoSalida actualizar(UsuarioOE OE);
	public ObjetoSalida borrar(UsuarioOE OE);
	public ObjetoSalida consultarXFiltro(UsuarioOE OE);
}
