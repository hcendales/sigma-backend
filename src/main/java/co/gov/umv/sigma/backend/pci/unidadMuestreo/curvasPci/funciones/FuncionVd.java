package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones;

import java.util.Map;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas.Curva;
/**
 * Representa una función de valores deducidos del método PCI
 * donde el valor deducido está en función de la severidad de la falla
 * y su respectiva densidad en el area de muestreo.
 * 
 * @author      Ferney.Moreno
 */
public class FuncionVd extends Funcion{
	private static final int MAX_DENSIDAD = 100; //maxima densidad definida para una curva de valor deducido
    private double minDensidad; //mínima definida por la grafica
    
	public FuncionVd(Map<String, Curva> curvas, double minDensidad) {
		super(curvas);
		this.minDensidad = minDensidad;
		
	}
	/**
	 * Calcula el valor deducido de una falla.
	 * Si la densidad es mayor de 100, se tomará la densidad como 
	 * 100, ya que es el mayor valor definido en las curvas del método.
	 * <p>
	 * Si la densidad es menor de la densidad minima definida, retornará
	 * cero como valor deducido. 
	 * 
	 * @param severidad severidad de la falla ("l","m","h")
	 * @param densidad densidad de la falla en la unidad de muestreo.
	 * @return valor deducido de la densidad de la falla.
	 */
	@Override
	public double calcularValor(String severidad, double densidad) {
		if(densidad < this.minDensidad) {
			return 0;
		}
		
		if(densidad > MAX_DENSIDAD) {
			return super.calcularValor(severidad, MAX_DENSIDAD);
		}
		return super.calcularValor(severidad, densidad);
	}

}
