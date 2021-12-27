package co.gov.umv.sigma.backend.intervencion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaCalidad;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaCantObra;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaEntrMaterial;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaMaquinaria;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaMezclaConc;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaObservacion;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaPersonal;
import co.gov.umv.sigma.backend.comun.entidad.TabInfdiacuaSaliMaterial;
import co.gov.umv.sigma.backend.comun.entidad.TabInformeDiarioCuadrilla;

public class InformacionDiariaCuadrillaOE extends ObjetoEntrada {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7085328052008516805L;
	private TabInformeDiarioCuadrilla informeDiarioCuadrilla;
	private TabInfdiacuaPersonal infDiacuaPersonal;
	private TabInfdiacuaCantObra infDiacuaCantObra;
	private TabInfdiacuaCalidad infDiacuaCalidad;
	private TabInfdiacuaMezclaConc infDiacuaMezclaConc;
	private TabInfdiacuaEntrMaterial infDiacuaEntrMaterial;
	private TabInfdiacuaMaquinaria infDiacuaMaquinaria;
	private TabInfdiacuaSaliMaterial infDiacuaSaliMaterial;
	private TabInfdiacuaObservacion infDiacuaObservacion;
	public TabInfdiacuaObservacion getInfDiacuaObservacion() {
		return infDiacuaObservacion;
	}
	public void setInfDiacuaObservacion(TabInfdiacuaObservacion infDiacuaObservacion) {
		this.infDiacuaObservacion = infDiacuaObservacion;
	}
	public TabInformeDiarioCuadrilla getInformeDiarioCuadrilla() {
		return informeDiarioCuadrilla;
	}
	public TabInfdiacuaPersonal getInfDiacuaPersonal() {
		return infDiacuaPersonal;
	}
	public TabInfdiacuaCantObra getInfDiacuaCantObra() {
		return infDiacuaCantObra;
	}
	public TabInfdiacuaCalidad getInfDiacuaCalidad() {
		return infDiacuaCalidad;
	}
	public TabInfdiacuaMezclaConc getInfDiacuaMezclaConc() {
		return infDiacuaMezclaConc;
	}
	public TabInfdiacuaEntrMaterial getInfDiacuaEntrMaterial() {
		return infDiacuaEntrMaterial;
	}
	public TabInfdiacuaMaquinaria getInfDiacuaMaquinaria() {
		return infDiacuaMaquinaria;
	}
	public TabInfdiacuaSaliMaterial getInfDiacuaSaliMaterial() {
		return infDiacuaSaliMaterial;
	}
	public void setInformeDiarioCuadrilla(TabInformeDiarioCuadrilla informeDiarioCuadrilla) {
		this.informeDiarioCuadrilla = informeDiarioCuadrilla;
	}
	public void setInfDiacuaPersonal(TabInfdiacuaPersonal infDiacuaPersonal) {
		this.infDiacuaPersonal = infDiacuaPersonal;
	}
	public void setInfDiacuaCantObra(TabInfdiacuaCantObra infDiacuaCantObra) {
		this.infDiacuaCantObra = infDiacuaCantObra;
	}
	public void setInfDiacuaCalidad(TabInfdiacuaCalidad infDiacuaCalidad) {
		this.infDiacuaCalidad = infDiacuaCalidad;
	}
	public void setInfDiacuaMezclaConc(TabInfdiacuaMezclaConc infDiacuaMezclaConc) {
		this.infDiacuaMezclaConc = infDiacuaMezclaConc;
	}
	public void setInfDiacuaEntrMaterial(TabInfdiacuaEntrMaterial infDiacuaEntrMaterial) {
		this.infDiacuaEntrMaterial = infDiacuaEntrMaterial;
	}
	public void setInfDiacuaMaquinaria(TabInfdiacuaMaquinaria infDiacuaMaquinaria) {
		this.infDiacuaMaquinaria = infDiacuaMaquinaria;
	}
	public void setInfDiacuaSaliMaterial(TabInfdiacuaSaliMaterial infDiacuaSaliMaterial) {
		this.infDiacuaSaliMaterial = infDiacuaSaliMaterial;
	}
}
