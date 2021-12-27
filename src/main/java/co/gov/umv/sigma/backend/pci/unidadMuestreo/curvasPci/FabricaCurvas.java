package co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.curvas.*;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones.*;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.segmentosCurva.SegmentoCurvaPoli;

/**
 * Clase encargada de generar las curvas de valor deducido y de
 * corrección usadas para calcular el índice PCI de pavimentos 
 * flexibles
 * 
 * @author      Ferney.Moreno
 */
public class FabricaCurvas {
	private static final String SEPARADOR = ";";
	private static final String S_IGUAL = "=";
	private static final String CDV_ID = "q";
	private static final String CDV_RIGIDO_ID = "qr";
	private static final String CDV_ARTICULADO_ID = "qp";
	private static final String SIN_VALOR = "";
	private static final String URL_CURVAS_PCI = "org/gov/umv/core/util/pci/unidadMuestreo/curvasPci/curvasPci.curva";
	private static final String FALLA_ID = "id=";
	private static final String COL_SEV = "sev";
	private static final String NAN = "NaN";
	private static final double MIN_PCI_DV = 0.1;
	
	/**
     * Constructor privado para promover el uso de la clase como estatica
     */
	private FabricaCurvas() {
		
	}
	/**
	 * Retorna las funciones correspondientes a las curvas de valor deducido
	 * y las curvas de corrección del método PCI.
	 *  
	 * @return      HashMap en el cual las llaves son las identificaciones de las
	 *              fallas que da el método PCI, en el caso de las curvas de corrección
	 *              el identificador es "q", y sus valores son las funciones de valor 
	 *              deducido o severidad correspondientes, estas funciones estan 
	 *              representadas con objetos de la clase FuncionVd y FuncionCdv
	 * @see         FuncionCdv
	 * @see         FuncionVd
	 */
	public static Map<String,Funcion> obtenerCurvasPCI() throws IOException {
		//InputStream st = FabricaCurvas.class.getClassLoader().getResourceAsStream(URL_CURVAS_PCI);
		InputStream st = FabricaCurvas.class.getResourceAsStream("curvasPci.curva");
		//
		FabricaCurvas.class.getClassLoader();
		
	    System.out.println(st);
		BufferedReader in = new BufferedReader(new InputStreamReader(st));
	    return procesarArchivo(in);
		
	}
	
	/**
	 * Lee y procesa un archivo de tipo ".curva" para obtener las funciones de
	 * valor deducido y de corrección del método PCI.
	 * 
	 * @return      HashMap en el cual las llaves son las identificaciones de las
	 *              fallas que da el método PCI, en el caso de las curvas de corrección
	 *              el identificador es "q", y sus valores son las funciones de valor 
	 *              deducido o severidad correspondientes, estas funciones estan 
	 *              representadas con objetos de la clase FuncionVd y FuncionCdv
	 * @see         calculopci.pciUnidadmuestreo.curvasPci.funciones.FuncionCdv
	 * @see         calculopci.pciUnidadmuestreo.curvasPci.funciones.FuncionVd
	 */
	private static HashMap<String, Funcion> procesarArchivo(BufferedReader in) throws IOException {
		String linea = null;
		ArrayList<SegmentoCurvaPoli> tempSegmentosCurva = new ArrayList<>();
		String tempSeveridad = "";
		String tempId = "";
		HashMap<String, Curva> tempCurvas = new HashMap<>();
		
		HashMap<String, Funcion> curvasPCI = new HashMap<>();
		
		int numLinea = 1;
	    while((linea = in.readLine()) != null){
	    	switch((linea.length() < 3 ? linea : linea.substring(0, 3))) {
		    	case FALLA_ID:
		    		if(numLinea > 1) {
		    			curvasPCI.put(tempId, procesarFinalFuncion(tempCurvas,tempId));
		    		}
		    		tempId = obtenerPrimerValor(linea);
		    		break;
		    	case COL_SEV:
		    		tempSeveridad = obtenerPrimerValor(linea);
		    		
		    		break;
		    	case NAN:
		    		SegmentoCurvaPoli[] arraySegsCurva = tempSegmentosCurva.toArray(new SegmentoCurvaPoli[tempSegmentosCurva.size()]);
		    		tempCurvas.put(tempSeveridad,procesarFinalSegmento(linea, arraySegsCurva, tempId));
		    		tempSeveridad = null;
		    		tempSegmentosCurva.clear();
		    		break;
		    	default:
		    		tempSegmentosCurva.add(obtenerSegmento(linea));
		    		break;
	    	}
	    	numLinea++;
	    }
	    in.close();
	    return curvasPCI;
		
	}
		
	/**
	 * Convierte un renglon de un archivo de tipo ".curva" a un objeto de tipo 
	 * SegmentoCurvaPoli.
	 *  
	 * @return      objeto de tipo SegmentoCurvaPoli que representa un segmento de una curva
	 * @see         calculopci.pciUnidadmuestreo.curvasPci.segmentosCurva.SegmentoCurvaPoli
	 */
	private static SegmentoCurvaPoli obtenerSegmento(String linea) {
		String[] lineaDiv = linea.split(SEPARADOR);
		
		Object[] filtrado = Arrays.stream(lineaDiv).filter(x -> !x.equals(SIN_VALOR)).toArray();
		lineaDiv = Arrays.copyOf(filtrado, filtrado.length, String[].class);
		
		double[] coeficientes = new double[lineaDiv.length];
		
		for(int i=0;i<lineaDiv.length-1;i++) {
			coeficientes[i] = Double.parseDouble(lineaDiv[i]);
		}
		return new SegmentoCurvaPoli(Double.parseDouble(lineaDiv[lineaDiv.length-1]), Arrays.copyOfRange(coeficientes, 0, lineaDiv.length-1));
	}
	
	/**
	 * Obtiene el primer valor de un renglon de un archivo de tipo ".curva" de la forma a=b
	 * donde a es el nombre de un atributo y b es su valor, es usado para obtener el id de
	 * una falla o una severidad.
	 *  
	 * @return      Valor estipulado en el renglon.
	 */
	private static String obtenerPrimerValor(String linea) { //para obtener idFalla y severidad
		String[] lineaDiv = linea.split(SEPARADOR);
		return lineaDiv[0].split(S_IGUAL)[1];
	}
	
	/**
	 * Crea un objeto de tipo Curva con los segmentos recolectados.
	 *  @param linea texto de la lina que indica que no hay mas segmentos definidos para la curva
	 *  @param arraySegsCurva arreglo que contiene todos los segmentos que se obtuvieron antes del final del segmento
	 *  @param idfuncion es el identificador de la funcion, para una funcion de valores deducidos es el id de la falla
	 *                   según el método PCI, si es una funcion de corrección el identificador es "q".
	 *  @return Objeto de tipo CurvaCdv si idFuncion es "q", de lo contrario un objeto de tipo CurvaVd.
	 *  @see CurvaCdv
	 *  @see CurvaVd
	 */
	private static Curva procesarFinalSegmento(String linea, SegmentoCurvaPoli[] arraySegsCurva, String idfuncion) {
		double maxDensidad = Double.parseDouble(linea.split(SEPARADOR)[4]);
		if(idfuncion.equals(CDV_ID) || idfuncion.equals(CDV_RIGIDO_ID) || idfuncion.equals(CDV_ARTICULADO_ID)) {
			return new CurvaCdv(arraySegsCurva, maxDensidad);
		}else {
			return new CurvaVd(arraySegsCurva, maxDensidad);
		}
	}
	/**
	 * Crea un objeto de tipo Funcion con los segmentos recolectados.
	 *  @param curvas HashMap que contiene las curvas que le pertenecen a la función
	 *  @param idfuncion es el identificador de la funcion, para una funcion de valores deducidos es el id de la falla
	 *                   según el método PCI, si es una funcion de corrección el identificador es "q".
	 *  @return Objeto de tipo FuncionCdv si idFuncion es "q", de lo contrario un objeto de tipo FuncionVd.
	 */
	private static Funcion procesarFinalFuncion(HashMap<String, Curva> curvas, String idfuncion) {
		if(idfuncion.equals(CDV_ID)||idfuncion.equals(CDV_RIGIDO_ID)||idfuncion.equals(CDV_ARTICULADO_ID)) {
			return new FuncionCdv(new HashMap<String, Curva>(curvas));
		}else {
			return new FuncionVd(new HashMap<String, Curva>(curvas), MIN_PCI_DV);
		}
	}
		
}