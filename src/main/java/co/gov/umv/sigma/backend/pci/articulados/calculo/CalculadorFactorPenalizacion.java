package co.gov.umv.sigma.backend.pci.articulados.calculo;

import java.util.HashMap;
import java.util.Map;

import co.gov.umv.sigma.backend.pci.articulados.entidades.deterioros.Deterioro;
/**
 * Clase encargada del cálculo el factor de penalización 
 * @author ferney.moreno
 *
 */
 class CalculadorFactorPenalizacion {
private static final String SEVERIDAD_NO_ENCONTRADA = "Severidad de la falla no definida.";
	
	/**
	 * Constructor privado para que la clase sea usada como estática.
	 */
	private CalculadorFactorPenalizacion() {
		
	}
	
	/**
	 * Obtiene el factor de penalización agrupados por clase de deterioro y por criterio estructural y funcional.
	 * Usado para calcular el ICP (Índice de condición del pavimento).
	 * @param deterioros
	 * @param areaSegmento
	 * @return Map donde se relaciona la clase de deterioro y los factores de penalización estructural y funcional.
	 */
	public static Map<String,Map<Integer,Double>> calcularFactorPenalizacion(Deterioro[] deterioros, Double areaSegmento){
		Map<String,Map<Integer,Double>> res = new HashMap<>();
		
		Map<String,Map<Integer,Double>> porcentajeAreaEquivAfectada =calcularPorcentajeAreaEquivAfectada(deterioros, areaSegmento);
		
		for(Map.Entry<String,Map<Integer,Double>> entry : porcentajeAreaEquivAfectada.entrySet()) {
			Map<Integer,Double> a = new HashMap<>();
			if(entry.getValue().get(Constantes.CRITERIO_ESTRUCTURAL) != null) {
				a.put(Constantes.CRITERIO_ESTRUCTURAL, obtenerFactorPenalizacion(entry.getValue().get(Constantes.CRITERIO_ESTRUCTURAL)));
			}
			if(entry.getValue().get(Constantes.CRITERIO_FUNCIONAL) != null) {
				a.put(Constantes.CRITERIO_FUNCIONAL, obtenerFactorPenalizacion(entry.getValue().get(Constantes.CRITERIO_FUNCIONAL)));
			}
			res.put(entry.getKey(), a);
		}
		
		return res;
	}
	
	/**
	 * Obtiene el factor de penalización por area equivalente afectada, se aplica una interpolación lineal si los valores se encuentran entre dos valores preestablecidos.
	 * Si el valor es igual a cero retorna cero, si el valor es mayor que 15 retorna 0.76
	 * No se toma en cuenta si es para calcular ICE o ICF por que los valores son los mismos para ambos indices.
	 * @param areaEquivAfectada
	 * @return
	 */
	private static Double obtenerFactorPenalizacion(Double areaEquivAfectada) {
		
		if(areaEquivAfectada <= 0d) {
			return 0d;
		}else if(areaEquivAfectada > 15d){
			return 1d;
		}
		
		Map<Double,Double> valores = new HashMap<>();
		valores.put(0d, 0d);
		valores.put(5d, 0.5d);
		valores.put(10d, 0.6d);
		valores.put(15d, 0.76d);
		
		if(valores.get(areaEquivAfectada) != null) {
			return valores.get(areaEquivAfectada);
		}
		
		//proceso de interpolación, para cuando el valor se encuentra entre 2 valores definidos, se realiza una interpolacion lineal
		Double x1 = null;
		Double x2 = null;
		
		for(Double v:valores.keySet()) {
			if(areaEquivAfectada <= v) {
				x2 = v;
				break;
			}
			x1 = v;
		}
		
		Double y1 = valores.get(x1);
		Double y2 = valores.get(x2);
		Double pendiente = (y2-y1) / (x2-x1);
		
		return (pendiente * (areaEquivAfectada - x1)) + y1;
		
	}
		
	/**
	 * Calcula el porcentaje de Area equivalente afectada para los deterioros y los agrupa por clase de deterioro.
	 * @param deterioros
	 * @param areaSegmento
	 * @return retorna los factores de penalización estructural tanto como funcional de las fallas ingresadas clasificados por clase de deterioro.
	 */
	private static Map<String,Map<Integer,Double>> calcularPorcentajeAreaEquivAfectada(Deterioro[] deterioros, Double areaSegmento){
		Map<String,Map<Integer,Double>> res = new HashMap<>();
		
		for(Deterioro d:deterioros) {
			String claseDeterioro = ClasificadorDeterioros.getClase(d);
			if(res.get(claseDeterioro) == null) {
				res.put(claseDeterioro, new HashMap<Integer,Double>());
			}
			
			Map<Integer,Double> factorPenalizacionClase = res.get(claseDeterioro);
			
			Map<Integer,Double> a = calcularPorcentajeAreaEquivAfectada(d,areaSegmento);
			
			if(a.get(Constantes.CRITERIO_ESTRUCTURAL) != null) {
				if(factorPenalizacionClase.get(Constantes.CRITERIO_ESTRUCTURAL)==null) {
					factorPenalizacionClase.put(Constantes.CRITERIO_ESTRUCTURAL, a.get(Constantes.CRITERIO_ESTRUCTURAL));
				}else {
					factorPenalizacionClase.put(Constantes.CRITERIO_ESTRUCTURAL, factorPenalizacionClase.get(Constantes.CRITERIO_ESTRUCTURAL) + a.get(Constantes.CRITERIO_ESTRUCTURAL));
				}
			}
			
			if(a.get(Constantes.CRITERIO_FUNCIONAL) != null) {
				if(factorPenalizacionClase.get(Constantes.CRITERIO_FUNCIONAL)==null) {
					factorPenalizacionClase.put(Constantes.CRITERIO_FUNCIONAL, a.get(Constantes.CRITERIO_FUNCIONAL));
				}else {
					factorPenalizacionClase.put(Constantes.CRITERIO_FUNCIONAL, factorPenalizacionClase.get(Constantes.CRITERIO_FUNCIONAL) + a.get(Constantes.CRITERIO_FUNCIONAL));
				}
			}
			
		}
		
		return res;
	}
	
	/**
	 * Calcula el porcentaje de Area equivalente afectada para un deterioro.
	 * @param d
	 * @param areaSegmento
	 * @return
	 */
	private static Map<Integer,Double> calcularPorcentajeAreaEquivAfectada(Deterioro d, Double areaSegmento) {
		Map<Integer,Double> res = new HashMap<>();
		
		Double porcentajeArea = (d.getMedida() / areaSegmento)*100;
		Map<Integer,Double> fns = obtenerFNS(d.getNombreFalla(), d.getSeveridad());
		Map<Integer,Double> peso = obtenerPesoEnsuClase(d.getNombreFalla());
	
		if(fns.get(Constantes.CRITERIO_ESTRUCTURAL) != null) {
			res.put(Constantes.CRITERIO_ESTRUCTURAL, porcentajeArea * fns.get(Constantes.CRITERIO_ESTRUCTURAL) * peso.get(Constantes.CRITERIO_ESTRUCTURAL));
		}
		
		if(fns.get(Constantes.CRITERIO_FUNCIONAL) != null) {
			res.put(Constantes.CRITERIO_FUNCIONAL, porcentajeArea * fns.get(Constantes.CRITERIO_FUNCIONAL) * peso.get(Constantes.CRITERIO_FUNCIONAL));
		}
		
		return res;
	}
	
	
	/**
	 * Obtiene el factor de penalización por nivel de severidad de un deterioro.
	 * @param nombreDeterioro
	 * @param severidad
	 * @return Map que relaciona los factores de penalización para el ICE (Índice de condicion estructural) y el ICF (Índice de condición funcional).
	 */
	private static Map<Integer,Double> obtenerFNS(String nombreDeterioro, String severidad){
		
		Map<Integer,Double> res = new HashMap<>();
		switch(nombreDeterioro) {
			case Constantes.FALLA_ABULTAMIENTO:
					switch(severidad) {
						case Constantes.SEVERIDAD_BAJA:
							res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
							res.put(Constantes.CRITERIO_FUNCIONAL,1d);
							break;
						case Constantes.SEVERIDAD_MEDIA:
							res.put(Constantes.CRITERIO_ESTRUCTURAL,1.15d);
							res.put(Constantes.CRITERIO_FUNCIONAL,1.25d);
							break;
						case Constantes.SEVERIDAD_ALTA:
							res.put(Constantes.CRITERIO_ESTRUCTURAL,1.30d);
							res.put(Constantes.CRITERIO_FUNCIONAL,1.50d);
							break;
						default:
							System.out.println(SEVERIDAD_NO_ENCONTRADA);
					}
					break;
				
			case Constantes.FALLA_AHUELLAMIENTO:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.15d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.30d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			case Constantes.FALLA_DEPRESIONES:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.10d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.20d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.20d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.40d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
			    }
				break;
				
			case Constantes.FALLA_DESGASTE_SUPERFICIAL:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.20d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.40d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
			    }
				break;
					
			case Constantes.FALLA_PERDIDA_ARENA:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.15d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.30d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			
			case Constantes.FALLA_DESPLAZAMIENTO_BORDES:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.15d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.30d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			
			case Constantes.FALLA_DESPLAZAMIENTO_JUNTAS:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.10d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.20d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			
			case Constantes.FALLA_FRACTURAMEINTO:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.10d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.20d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			
			case Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_EXTERNOS:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.15d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.30d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
				
			case Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_INTERNOS:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.10d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.10d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.20d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.20d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
				
			case Constantes.FALLA_ESCALAMIENTOS_ADOQUINES:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.25d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.50d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
				
			case Constantes.FALLA_ESCALAMIENTOS_ADOQUINES_CONFINAMIENTOS:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
				
			case Constantes.FALLA_JUNTAS_ABIERTAS:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			
			case Constantes.FALLA_VEGETACION_CALZADA:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,0.8d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.10d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.15d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.20d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.30d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			case Constantes.FALLA_PERDIDA_ADOQUIN:
				switch(severidad) {
					case Constantes.SEVERIDAD_BAJA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1d);
						break;
					case Constantes.SEVERIDAD_MEDIA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.2d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.3d);
						break;
					case Constantes.SEVERIDAD_ALTA:
						res.put(Constantes.CRITERIO_ESTRUCTURAL,1.4d);
						res.put(Constantes.CRITERIO_FUNCIONAL,1.5d);
						break;
					default:
						System.out.println(SEVERIDAD_NO_ENCONTRADA);
				}
				break;
			default:
				System.out.println("No hay FNS definido para el deterioro.");
			
		}
		return res;
	}
	
private static Map<Integer,Double> obtenerPesoEnsuClase(String nombreDeterioro){
		
		Map<Integer,Double> res = new HashMap<>();
		
		switch(nombreDeterioro) {
			case Constantes.FALLA_ABULTAMIENTO:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.2d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.2d);
				break;
				
			case Constantes.FALLA_AHUELLAMIENTO:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.2d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.2d);
				break;
			case Constantes.FALLA_DEPRESIONES:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.0d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.0d);
				break;
				
			case Constantes.FALLA_DESGASTE_SUPERFICIAL:
				res.put(Constantes.CRITERIO_FUNCIONAL,1.1d);
				break;
					
			case Constantes.FALLA_PERDIDA_ARENA:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.0d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.0d);
				break;
			
			case Constantes.FALLA_DESPLAZAMIENTO_BORDES:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.0d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.0d);
				break;
			
			case Constantes.FALLA_DESPLAZAMIENTO_JUNTAS:
				res.put(Constantes.CRITERIO_FUNCIONAL,1.0d);
				break;
			
			case Constantes.FALLA_FRACTURAMEINTO:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.1d);
				break;
			
			case Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_EXTERNOS:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.2d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.2d);
				break;
				
			case Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_INTERNOS:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.0d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.0d);
				break;
				
			case Constantes.FALLA_ESCALAMIENTOS_ADOQUINES:
				res.put(Constantes.CRITERIO_FUNCIONAL,1.2d);
				break;
				
			case Constantes.FALLA_ESCALAMIENTOS_ADOQUINES_CONFINAMIENTOS:
				res.put(Constantes.CRITERIO_FUNCIONAL,1.1d);
				break;
				
			case Constantes.FALLA_JUNTAS_ABIERTAS:
				res.put(Constantes.CRITERIO_FUNCIONAL,1.0d);
				break;
			
			case Constantes.FALLA_VEGETACION_CALZADA:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.0d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.1d);
				break;
			
			case Constantes.FALLA_PERDIDA_ADOQUIN:
				res.put(Constantes.CRITERIO_ESTRUCTURAL,1.3d);
				res.put(Constantes.CRITERIO_FUNCIONAL,1.3d);
				break;
			default:
				System.out.println("No hay peso definido para el deterioro.");
			
		}
		return res;
	}
	
}
