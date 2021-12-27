package co.gov.umv.sigma.backend.mejoramiento.cbo;

import java.util.Date;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class VisitaOE extends ObjetoEntrada {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRecursoDisponibilidad;
	private Long idPersona;
	
	private Long idTipoOrigen;
	private Long idZona;
	private Long idLocalidad  ;
	private Long idUpz ;
	private Long idBarrio     ;
	private Long idActividad  ;
	private Long pkIdCalzada ;
	private Long idResponsable ;
	private Long movil  ;   

	
	private Date fechaDesde;
	private Date fechaHasta;
	private String conductor;
	private String placaVehiculo;
	
	public Long getIdRecursoDisponibilidad() {
		return idRecursoDisponibilidad;
	}
	public void setIdRecursoDisponibilidad(Long idRecursoDisponibilidad) {
		this.idRecursoDisponibilidad = idRecursoDisponibilidad;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Long getIdTipoOrigen() {
		return idTipoOrigen;
	}
	public void setIdTipoOrigen(Long idTipoOrigen) {
		this.idTipoOrigen = idTipoOrigen;
	}
	public Long getIdZona() {
		return idZona;
	}
	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}
	public Long getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public Long getIdUpz() {
		return idUpz;
	}
	public void setIdUpz(Long idUpz) {
		this.idUpz = idUpz;
	}
	public Long getIdBarrio() {
		return idBarrio;
	}
	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getPkIdCalzada() {
		return pkIdCalzada;
	}
	public void setPkIdCalzada(Long pkIdCalzada) {
		this.pkIdCalzada = pkIdCalzada;
	}
	public Long getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(Long idResponsable) {
		this.idResponsable = idResponsable;
	}
	public Long getMovil() {
		return movil;
	}
	public void setMovil(Long movil) {
		this.movil = movil;
	}
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
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
	
	
	
	

}
