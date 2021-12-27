package co.gov.umv.sigma.backend.administracion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class UMVPersonLogin extends ObjetoEntrada{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8262971306426802317L;
	private String username;
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
