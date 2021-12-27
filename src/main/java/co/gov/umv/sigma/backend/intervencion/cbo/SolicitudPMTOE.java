package co.gov.umv.sigma.backend.intervencion.cbo;

import java.util.Date;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class SolicitudPMTOE extends ObjetoEntrada {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idTipoPMT;
    private String coi;
    private Long idTipoEstadoPMT;
    private String numeroRadicadoUMV;
    private Date fechaRadicadoUMV;
    private String numeroRadicadoRta;
    private Date fechaRadicadoRta;
    private Long idArchivoCoi;
    private String observaciones;
    private String idMantenimientoVial;
    private Long idDocumento;
    
    
    private Long idRadicado;
    private String tipoRadicado;
    private String radicado;
    
	public Long getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}
	public Long getIdTipoPMT() {
		return idTipoPMT;
	}
	public void setIdTipoPMT(Long idTipoPMT) {
		this.idTipoPMT = idTipoPMT;
	}
	public String getCoi() {
		return coi;
	}
	public void setCoi(String coi) {
		this.coi = coi;
	}
	public Long getIdTipoEstadoPMT() {
		return idTipoEstadoPMT;
	}
	public void setIdTipoEstadoPMT(Long idTipoEstadoPMT) {
		this.idTipoEstadoPMT = idTipoEstadoPMT;
	}
	public String getNumeroRadicadoUMV() {
		return numeroRadicadoUMV;
	}
	public void setNumeroRadicadoUMV(String numeroRadicadoUMV) {
		this.numeroRadicadoUMV = numeroRadicadoUMV;
	}
	public Date getFechaRadicadoUMV() {
		return fechaRadicadoUMV;
	}
	public void setFechaRadicadoUMV(Date fechaRadicadoUMV) {
		this.fechaRadicadoUMV = fechaRadicadoUMV;
	}
	public String getNumeroRadicadoRta() {
		return numeroRadicadoRta;
	}
	public void setNumeroRadicadoRta(String numeroRadicadoRta) {
		this.numeroRadicadoRta = numeroRadicadoRta;
	}
	public Date getFechaRadicadoRta() {
		return fechaRadicadoRta;
	}
	public void setFechaRadicadoRta(Date fechaRadicadoRta) {
		this.fechaRadicadoRta = fechaRadicadoRta;
	}
	public Long getIdArchivoCoi() {
		return idArchivoCoi;
	}
	public void setIdArchivoCoi(Long idArchivoCoi) {
		this.idArchivoCoi = idArchivoCoi;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getIdMantenimientoVial() {
		return idMantenimientoVial;
	}
	public void setIdMantenimientoVial(String idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}
	public Long getIdRadicado() {
		return idRadicado;
	}
	public void setIdRadicado(Long idRadicado) {
		this.idRadicado = idRadicado;
	}
	public String getRadicado() {
		return radicado;
	}
	public void setRadicado(String radicado) {
		this.radicado = radicado;
	}
	public String getTipoRadicado() {
		return tipoRadicado;
	}
	public void setTipoRadicado(String tipoRadicado) {
		this.tipoRadicado = tipoRadicado;
	}
    
	
	
    
}
