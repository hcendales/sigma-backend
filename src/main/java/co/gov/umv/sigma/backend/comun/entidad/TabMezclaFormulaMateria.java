package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabMezclaFormulaMateria {

	private Long 	idMezclaFormulaMateria;
	private Long 	idMezclaFormula;
	private Long 	idTipoMateria;
	private Long 	masaUnitaria;
	private Long 	formulaTrabajo;
	private Long 	porcentaje;
	private Long 	cantidad;
	private Long 	volumen;
	private Long 	costoUnitario;
	private String 	signo;
	private Date 	fechaInicial;
	private Date 	fechaFinal;
	
	public Long getIdMezclaFormulaMateria() {
		return idMezclaFormulaMateria;
	}
	public void setIdMezclaFormulaMateria(Long idMezclaFormulaMateria) {
		this.idMezclaFormulaMateria = idMezclaFormulaMateria;
	}
	public Long getIdMezclaFormula() {
		return idMezclaFormula;
	}
	public void setIdMezclaFormula(Long idMezclaFormula) {
		this.idMezclaFormula = idMezclaFormula;
	}
	public Long getIdTipoMateria() {
		return idTipoMateria;
	}
	public void setIdTipoMateria(Long idTipoMateria) {
		this.idTipoMateria = idTipoMateria;
	}
	public Long getMasaUnitaria() {
		return masaUnitaria;
	}
	public void setMasaUnitaria(Long masaUnitaria) {
		this.masaUnitaria = masaUnitaria;
	}
	public Long getFormulaTrabajo() {
		return formulaTrabajo;
	}
	public void setFormulaTrabajo(Long formulaTrabajo) {
		this.formulaTrabajo = formulaTrabajo;
	}
	public Long getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Long porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getVolumen() {
		return volumen;
	}
	public void setVolumen(Long volumen) {
		this.volumen = volumen;
	}
	public Long getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(Long costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	
	
}
