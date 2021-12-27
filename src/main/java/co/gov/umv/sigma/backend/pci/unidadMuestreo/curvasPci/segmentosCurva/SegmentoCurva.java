package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.segmentosCurva;

/**
 * Clase que representa un segmento de una curva.
 * el segmento esta definido como una función de tipo f(x) = y
 * con un límite desde donde los valores empiezan a ser validos
 * para el segmento.
 * 
 * @author      Ferney.Moreno
 */
public abstract class SegmentoCurva {
	protected double limiteInferior;
	
	/**
	 * Calcula f(x).
	 * @param x valor para calcular su respectivo f(x).
	 */
	public abstract double calcular(double x);
	
	/**
	 * Método get de la variable limiteInferior.
	 * @return el mínimo valor de x para el cual esta definido el segmento
	 */
	public double getLimiteInferior() {
		return this.limiteInferior;
	}
}
