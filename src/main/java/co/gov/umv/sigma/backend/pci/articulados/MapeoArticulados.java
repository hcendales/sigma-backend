package co.gov.umv.sigma.backend.pci.articulados;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import co.gov.umv.sigma.backend.comun.cbo.DominioGenerico;
import co.gov.umv.sigma.backend.comun.dto.IDominioDTO;
import co.gov.umv.sigma.backend.comun.dto.impl.DominioDTO;
import co.gov.umv.sigma.backend.pci.articulados.calculo.Constantes;

/**
 * Clase encargada de obtener los mapeos de las entidades de entrada a las entidades propias del módulo.
 * Se reemplazó el metodo de calculo por el estandar de ASTM
 * @author ferney.moreno
 * 
 */
@Component
public class MapeoArticulados {
	
	
	private static  Map<Long,String> mapeoIdFallas;
	private static  Map<Long,String> mapeoSeveridades;
	
	private static final int NOMBRE_LISTA_ID_FALLAS = 9;  //"TAB_FALLA_ID_TIPO_FALLA";
	
	private static final String TIPO_FALLA_ARTICULADOS = "A";
	private static final int NOMBRE_LISTA_SEVERIDADES = 24;  //"TAB_FALLA_ID_TIPO_SEVERIDAD"; 
	
	//private static final String NOMBRE_USUARIO_SISTEMA = "Sistema";
	
	
	 /**
	  * Obtiene el mapeo correspondiente del id de una falla al nombre de deterioro.
	  * @return
	  */
	 public static Map<Long,String> getMapeoIdFallas(String usuario)
	 {
		 IDominioDTO dominios = new DominioDTO();
			
		 if(mapeoIdFallas == null) 
		 { 
			 List<DominioGenerico> dominioFallas = dominios.listaDominios(usuario, NOMBRE_LISTA_ID_FALLAS);
			 
			 mapeoIdFallas = new HashMap<>();
			 for (DominioGenerico falla : dominioFallas) 
			 {
				 if(falla.getValor().substring(0,1).equals(TIPO_FALLA_ARTICULADOS)) {
					 mapeoIdFallas.put(falla.getId_tipo(), getNombreFalla(falla.getValor().substring(1)));				 
				 }
			 }
		 }
		 return mapeoIdFallas;
	 }
	 
	 /**
	  * Obtiene el nombre de la falla dado un idFalla.
	  * @param idFalla
	  * @return
	  */
	 private static String getNombreFalla(String idFalla) 
	 {
		 switch(idFalla) 
		 {
		 	case "40": return Constantes.FALLA_ABULTAMIENTO;
		 	case "41": return Constantes.FALLA_AHUELLAMIENTO;
		 	case "42": return Constantes.FALLA_DEPRESIONES;
		 	case "43": return Constantes.FALLA_PERDIDA_ADOQUIN;
		 	case "44": return Constantes.FALLA_DESGASTE_SUPERFICIAL;
		 	case "45": return Constantes.FALLA_PERDIDA_ARENA;
		 	case "46": return Constantes.FALLA_DESPLAZAMIENTO_BORDES;
		 	case "47": return Constantes.FALLA_DESPLAZAMIENTO_JUNTAS;
		 	case "48": return Constantes.FALLA_FRACTURAMEINTO;
		 	case "49": return Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_EXTERNOS;
		 	case "50": return Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_INTERNOS;
		 	case "51": return Constantes.FALLA_ESCALAMIENTOS_ADOQUINES;
		 	case "52": return Constantes.FALLA_ESCALAMIENTOS_ADOQUINES_CONFINAMIENTOS;
		 	case "53": return Constantes.FALLA_JUNTAS_ABIERTAS;
		 	case "54": return Constantes.FALLA_VEGETACION_CALZADA;
		 	default: System.out.println("No se encontró la falla con el id " + idFalla); 
		 		return null;
		 
		 }
	 }
	 
	 /**
	  * Obtiene el nombre de la severidad usado por el módulo en función de la severidad del objeto externo falla.
	  * @return
	  */
	 public static Map<Long,String> getMapeoSeveridades(String usuario)
	 {
		 IDominioDTO dominios = new DominioDTO();
			
		 if(mapeoSeveridades == null) 
		 { 
			 List<DominioGenerico> dominioSeveridades = dominios.listaDominios(usuario, NOMBRE_LISTA_SEVERIDADES);
				
			 mapeoSeveridades = new HashMap<>();
			 for (DominioGenerico severidad : dominioSeveridades)
			 {
				 String valorMapeado = null;
				 switch(severidad.getValor()) {
				 	case "1":
				 		valorMapeado = Constantes.SEVERIDAD_ALTA;
				 		break;
				 	case "2":
				 		valorMapeado = Constantes.SEVERIDAD_MEDIA;
				 		break;
				 	case "3":
				 		valorMapeado = Constantes.SEVERIDAD_BAJA;
				 		break;
				 	default:
				 		System.out.println("No hay un valor definido para la severidad " + severidad.getValor());
				 }
				 mapeoSeveridades.put(severidad.getId_tipo(), valorMapeado);
			 }
		}
		return mapeoSeveridades;
	 }

}
