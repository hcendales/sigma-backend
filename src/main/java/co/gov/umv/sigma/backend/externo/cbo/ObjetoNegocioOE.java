package co.gov.umv.sigma.backend.externo.cbo;

import java.util.HashMap;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class ObjetoNegocioOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3195746828605238594L;

	private String url;
	
	private String json;
	
	private HashMap<String, Object> objeto;
	
	private String password;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HashMap<String, Object> getObjeto() {
		return objeto;
	}

	public void setObjeto(HashMap<String, Object> objeto) {
		this.objeto = objeto;
	}
}
