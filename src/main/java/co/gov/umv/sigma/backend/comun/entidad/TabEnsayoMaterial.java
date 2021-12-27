package co.gov.umv.sigma.backend.comun.entidad;

public class TabEnsayoMaterial {
	
	private Long 	idEnsayoMaterial;
	private Long 	idEnsayo;
	private Long 	idTipoMaterialEnsayo;
	private String 	fuenteMaterial;
	
	
	public Long getIdEnsayoMaterial() {
		return idEnsayoMaterial;
	}
	public void setIdEnsayoMaterial(Long idEnsayoMaterial) {
		this.idEnsayoMaterial = idEnsayoMaterial;
	}
	public Long getIdEnsayo() {
		return idEnsayo;
	}
	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	public Long getIdTipoMaterialEnsayo() {
		return idTipoMaterialEnsayo;
	}
	public void setIdTipoMaterialEnsayo(Long idTipoMaterialEnsayo) {
		this.idTipoMaterialEnsayo = idTipoMaterialEnsayo;
	}
	public String getFuenteMaterial() {
		return fuenteMaterial;
	}
	public void setFuenteMaterial(String fuenteMaterial) {
		this.fuenteMaterial = fuenteMaterial;
	}
	
	

}
