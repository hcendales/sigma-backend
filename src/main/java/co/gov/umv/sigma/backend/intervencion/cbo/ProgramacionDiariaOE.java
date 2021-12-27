package co.gov.umv.sigma.backend.intervencion.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabProgDiariaMaquinaria;
import co.gov.umv.sigma.backend.comun.entidad.TabProgDiariaMaterial;
import co.gov.umv.sigma.backend.comun.entidad.TabProgDiariaPersonal;
import co.gov.umv.sigma.backend.comun.entidad.TabProgramacionDiaria;

public class ProgramacionDiariaOE extends ObjetoEntrada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TabProgramacionDiaria progDiaria;
	private TabProgDiariaPersonal personal;
	private TabProgDiariaMaterial material;
	private TabProgDiariaMaquinaria maquinaria;
	
	
	public TabProgramacionDiaria getProgDiaria() {
		return progDiaria;
	}

	public void setProgDiaria(TabProgramacionDiaria progDiaria) {
		this.progDiaria = progDiaria;
	}

	public TabProgDiariaPersonal getPersonal() {
		return personal;
	}

	public void setPersonal(TabProgDiariaPersonal personal) {
		this.personal = personal;
	}

	public TabProgDiariaMaterial getMaterial() {
		return material;
	}

	public void setMaterial(TabProgDiariaMaterial material) {
		this.material = material;
	}

	public TabProgDiariaMaquinaria getMaquinaria() {
		return maquinaria;
	}

	public void setMaquinaria(TabProgDiariaMaquinaria maquinaria) {
		this.maquinaria = maquinaria;
	}
	
	
	
	
	
}
