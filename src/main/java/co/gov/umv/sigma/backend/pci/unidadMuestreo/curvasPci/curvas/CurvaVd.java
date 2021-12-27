package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.segmentosCurva.SegmentoCurva;
/**
 * Representa una curva de valor deducido del método PCI donde 
 * el valor deducido está en función de la densidad de una
 * falla en una unidad de muestreo.
 * 
 * @author      Ferney.Moreno
 */
public class CurvaVd extends Curva {
    private double maxDensidad;
    
	public CurvaVd(SegmentoCurva[] segmentos, double maxDensidad) {
		super(segmentos);
		this.maxDensidad = maxDensidad;
	}
	
	/**
	 * Calcula el valor deducido de una falla
	 * @param densidad de la falla en la unidad de muestreo.
	 * @return valor deducido de la falla. 
	 */
	@Override
	public double calcular(double densidad) {
		if(densidad < this.getSegmentos()[0].getLimiteInferior()) {
			return 0;
		}else if(densidad > this.maxDensidad){
			return super.calcular(this.maxDensidad);
		}
		return super.calcular(densidad);
	} 

}
