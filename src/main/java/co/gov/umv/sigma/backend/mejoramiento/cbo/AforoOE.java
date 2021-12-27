package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;
import co.gov.umv.sigma.backend.comun.entidad.TabAforo2;
import co.gov.umv.sigma.backend.comun.entidad.TabAforoAnalisis;
import co.gov.umv.sigma.backend.comun.entidad.TabAforoCalzada;
import co.gov.umv.sigma.backend.comun.entidad.TabAforoDato;

public class AforoOE extends ObjetoEntrada {
	private TabAforo2 aforo;
	
	private TabAforoDato aforodato;
	
	private TabAforoCalzada aforocalzada;
	
	private TabAforoAnalisis aforoanalisis;
	
	public TabAforo2 getAforo() {
		return aforo;
	}

	public void setAforo(TabAforo2 aforo) {
		this.aforo = aforo;
	}

	public TabAforoDato getAforodato() {
		return aforodato;
	}

	public void setAforodato(TabAforoDato aforodato) {
		this.aforodato = aforodato;
	}

	public TabAforoCalzada getAforocalzada() {
		return aforocalzada;
	}

	public void setAforocalzada(TabAforoCalzada aforocalzada) {
		this.aforocalzada = aforocalzada;
	}

	public TabAforoAnalisis getAforoanalisis() {
		return aforoanalisis;
	}

	public void setAforoanalisis(TabAforoAnalisis aforoanalisis) {
		this.aforoanalisis = aforoanalisis;
	}
}
