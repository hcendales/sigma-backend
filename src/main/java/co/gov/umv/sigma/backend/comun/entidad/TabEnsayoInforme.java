package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabEnsayoInforme 
{
	private Long 	idEnsayoinforme;
	private Long 	idEnsayo;
	private String 	idTipoResultado;
	private Date 	fechaEjecucion;
	private Date 	fechaResultado;
	private String 	idUsuarioLaboratorio;
	private String 	observaciones;
	private String 	nombreEnsayo;
	private Long 	idDocumentoInforme;
	private String 	novedades;
	private Date 	fechaProgramacion;
	private Date 	fechaRadicado;
	private String 	numeroRadicado;
	private String 	asunto;
	private Long    idTipoDocumento;
	private Date 	fechaEnvio;
	
	public Long getIdEnsayoinforme() {
		return idEnsayoinforme;
	}
	public void setIdEnsayoinforme(Long idEnsayoinforme) {
		this.idEnsayoinforme = idEnsayoinforme;
	}
	public Long getIdEnsayo() {
		return idEnsayo;
	}
	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	public String getIdTipoResultado() {
		return idTipoResultado;
	}
	public void setIdTipoResultado(String idTipoResultado) {
		this.idTipoResultado = idTipoResultado;
	}
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
	public Date getFechaResultado() {
		return fechaResultado;
	}
	public void setFechaResultado(Date fechaResultado) {
		this.fechaResultado = fechaResultado;
	}
	public String getIdUsuarioLaboratorio() {
		return idUsuarioLaboratorio;
	}
	public void setIdUsuarioLaboratorio(String idUsuarioLaboratorio) {
		this.idUsuarioLaboratorio = idUsuarioLaboratorio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getNombreEnsayo() {
		return nombreEnsayo;
	}
	public void setNombreEnsayo(String nombreEnsayo) {
		this.nombreEnsayo = nombreEnsayo;
	}
	public Long getIdDocumentoInforme() {
		return idDocumentoInforme;
	}
	public void setIdDocumentoInforme(Long idDocumentoInforme) {
		this.idDocumentoInforme = idDocumentoInforme;
	}
	public String getNovedades() {
		return novedades;
	}
	public void setNovedades(String novedades) {
		this.novedades = novedades;
	}
	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
	public Date getFechaRadicado() {
		return fechaRadicado;
	}
	public void setFechaRadicado(Date fechaRadicado) {
		this.fechaRadicado = fechaRadicado;
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
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
	
	
}
