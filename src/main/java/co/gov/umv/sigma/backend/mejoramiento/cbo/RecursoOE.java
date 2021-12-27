package co.gov.umv.sigma.backend.mejoramiento.cbo;

import java.util.Date;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabRecurso;
import co.gov.umv.sigma.backend.comun.entidad.TabRecursoAsignacion;
import co.gov.umv.sigma.backend.comun.entidad.TabRecursoDisponibilidad;
import co.gov.umv.sigma.backend.comun.entidad.TabRecursoNovedad;

public class RecursoOE  extends ObjetoEntrada 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TabRecurso recurso ;
	private TabRecursoAsignacion asignacion;
	private TabRecursoDisponibilidad disponibilidad;
	private TabRecursoNovedad novedad;
	
	private Integer tipoRecurso;
	private Date fechaDesde ;
	private Date fechaHasta;
    private Long eliminar;
    
	public TabRecurso getRecurso() {
		return recurso;
	}

	public void setRecurso(TabRecurso recurso) {
		this.recurso = recurso;
	}

	public TabRecursoAsignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(TabRecursoAsignacion asignacion) {
		this.asignacion = asignacion;
	}

	public TabRecursoDisponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(TabRecursoDisponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public TabRecursoNovedad getNovedad() {
		return novedad;
	}

	public void setNovedad(TabRecursoNovedad novedad) {
		this.novedad = novedad;
	}


	public Integer getTipoRecurso() {
		return tipoRecurso;
	}

	public void setTipoRecurso(Integer tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
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

	public Long getEliminar() {
		return eliminar;
	}

	public void setEliminar(Long eliminar) {
		this.eliminar = eliminar;
	}


	
	
	
	
}
