package co.gov.umv.sigma.backend.comun.entidad;

public class TabEnsayoResultado 
{
	private Long idEnsayoResultado;
	private Long idEnsayo;
	private String numeroRadicado;
	private String asunto;
	private String idTipoResultado;
	private String descarga;
	
	public Long getIdEnsayoResultado() {
		return idEnsayoResultado;
	}
	public void setIdEnsayoResultado(Long idEnsayoResultado) {
		this.idEnsayoResultado = idEnsayoResultado;
	}
	public Long getIdEnsayo() {
		return idEnsayo;
	}
	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	public String getNumeroRadicado() {
		return numeroRadicado;
	}
	public void setNumeroRadicado(String numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getIdTipoResultado() {
		return idTipoResultado;
	}
	public void setIdTipoResultado(String idTipoResultado) {
		this.idTipoResultado = idTipoResultado;
	}
	public String getDescarga() {
		return descarga;
	}
	public void setDescarga(String descarga) {
		this.descarga = descarga;
	}
	
	
	
}
