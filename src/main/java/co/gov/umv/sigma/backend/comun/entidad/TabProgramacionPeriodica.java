package co.gov.umv.sigma.backend.comun.entidad;

public class TabProgramacionPeriodica {
	
	private Long 	idProgramacionPeriodica;
	private Long 	idTipoPeriodoProgramacion;
	private Long 	kmCarrilImpacto;
	private Long 	kmCarrilLineal;
	private Long 	kmCarrilObra;
	private Long 	totalDiasDuracionPlaneada;
	private Long 	totalNumeroCuadrillas;
	private Long 	idArchivo;
	private String 	observaciones;
	
	
	public Long getIdProgramacionPeriodica() {
		return idProgramacionPeriodica;
	}
	public void setIdProgramacionPeriodica(Long idProgramacionPeriodica) {
		this.idProgramacionPeriodica = idProgramacionPeriodica;
	}
	
	
	
	public Long getIdTipoPeriodoProgramacion() {
		return idTipoPeriodoProgramacion;
	}
	public void setIdTipoPeriodoProgramacion(Long idTipoPeriodoProgramacion) {
		this.idTipoPeriodoProgramacion = idTipoPeriodoProgramacion;
	}
	
	
	
	public Long getKmCarrilImpacto() {
		return kmCarrilImpacto;
	}
	public void setKmCarrilImpacto(Long kmCarrilImpacto) {
		this.kmCarrilImpacto = kmCarrilImpacto;
	}
	public Long getKmCarrilLineal() {
		return kmCarrilLineal;
	}
	public void setKmCarrilLineal(Long kmCarrilLineal) {
		this.kmCarrilLineal = kmCarrilLineal;
	}
	public Long getKmCarrilObra() {
		return kmCarrilObra;
	}
	public void setKmCarrilObra(Long kmCarrilObra) {
		this.kmCarrilObra = kmCarrilObra;
	}
	public Long getTotalDiasDuracionPlaneada() {
		return totalDiasDuracionPlaneada;
	}
	public void setTotalDiasDuracionPlaneada(Long totalDiasDuracionPlaneada) {
		this.totalDiasDuracionPlaneada = totalDiasDuracionPlaneada;
	}
	public Long getTotalNumeroCuadrillas() {
		return totalNumeroCuadrillas;
	}
	public void setTotalNumeroCuadrillas(Long totalNumeroCuadrillas) {
		this.totalNumeroCuadrillas = totalNumeroCuadrillas;
	}
	
	
	
	public Long getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
