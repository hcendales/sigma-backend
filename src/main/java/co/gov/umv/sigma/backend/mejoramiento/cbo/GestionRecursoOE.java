package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabRecursoDisponibleRelacionado;

public class GestionRecursoOE  extends ObjetoEntrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TabRecursoDisponibleRelacionado relacion;
	
	private Long idPersona;
	private Long idEquipo;
	private Long idLugar;
	private String tiposAsignacion;
	

	public TabRecursoDisponibleRelacionado getRelacion() {
		return relacion;
	}

	public void setRelacion(TabRecursoDisponibleRelacionado relacion) {
		this.relacion = relacion;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Long getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(Long idLugar) {
		this.idLugar = idLugar;
	}

	public String getTiposAsignacion() {
		return tiposAsignacion;
	}

	public void setTiposAsignacion(String tiposAsignacion) {
		this.tiposAsignacion = tiposAsignacion;
	}


	
}
