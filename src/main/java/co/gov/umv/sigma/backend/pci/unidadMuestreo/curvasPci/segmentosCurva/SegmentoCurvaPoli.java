package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.segmentosCurva;

/**
 * Clase que representa un segmento de una curva.
 * el segmento esta definido como una función polinomica de tipo f(x) = y
 * con un límite desde donde los valores empiezan a ser validos
 * para el segmento.
 * 
 * @author      Ferney.Moreno
 * @see SegmentoCurva
 */
public class SegmentoCurvaPoli extends SegmentoCurva {
	private double[] coeficientes;
	
	public SegmentoCurvaPoli(double limiteInferior, double[] coeficientes) {
		
		this.limiteInferior = limiteInferior;
		this.coeficientes = coeficientes;
	}

	/**
	 * Retorna el valor de la función polinómica en x.
	 */
	public double calcular(double x) {
		int potencia = this.coeficientes.length-1;
		double y = 0;
		
		for (double coeficiente : coeficientes) {
			y += coeficiente * Math.pow(x - this.limiteInferior,potencia);
			potencia -= 1;
		}

		if(y<0) {
			return 0;
		}
		return y;
	}
	
	/**
	 *Retorna el arreglo que define los coeficientes y grado del
     *polinomio, por ejemplo: 
     *el arreglo (1,2,3,4) representa el polinomio f(x) = w^3 + 2w^2 + 3w + 4
     *donde w = x-limite_inferior.
	 */
	public double[] getCoeficientes() {
		return coeficientes;
	}

}
