package co.gov.umv.sigma.backend.intervencion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabActividadAgTipoIntervencion;
import co.gov.umv.sigma.backend.comun.entidad.TabProgramacionPeriodica;
import co.gov.umv.sigma.backend.comun.entidad.TabProgramacionPeriodicaMV;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoClaseMaterial;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoDirectorApoyo;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoDirectorResidente;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoDirectorZona;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoPeriodoProgramacion;
import co.gov.umv.sigma.backend.comun.entidad.TabTipoResidenteUnidadEjec;
import co.gov.umv.sigma.backend.comun.entidad.TabUnidadEjecutoraPersona;
import co.gov.umv.sigma.backend.comun.entidad.TabZonaCoberturaEquipo;
import co.gov.umv.sigma.backend.comun.entidad.TabZonaCoberturaPersona;
import co.gov.umv.sigma.backend.comun.entidad.TabZonaCoberturaUnidadEjec;

public class IntervencionOE extends ObjetoEntrada {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private TabTipoPeriodoProgramacion tipoProgramacion;
	private TabProgramacionPeriodica progPeriodica;
	private TabProgramacionPeriodicaMV detalle;
	
	private TabActividadAgTipoIntervencion relacion;
	private TabTipoClaseMaterial tipoClaseMaterial;
	
	
	private TabUnidadEjecutoraPersona unidadEjecPersona;
	private TabZonaCoberturaEquipo zonaCoberturaEquipo;
	private TabZonaCoberturaPersona zonaCoberturaPersona;
	private TabZonaCoberturaUnidadEjec zonaCoberturaUnidadE;
	
	private TabTipoDirectorZona directorZona;
	private TabTipoDirectorResidente directorResidente;
	private TabTipoDirectorApoyo directorApoyo;
	private TabTipoResidenteUnidadEjec residenteUnidad;
	
	private int vigencia;
	private int idPeriodicidad;
	private int idActividad;
	
	
	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public int getIdPeriodicidad() {
		return idPeriodicidad;
	}

	public void setIdPeriodicidad(int idPeriodicidad) {
		this.idPeriodicidad = idPeriodicidad;
	}

	public TabTipoPeriodoProgramacion getTipoProgramacion() {
		return tipoProgramacion;
	}

	public void setTipoProgramacion(TabTipoPeriodoProgramacion tipoProgramacion) {
		this.tipoProgramacion = tipoProgramacion;
	}

	public TabProgramacionPeriodica getProgPeriodica() {
		return progPeriodica;
	}

	public void setProgPeriodica(TabProgramacionPeriodica progPeriodica) {
		this.progPeriodica = progPeriodica;
	}

	public TabProgramacionPeriodicaMV getDetalle() {
		return detalle;
	}

	public void setDetalle(TabProgramacionPeriodicaMV detalle) {
		this.detalle = detalle;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public TabActividadAgTipoIntervencion getRelacion() {
		return relacion;
	}

	public void setRelacion(TabActividadAgTipoIntervencion relacion) {
		this.relacion = relacion;
	}

	public TabTipoClaseMaterial getTipoClaseMaterial() {
		return tipoClaseMaterial;
	}

	public void setTipoClaseMaterial(TabTipoClaseMaterial tipoClaseMaterial) {
		this.tipoClaseMaterial = tipoClaseMaterial;
	}

	public TabUnidadEjecutoraPersona getUnidadEjecPersona() {
		return unidadEjecPersona;
	}

	public void setUnidadEjecPersona(TabUnidadEjecutoraPersona unidadEjecPersona) {
		this.unidadEjecPersona = unidadEjecPersona;
	}

	public TabZonaCoberturaEquipo getZonaCoberturaEquipo() {
		return zonaCoberturaEquipo;
	}

	public void setZonaCoberturaEquipo(TabZonaCoberturaEquipo zonaCoberturaEquipo) {
		this.zonaCoberturaEquipo = zonaCoberturaEquipo;
	}

	public TabZonaCoberturaPersona getZonaCoberturaPersona() {
		return zonaCoberturaPersona;
	}

	public void setZonaCoberturaPersona(TabZonaCoberturaPersona zonaCoberturaPersona) {
		this.zonaCoberturaPersona = zonaCoberturaPersona;
	}

	public TabZonaCoberturaUnidadEjec getZonaCoberturaUnidadE() {
		return zonaCoberturaUnidadE;
	}

	public void setZonaCoberturaUnidadE(TabZonaCoberturaUnidadEjec zonaCoberturaUnidadE) {
		this.zonaCoberturaUnidadE = zonaCoberturaUnidadE;
	}

	public TabTipoDirectorZona getDirectorZona() {
		return directorZona;
	}

	public void setDirectorZona(TabTipoDirectorZona directorZona) {
		this.directorZona = directorZona;
	}

	public TabTipoDirectorResidente getDirectorResidente() {
		return directorResidente;
	}

	public void setDirectorResidente(TabTipoDirectorResidente directorResidente) {
		this.directorResidente = directorResidente;
	}

	public TabTipoDirectorApoyo getDirectorApoyo() {
		return directorApoyo;
	}

	public void setDirectorApoyo(TabTipoDirectorApoyo directorApoyo) {
		this.directorApoyo = directorApoyo;
	}

	public TabTipoResidenteUnidadEjec getResidenteUnidad() {
		return residenteUnidad;
	}

	public void setResidenteUnidad(TabTipoResidenteUnidadEjec residenteUnidad) {
		this.residenteUnidad = residenteUnidad;
	}
	
	
	
	
	
	
}
