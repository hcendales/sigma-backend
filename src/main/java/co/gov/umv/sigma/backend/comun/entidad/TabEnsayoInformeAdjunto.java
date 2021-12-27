package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabEnsayoInformeAdjunto {

	private Long 	idEnsayoInformeAdjunto;
	private Long 	idEnsayoInforme;
	private Date 	fechaRadicado;
	private Date 	fechaCargue;
	private String 	numeroRadicado;
	private String 	asunto;
	private String 	descarga;
	public Long getIdEnsayoInformeAdjunto() {
		return idEnsayoInformeAdjunto;
	}
	public void setIdEnsayoInformeAdjunto(Long idEnsayoInformeAdjunto) {
		this.idEnsayoInformeAdjunto = idEnsayoInformeAdjunto;
	}
	public Long getIdEnsayoInforme() {
		return idEnsayoInforme;
	}
	public void setIdEnsayoInforme(Long idEnsayoInforme) {
		this.idEnsayoInforme = idEnsayoInforme;
	}
	public Date getFechaRadicado() {
		return fechaRadicado;
	}
	public void setFechaRadicado(Date fechaRadicado) {
		this.fechaRadicado = fechaRadicado;
	}
	public Date getFechaCargue() {
		return fechaCargue;
	}
	public void setFechaCargue(Date fechaCargue) {
		this.fechaCargue = fechaCargue;
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
	public String getDescarga() {
		return descarga;
	}
	public void setDescarga(String descarga) {
		this.descarga = descarga;
	}
	
	
	
}
