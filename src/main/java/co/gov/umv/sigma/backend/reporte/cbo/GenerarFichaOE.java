package co.gov.umv.sigma.backend.reporte.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class GenerarFichaOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1829307141541878483L;
	private Long idMantenimientoVial;
	private Long idMantenimientoVialEvento;
	private Long idDocumento;
	private Long idActividad;
	private String extent;
	private String bboxSR;
	private Boolean guardar=false;
	private Long idAforo;
	private Long idMantenimientoEquipo;
	
	private Boolean pasarAFirme=false;
	private Integer anchoImagen=null;
	private Integer largoImagen=null;
	
	
	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}
	public Long getIdDocumento() {
		return idDocumento;
	}
	public String getExtent() {
		return extent;
	}
	public String getBboxSR() {
		return bboxSR;
	}
	public Boolean getGuardar() {
		return guardar;
	}
	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}
	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}
	public void setExtent(String extent) {
		this.extent = extent;
	}
	public void setBboxSR(String bboxSR) {
		this.bboxSR = bboxSR;
	}
	public void setGuardar(Boolean guardar) {
		this.guardar = guardar;
	}
	public Long getIdMantenimientoVialEvento() {
		return idMantenimientoVialEvento;
	}
	public void setIdMantenimientoVialEvento(Long idMantenimientoVialEvento) {
		this.idMantenimientoVialEvento = idMantenimientoVialEvento;
	}
	public Long getIdAforo() {
		return idAforo;
	}
	public void setIdAforo(Long idAforo) {
		this.idAforo = idAforo;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdMantenimientoEquipo() {
		return idMantenimientoEquipo;
	}
	public void setIdMantenimientoEquipo(Long idEquipo) {
		this.idMantenimientoEquipo = idEquipo;
	}
	public Boolean getPasarAFirme() {
		return pasarAFirme;
	}
	public void setPasarAFirme(Boolean pasarAFirme) {
		this.pasarAFirme = pasarAFirme;
	}
	public Integer getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(Integer anchoImagen) {
		this.anchoImagen = anchoImagen;
	}
	public Integer getLargoImagen() {
		return largoImagen;
	}
	public void setLargoImagen(Integer largoImagen) {
		this.largoImagen = largoImagen;
	}
	
	
	
}
