package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones;

import java.util.Map;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas.Curva;
/**
 * Representa la función de las curvas de corrección del método PCI
 * donde el valor deducido corregido está en función de la sumatoria
 * de los valores deducidos y la cantidad de valores deducidos mayores
 * que 2.0 como indica el método.
 * 
 * @author      Ferney.Moreno
 */
public class FuncionCdv extends Funcion {
    
	public FuncionCdv(Map<String, Curva> curvas) {
		super(curvas);
	}
	
	/**
	 * Calcula el valor deducido corregido.
	 * 
	 * @param q cantidad de valores deducidos mayores que 2.
	 * @param tdv sumatoria de todos los valores deducidos.
	 * @return valor deducido corregido.
	 */
	
	@Override
	public double calcularValor(String q, double tdv) {
		
		return super.calcularValor(q, tdv);
	}

}

