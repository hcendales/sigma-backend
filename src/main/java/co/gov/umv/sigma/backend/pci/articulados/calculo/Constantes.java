package co.gov.umv.sigma.backend.pci.articulados.calculo;
/**
 * Claseque contiene las constantes del método.
 * @author ferney.moreno
 *
 */
 public final class Constantes {
	//nombres fallas
	public static final String FALLA_ABULTAMIENTO = "Abultamiento";
	public static final String FALLA_AHUELLAMIENTO = "Ahuellamiento";
	public static final String FALLA_DEPRESIONES = "Depresiones";
	public static final String FALLA_DESGASTE_SUPERFICIAL = "Desgaste superficial";
	public static final String FALLA_PERDIDA_ARENA = "Pérdida de arena";
	public static final String FALLA_DESPLAZAMIENTO_BORDES = "Desplazamiento de borde";
	public static final String FALLA_DESPLAZAMIENTO_JUNTAS = "Desplazamiento de juntas";
	public static final String FALLA_FRACTURAMEINTO = "Fracturamiento";
	public static final String FALLA_FRACTURAMEINTO_CONFINAMIENTOS_EXTERNOS = "Fracturamiento de confinamientos externos";
	public static final String FALLA_FRACTURAMEINTO_CONFINAMIENTOS_INTERNOS = "Fracturamiento de confinamientos internos";
	public static final String FALLA_ESCALAMIENTOS_ADOQUINES = "Escalonamiento entre adoquines";
	public static final String FALLA_ESCALAMIENTOS_ADOQUINES_CONFINAMIENTOS = "Escalonamiento entre adoquines y confinamientos";
	public static final String FALLA_JUNTAS_ABIERTAS = "Juntas abiertas";
	public static final String FALLA_VEGETACION_CALZADA = "Vegetación en la calzada";
	public static final String FALLA_PERDIDA_ADOQUIN = "Pérdida de adoquin";
	//nombres clases
	public static final String CLASE_DEFORMACIONES = "Deformaciones";
	public static final String CLASE_DESPRENDIMIENTOS = "Desprendimientos";
	public static final String CLASE_DESPLAZAMIENTOS = "Desplazamientos";
	public static final String CLASE_FRACTURAMIENTOS = "Fracturamientos";
	public static final String CLASE_OTROS = "Otros";
	//nombres severidades
	public static final String SEVERIDAD_BAJA = "baja";
	public static final String SEVERIDAD_MEDIA = "media";
	public static final String SEVERIDAD_ALTA = "alta";
	//valores criterios
	public static final int CRITERIO_ESTRUCTURAL = 0;
	public static final int CRITERIO_FUNCIONAL = 1;
	//nombresIndices
	public static final String INDICE_ICE = "ICE";
	public static final String INDICE_ICF = "ICF";
	//valores tipo superficie
	public static final long SUPERFICIE_ADOQUIN_CONCRETO = 4l;
	public static final long SUPERFICIE_ADOQUIN_ARCILLA = 5l;
	
	private Constantes() {}
}
