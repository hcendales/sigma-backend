package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.segmentosCurva.SegmentoCurva;
/**
 * Representa una curva de corrección del método PCI donde 
 * el valor deducido corregido está en función de la sumatoria
 * de todos los valores deducidos.
 * 
 * @author      Ferney.Moreno
 */
public class CurvaCdv extends Curva {
    private double maxTdv;
    
	public CurvaCdv(SegmentoCurva[] segmentos, double maxTdv) {
		super(segmentos);
		this.maxTdv = maxTdv;
	}
	
	/**
	 * Calcula el valor deducido corregido.
	 * @param tdv Sumatoria de todos los valores deducidos.
	 * @return Valor deducido corregido.
	 */
	@Override
	public double calcular(double tdv) {
		double limInfCurva = super.getSegmentos()[0].getLimiteInferior();
		
		if(tdv < limInfCurva) {
			return super.calcular(limInfCurva);
		}
		if(tdv > this.maxTdv) {
			return super.calcular(this.maxTdv);
		}
		return super.calcular(tdv);
	}
	
	/**
	 * Retorna el máximo tdv (total value dedcut) para el 
	 * cual se puede obtener el valor deducido corregido.
	 */
	public double getxmaxTdv() {
		return maxTdv;
	}
	
}

