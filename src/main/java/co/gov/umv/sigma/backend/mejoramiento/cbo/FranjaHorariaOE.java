package co.gov.umv.sigma.backend.mejoramiento.cbo;

import java.util.Date;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class FranjaHorariaOE extends ObjetoEntrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idRecurso ;
	private Date fechaDesde ;
	private Date fechaHasta;
	private Integer intervalo;
    private Integer tipoRecurso;
    private String horaInicio;
    private String horaFin;
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Integer getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	public Integer getTipoRecurso() {
		return tipoRecurso;
	}
	public void setTipoRecurso(Integer tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public Long getIdRecurso() {
		return idRecurso;
	}
	public void setIdRecurso(Long idRecurso) {
		this.idRecurso = idRecurso;
	}
    
    
}
