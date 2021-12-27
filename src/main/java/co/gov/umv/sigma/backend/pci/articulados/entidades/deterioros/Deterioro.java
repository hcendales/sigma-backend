package co.gov.umv.sigma.backend.pci.articulados.entidades.deterioros;

import java.util.Map;
/**
 * Clase que modela un deterioro para el calculo del ICP (Índice de condición del pavimento) para pavimentos articulados.
 * esta clase es de uso interno del módulo.
 * @author ferney.moreno
 *
 */
public class Deterioro {

	private String nombreFalla;
	private String severidad;
	private Double medida;

	public Deterioro(String nombreFalla, String severidad, Double medida) {
		this.nombreFalla = nombreFalla;
		this.severidad = severidad;
		this.medida = medida;
	}

	public String getNombreFalla() {
		return nombreFalla;
	}

	public String getSeveridad() {
		return severidad;
	}

	public Double getMedida() {
		return medida;
	}

}
