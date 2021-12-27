package co.gov.umv.sigma.backend.pci;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import co.gov.umv.sigma.backend.comun.cbo.DominioGenerico;
import co.gov.umv.sigma.backend.comun.dto.IDominioDTO;
import co.gov.umv.sigma.backend.comun.dto.impl.DominioDTO;

@Component
public class CargaMapeoPci 
{
	
	private  static Map<Long,String> mapeoIdFallas;
	private  static Map<Long,String> mapeoSeveridades;
	private  static Map<Long,Long> mapeoIdTiposSuperficie;
			
	private  static final int NOMBRE_LISTA_SEVERIDADES = 24;  //"TAB_FALLA_ID_TIPO_SEVERIDAD"; 
	private  static final int NOMBRE_LISTA_ID_FALLAS = 9;  //"TAB_FALLA_ID_TIPO_FALLA";
	private  static final int NOMBRE_LISTA_TIPOS_SUPERFICIE = 42; //"TAB_MANTENIMIENTO_VIAL_ID_TIPO_SUPERFICIE";
	
	
	public static final String SEVERIDAD_FALLA_BAJA = "l";
	public static final String SEVERIDAD_FALLA_MEDIA = "m";
	public static final String SEVERIDAD_FALLA_ALTA = "h";
	public static final String SEVERIDAD_FALLA_NO_APLICA = "n";
	
	 
	 public static Map<Long,String> getMapeoIdFallas(String usuario)
	 {

		IDominioDTO dominios = new DominioDTO();
			
		 if(mapeoIdFallas == null) 
		 { 
			 List<DominioGenerico> dominioFallas = dominios.listaDominios(usuario, NOMBRE_LISTA_ID_FALLAS);
			 mapeoIdFallas = new HashMap<>();
			 
			 for (DominioGenerico falla : dominioFallas) 
			 {
				 mapeoIdFallas.put(falla.getId_tipo(), falla.getValor());
			 }
		 }
		 return mapeoIdFallas;
	 }
	 
	 public static  Map<Long,String> getMapeoSeveridades(String usuario)
	 {

		 IDominioDTO dominios = new DominioDTO();
			
		 if(mapeoSeveridades == null) 
		 { 
			 
			 List<DominioGenerico> dominioSeveridades = dominios.listaDominios(usuario, NOMBRE_LISTA_SEVERIDADES);
		
			 mapeoSeveridades = new HashMap<>();
			 for (DominioGenerico severidad : dominioSeveridades)
			 {
				 String valorMapeado;
				 switch(severidad.getValor()) {
				 	case "1":
				 		valorMapeado = SEVERIDAD_FALLA_ALTA;
				 		break;
				 	case "2":
				 		valorMapeado = SEVERIDAD_FALLA_MEDIA;
				 		break;
				 	case "3":
				 		valorMapeado = SEVERIDAD_FALLA_BAJA;
				 		break;
				 	default:
				 		valorMapeado = SEVERIDAD_FALLA_NO_APLICA;
				 }
				 mapeoSeveridades.put(severidad.getId_tipo(), valorMapeado);
			 }
		}
		return mapeoSeveridades;
	 }
	 
	 public  static Map<Long,Long> getMapeoTipoSuperficie(String usuario)
	 {

		IDominioDTO dominios = new DominioDTO();
			
		 if(mapeoIdTiposSuperficie == null) 
		 { 
			 
			 List<DominioGenerico> dominioTiposSuperficies = dominios.listaDominios(usuario, NOMBRE_LISTA_TIPOS_SUPERFICIE);
				
			 mapeoIdTiposSuperficie = new HashMap<>();
			 for (DominioGenerico tipoSuperficie : dominioTiposSuperficies) 
			 {
				 mapeoIdTiposSuperficie.put(tipoSuperficie.getId_tipo(), Long.valueOf(tipoSuperficie.getValor()));
			 }
		 }
		 return mapeoIdTiposSuperficie;
	 }

}
