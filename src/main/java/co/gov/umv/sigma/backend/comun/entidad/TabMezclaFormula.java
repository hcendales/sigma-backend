package co.gov.umv.sigma.backend.comun.entidad;

import java.util.Date;

public class TabMezclaFormula {

	private Long 	idMezclaFormula;
	private Long 	idTipoMezcla;
	private String 	especificacion;
	private Date 	fechaInicial;
	private Date 	fechaFinal;
	private Long 	masaUnitaria;
	private Long 	unidadMedida;
	private Long 	costoUnitario;
	public Long getIdMezclaFormula() {
		return idMezclaFormula;
	}
	public void setIdMezclaFormula(Long idMezclaFormula) {
		this.idMezclaFormula = idMezclaFormula;
	}
	public Long getIdTipoMezcla() {
		return idTipoMezcla;
	}
	public void setIdTipoMezcla(Long idTipoMezcla) {
		this.idTipoMezcla = idTipoMezcla;
	}
	public String getEspecificacion() {
		return especificacion;
	}
	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
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
	public Long getMasaUnitaria() {
		return masaUnitaria;
	}
	public void setMasaUnitaria(Long masaUnitaria) {
		this.masaUnitaria = masaUnitaria;
	}
	public Long getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(Long unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Long getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(Long costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	
}
