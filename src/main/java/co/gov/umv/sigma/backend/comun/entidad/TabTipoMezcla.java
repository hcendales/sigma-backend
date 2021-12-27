package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;

public class TabTipoMezcla implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long 	idTipoMezcla;
	private Long 	idTipoServicio;
	private Long 	idTipoGrupo;
	private String 	Subgrupo;
	private Long 	idTipoMezclaPadre;
	
	public Long getIdTipoMezcla() {
		return idTipoMezcla;
	}
	public void setIdTipoMezcla(Long idTipoMezcla) {
		this.idTipoMezcla = idTipoMezcla;
	}
	public Long getIdTipoServicio() {
		return idTipoServicio;
	}
	public void setIdTipoServicio(Long idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}
	public Long getIdTipoGrupo() {
		return idTipoGrupo;
	}
	public void setIdTipoGrupo(Long idTipoGrupo) {
		this.idTipoGrupo = idTipoGrupo;
	}
	public String getSubgrupo() {
		return Subgrupo;
	}
	public void setSubgrupo(String subgrupo) {
		Subgrupo = subgrupo;
	}
	public Long getIdTipoMezclaPadre() {
		return idTipoMezclaPadre;
	}
	public void setIdTipoMezclaPadre(Long idTipoMezclaPadre) {
		this.idTipoMezclaPadre = idTipoMezclaPadre;
	}
	
	

}
