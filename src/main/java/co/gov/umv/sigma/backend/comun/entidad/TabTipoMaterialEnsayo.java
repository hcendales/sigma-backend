package co.gov.umv.sigma.backend.comun.entidad;

public class TabTipoMaterialEnsayo {

	private Long 	idTipoMaterialEnsayo;
	private Long 	idTipoServicio;
	private Long 	idTipoGrupo;
	private String 	subgrupo;
	private Long 	idTipoMaterialEnsayoPadre;
	private String  tipoServicio;
	
	public Long getIdTipoMaterialEnsayo() {
		return idTipoMaterialEnsayo;
	}
	public void setIdTipoMaterialEnsayo(Long idTipoMaterialEnsayo) {
		this.idTipoMaterialEnsayo = idTipoMaterialEnsayo;
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
		return subgrupo;
	}
	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}
	public Long getIdTipoMaterialEnsayoPadre() {
		return idTipoMaterialEnsayoPadre;
	}
	public void setIdTipoMaterialEnsayoPadre(Long idTipoMaterialEnsayoPadre) {
		this.idTipoMaterialEnsayoPadre = idTipoMaterialEnsayoPadre;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	
	
	
}
