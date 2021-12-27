package co.gov.umv.sigma.backend.pci.articulados.calculo;

import co.gov.umv.sigma.backend.pci.articulados.entidades.deterioros.Deterioro;

 final class ClasificadorDeterioros {

	/**
	 * Constructor privado para que la clase sea usada de manera estática.
	 */
	private ClasificadorDeterioros() {}
	
	/**
	 * Obtiene la clase en la cual está clasificada un deterioro
	 * @param d
	 * @return nombre de la clase del deterioro.
	 */
	public static String getClase(Deterioro d) {
		
		if(d.getNombreFalla().equals(Constantes.FALLA_ABULTAMIENTO) || d.getNombreFalla().equals(Constantes.FALLA_AHUELLAMIENTO) || d.getNombreFalla().equals(Constantes.FALLA_DEPRESIONES) || d.getNombreFalla().equals(Constantes.FALLA_PERDIDA_ADOQUIN)) {
			return Constantes.CLASE_DEFORMACIONES;
		}
		
		if(d.getNombreFalla().equals(Constantes.FALLA_DESGASTE_SUPERFICIAL) || d.getNombreFalla().equals(Constantes.FALLA_PERDIDA_ARENA)) {
			return Constantes.CLASE_DESPRENDIMIENTOS;
		}
		
		if(d.getNombreFalla().equals(Constantes.FALLA_DESPLAZAMIENTO_BORDES) || d.getNombreFalla().equals(Constantes.FALLA_DESPLAZAMIENTO_JUNTAS)) {
			return Constantes.CLASE_DESPLAZAMIENTOS;
		}
		
		if(d.getNombreFalla().equals(Constantes.FALLA_FRACTURAMEINTO) || d.getNombreFalla().equals(Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_EXTERNOS) || d.getNombreFalla().equals(Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_INTERNOS)) {
			return Constantes.CLASE_FRACTURAMIENTOS;
		}
		
		if(d.getNombreFalla().equals(Constantes.FALLA_ESCALAMIENTOS_ADOQUINES) || d.getNombreFalla().equals(Constantes.FALLA_ESCALAMIENTOS_ADOQUINES_CONFINAMIENTOS) || d.getNombreFalla().equals(Constantes.FALLA_JUNTAS_ABIERTAS) || d.getNombreFalla().equals(Constantes.FALLA_VEGETACION_CALZADA)) {
			return Constantes.CLASE_OTROS;
		}
		
		return null;
		
	}
}
