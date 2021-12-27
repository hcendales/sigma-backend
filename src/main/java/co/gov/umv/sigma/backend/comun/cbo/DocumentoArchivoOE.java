package co.gov.umv.sigma.backend.comun.cbo;

public class DocumentoArchivoOE extends ObjetoEntrada {
	private Long idDocumento;
	private Long idMantenimientoVial;
	private Long idArchivo;
	public Long getIdDocumento() {
		return idDocumento;
	}
	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}
	public Long getIdArchivo() {
		return idArchivo;
	}
	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}
	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}
	
	
	
}
