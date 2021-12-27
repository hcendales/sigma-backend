package co.gov.umv.sigma.backend.pci.articulados.calculo;

import java.util.HashMap;
import java.util.Map;

import co.gov.umv.sigma.backend.pci.articulados.entidades.deterioros.Deterioro;

public class CalculadorICP{
	
	/**
	 * Constructor privado para que la clase sea usada como estática.
	 */
	private CalculadorICP() {
		
	}
	
	/**
	 * Calcula el ICP (Indice de condición del pavimento ) para un conjunto de deterioros en un segmento de un area determinada
	 * @param deterioros
	 * @param areaSegmento
	 * @return
	 */
	public static Double CalcularIcp(Deterioro[] deterioros, Double areaSegmento) {
		Map<String,Double> indices = calcularIceIcf(deterioros, areaSegmento);
		
		if(indices.get(Constantes.INDICE_ICE) <= 20d || indices.get(Constantes.INDICE_ICF) <= 20d) {
			if(indices.get(Constantes.INDICE_ICF) <= 70d || indices.get(Constantes.INDICE_ICE) <= 70d) {
				return 1d;
			}else {
				return 2d;
			}
		}else if(indices.get(Constantes.INDICE_ICE) <= 40d || indices.get(Constantes.INDICE_ICF) <= 40d) {
			if(indices.get(Constantes.INDICE_ICF) <= 70d || indices.get(Constantes.INDICE_ICE) <= 70d ) {
				return 2d;
			}else {
				return 3d;
			}
		}else if(indices.get(Constantes.INDICE_ICE) <= 70d || indices.get(Constantes.INDICE_ICF) <= 70d) {
			if(indices.get(Constantes.INDICE_ICF) <= 85d || indices.get(Constantes.INDICE_ICE) <= 85d) {
				return 3d;
			}else {
				return 4d;
			}
		}else if(indices.get(Constantes.INDICE_ICE) <= 85d || indices.get(Constantes.INDICE_ICF) <= 85d) {
			return 4d;
		}else if(indices.get(Constantes.INDICE_ICE) > 85d || indices.get(Constantes.INDICE_ICF) > 85d) {
			return 5d;
		}
		System.out.println("no existe un ICP para los valores ICE y ICF dados");
		return null;
	}
	
	/**
	 * Calcula los indices ICE (Indice de condición estructural) e ICF (Indice de condicion funcional)
	 * @param deterioros 
	 * @param areaSegmento area del segmento donde se encuentran los deterioros 
	 * @return map que contiene los dos indices calculados.
	 */
	private static Map<String,Double> calcularIceIcf(Deterioro[] deterioros, Double areaSegmento) {
		Double ice = 100d;
		Double icf = 100d;
		
		Map<String,Map<Integer,Double>> factoresPenalizacion = CalculadorFactorPenalizacion.calcularFactorPenalizacion(deterioros, areaSegmento);
		
		for (Map.Entry<String,Map<Integer,Double>> entry : factoresPenalizacion.entrySet()) {
		   
			if(factoresPenalizacion.get(entry.getKey()).get(Constantes.CRITERIO_ESTRUCTURAL) != null) {
				Double fcIce = obtenerInfluenciaPorClase(entry.getKey(), Constantes.CRITERIO_ESTRUCTURAL);
				Double faIce = factoresPenalizacion.get(entry.getKey()).get(Constantes.CRITERIO_ESTRUCTURAL);
				ice -= fcIce * faIce;
			}
		   
		   if(factoresPenalizacion.get(entry.getKey()).get(Constantes.CRITERIO_FUNCIONAL) != null) {
			   Double fcIcf = obtenerInfluenciaPorClase(entry.getKey(), Constantes.CRITERIO_FUNCIONAL);
			   Double faIcf = factoresPenalizacion.get(entry.getKey()).get(Constantes.CRITERIO_FUNCIONAL);
			   icf -= fcIcf * faIcf;
		   }
		   
		}
		
		Map<String,Double> res = new HashMap<>();
		res.put(Constantes.INDICE_ICE, ice);
		res.put(Constantes.INDICE_ICF, icf);
		return res;
	}
	
	/**
	 * Obtiene la influencia por clase 
	 * @param clase clase a la que pertenece un deterioro
	 * @param criterio criterio estructural o funcional
	 * @return
	 */
	private static Double obtenerInfluenciaPorClase(String clase, int criterio) {
		switch(clase) {
			case Constantes.CLASE_DEFORMACIONES:
				if(criterio == Constantes.CRITERIO_ESTRUCTURAL || criterio == Constantes.CRITERIO_FUNCIONAL) {
					return 48d; 
				}
				break;
			case Constantes.CLASE_DESPLAZAMIENTOS:
				if(criterio == Constantes.CRITERIO_ESTRUCTURAL) {
					return 6d; 
				}else if(criterio == Constantes.CRITERIO_FUNCIONAL) {
					return 9d;
				}
				break;
			case Constantes.CLASE_DESPRENDIMIENTOS:
				if(criterio == Constantes.CRITERIO_ESTRUCTURAL || criterio == Constantes.CRITERIO_FUNCIONAL) {
					return 10d; 
				}
				break;
			case Constantes.CLASE_FRACTURAMIENTOS:
				if(criterio == Constantes.CRITERIO_ESTRUCTURAL) {
					return 28d; 
				}else if(criterio == Constantes.CRITERIO_FUNCIONAL) {
					return 10d;
				}
				break;
			case Constantes.CLASE_OTROS:
				if(criterio == Constantes.CRITERIO_ESTRUCTURAL) {
					return 8d; 
				}else if(criterio == Constantes.CRITERIO_FUNCIONAL) {
					return 23d;
				}
				break;
			default:
				System.out.println("No hay un valor definido para la clase indicada.");
				return null;
		}
		System.out.println("No hay un valor definido para el criterio indicado.");
		return null;
	}
}
