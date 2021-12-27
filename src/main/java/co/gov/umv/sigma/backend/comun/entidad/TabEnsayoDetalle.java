package co.gov.umv.sigma.backend.comun.entidad;

import java.io.Serializable;
import java.util.Date;

public class TabEnsayoDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long 	idEnsayoDetalle;
	private Long 	idEnsayo;
	private Long 	idTipoServicioEnsayo;
	private Long 	Programado;
	private Long 	Ejecutado;
	public Long getIdEnsayoDetalle() {
		return idEnsayoDetalle;
	}
	public void setIdEnsayoDetalle(Long idEnsayoDetalle) {
		this.idEnsayoDetalle = idEnsayoDetalle;
	}
	public Long getIdEnsayo() {
		return idEnsayo;
	}
	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	public Long getIdTipoServicioEnsayo() {
		return idTipoServicioEnsayo;
	}
	public void setIdTipoServicioEnsayo(Long idTipoServicioEnsayo) {
		this.idTipoServicioEnsayo = idTipoServicioEnsayo;
	}
	public Long getProgramado() {
		return Programado;
	}
	public void setProgramado(Long programado) {
		Programado = programado;
	}
	public Long getEjecutado() {
		return Ejecutado;
	}
	public void setEjecutado(Long ejecutado) {
		Ejecutado = ejecutado;
	}
	
	
	
}
