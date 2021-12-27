package co.gov.umv.sigma.backend.administracion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabUsuario;

public class UsuarioOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = -255769089958409306L;
	private TabUsuario user;
	
	public TabUsuario getUser() {
		return user;
	}
	public void setUser(TabUsuario user) {
		this.user = user;
	}
}
