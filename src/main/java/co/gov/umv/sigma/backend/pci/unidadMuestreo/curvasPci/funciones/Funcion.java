package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones;

import java.util.HashMap;
import java.util.Map;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas.Curva;
/**
 * Representa una función z = f(x,y), donde "y" representa el nombre de la
 * curva en la cual se calculará el valor en "x"
 * 
 * @author      Ferney.Moreno
 */
public class Funcion {
	private HashMap<String,Curva> curvas;

	public Funcion(Map<String,Curva> curvas) {
		this.curvas = new HashMap<>(curvas);
	}
	/**
	 * Calcula el valor para "x" de la función.
	 * @param nombreCurva nombre de la curva en donde se calculará "x".
	 * @param x valor de entrada de la función.
	 * @return valor de salida de la función. 
	 */
	public double calcularValor(String nombreCurva, double x) {
		return this.curvas.get(nombreCurva).calcular(x);
	}
	
}

