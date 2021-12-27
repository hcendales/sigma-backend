package co.gov.umv.sigma.backend.comun.entidad;

public class TabProgDiariaMaterial {

	private Long 	idProgdiariaMaterial;
	private Long 	idProgramacionDiaria;
	private Long 	idTipoMaterial;
	private Long 	idTipoClaseMaterial;
	private Long 	idTipoOrigen;
	private Long 	cantidad;
	private Long 	idTipoUnidadMedida;
	private String 	hora;
	private Long    idTipoUnidadEjecutora;
	
	public Long getIdProgdiariaMaterial() {
		return idProgdiariaMaterial;
	}
	public void setIdProgdiariaMaterial(Long idProgdiariaMaterial) {
		this.idProgdiariaMaterial = idProgdiariaMaterial;
	}
	public Long getIdProgramacionDiaria() {
		return idProgramacionDiaria;
	}
	public void setIdProgramacionDiaria(Long idProgramacionDiaria) {
		this.idProgramacionDiaria = idProgramacionDiaria;
	}
	public Long getIdTipoMaterial() {
		return idTipoMaterial;
	}
	public void setIdTipoMaterial(Long idTipoMaterial) {
		this.idTipoMaterial = idTipoMaterial;
	}
	public Long getIdTipoClaseMaterial() {
		return idTipoClaseMaterial;
	}
	public void setIdTipoClaseMaterial(Long idTipoClaseMaterial) {
		this.idTipoClaseMaterial = idTipoClaseMaterial;
	}
	public Long getIdTipoOrigen() {
		return idTipoOrigen;
	}
	public void setIdTipoOrigen(Long idTipoOrigen) {
		this.idTipoOrigen = idTipoOrigen;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getIdTipoUnidadMedida() {
		return idTipoUnidadMedida;
	}
	public void setIdTipoUnidadMedida(Long idTipoUnidadMedida) {
		this.idTipoUnidadMedida = idTipoUnidadMedida;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Long getIdTipoUnidadEjecutora() {
		return idTipoUnidadEjecutora;
	}
	public void setIdTipoUnidadEjecutora(Long idTipoUnidadEjecutora) {
		this.idTipoUnidadEjecutora = idTipoUnidadEjecutora;
	}
	
	
	
}
