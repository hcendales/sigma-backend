package co.gov.umv.sigma.backend.mejoramiento.cbo;

import co.gov.umv.sigma.backend.comun.cbo.ObjetoEntrada;

public class EnsayoApiqueOE extends ObjetoEntrada {
	
	private Long idEnsayo;
	
	private Long idMantenimientoVial;
	
	private Long pkIdCalzada;
	
	private Long apiques;
	
	private Long prioridad;
	
	private String direccion;

	public Long getIdMantenimientoVial() {
		return idMantenimientoVial;
	}

	public Long getPkIdCalzada() {
		return pkIdCalzada;
	}

	public Long getApiques() {
		return apiques;
	}

	public Long getPrioridad() {
		return prioridad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setIdMantenimientoVial(Long idMantenimientoVial) {
		this.idMantenimientoVial = idMantenimientoVial;
	}

	public void setPkIdCalzada(Long pkIdCalzada) {
		this.pkIdCalzada = pkIdCalzada;
	}

	public void setApiques(Long apiques) {
		this.apiques = apiques;
	}

	public void setPrioridad(Long prioridad) {
		this.prioridad = prioridad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getIdEnsayo() {
		return idEnsayo;
	}

	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	
}
