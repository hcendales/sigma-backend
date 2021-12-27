package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.segmentosCurva.SegmentoCurva;

/**
 * Clase que representa una curva que esta compuesta por segmentos
 * que son funciones de tipo f(x) = y.
 * 
 * @author      Ferney.Moreno
 */
public class Curva {
	private SegmentoCurva[]segmentos;

	public Curva(SegmentoCurva[] segmentos) {
		this.segmentos = segmentos;
	}
	/**
	 * Retorna los segmentos de la curva.
	 * 
	 */
	public SegmentoCurva[] getSegmentos() {
		return this.segmentos;
	}
	
	/**
	 * Obtiene f(x) calculando f(x) en el segmento que se definió para x.
	 * 
	 */
	public double calcular(double x) {
		SegmentoCurva segmentoAnterior = this.segmentos[0];
		
		for (SegmentoCurva segmento : segmentos) {
			
			if(x<=segmento.getLimiteInferior()) {
				return segmentoAnterior.calcular(x);
			}
			segmentoAnterior = segmento;
			
		}
		return segmentoAnterior.calcular(x);
	}
}

