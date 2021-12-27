package co.gov.umv.sigma.backend.pci.unidadMuestreo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.DoubleStream;

import co.gov.umv.sigma.backend.comun.entidad.TabFalla;
import co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo;
import co.gov.umv.sigma.backend.pci.CargaMapeoPci;
import co.gov.umv.sigma.backend.pci.entidades.FallaPci;
import co.gov.umv.sigma.backend.pci.exceptions.AreaUnidadInvalidaException;
import co.gov.umv.sigma.backend.pci.exceptions.CantidadLosasUnidadInvalidaException;
import co.gov.umv.sigma.backend.pci.exceptions.FallaNoExisteException;
import co.gov.umv.sigma.backend.pci.exceptions.SeveridadNoExisteException;
import co.gov.umv.sigma.backend.pci.mantenimiento.CalculoPciMantenimiento;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.FabricaCurvas;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones.Funcion;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones.FuncionCdv;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.curvasPci.funciones.FuncionVd;

/**
 * Clase encargada de realizar el calculo del índice pci
 * de una unidad de muestreo aplicando el método PCI.
 * 
 * @author      Ferney.Moreno
 */

public class MetodoPci {
	
	protected static HashMap<String,Funcion> curvasPci = null;
	public static final String ID_CURVAS_CDV = "q";
	public static final String ID_CURVAS_CDV_RIGIDO = "qr";
	public static final String ID_CURVAS_CDV_ARTICULADO = "qp";
	public static final String ID_HUECOS = "F13"; //definido por el método PCI
	public static final double AREA_HUECO_EQUIVALENTE = 0.47; //definido por el método PCI
	public static final String SEVERIDAD_FALLA_BAJA = "l";
	public static final String SEVERIDAD_FALLA_MEDIA = "m";
	public static final String SEVERIDAD_FALLA_ALTA = "h";
	public static final String SEVERIDAD_FALLA_NO_APLICA = "n";	  
	public static final long MAX_AREA_UNIDAD_MUESTREO_FLEXIBLE = 315;
	public static final long MAX_LOSAS_UNIDAD_MUESTREO_RIGIDO = 28;
	private static final String[] FALLAS_LONGITUD_FLEXIBLE = {"F4","F7","F8","F9","F10"}; //ids de fallas cuya medida es la longitud de la misma falla
	private static final String[] FALLAS_LONGITUD_ARTICULADO = {"P3"}; //ids de fallas cuya medida es la longitud de la misma falla
	private static final int CDV_REDUCT = 2; //valor al cual se reducen los valores deducidos en el proceso de consulta del valor deducido corregido
	private static final String ID_FALLA_SIN_DATO = "0"; // identificador de falla sin dato, usada para excluir del calculo las fallas con id = 0

	/**
     * Constructor privado para promover el uso de la clase como estática
     */
	private MetodoPci() {
		super();
	}
	/**
	 * Calcula el índice PCI de una unidad de muestreo.
	 * @param unidad unidad de muestreo de la cual se calcular el
	 *               índice pci.
	 * @param pavimentoFlexible si es true se asume que la unidad es de pavimento flexible, de lo contrario se asume que la unidad es de pavimento rígido.
	 * @return Índice Pci de la unidad de muestreo.
	 * @throws Exception 
	 * @throws UnidadInvalidaException 
	 */
	
	
	public static int calcularPci(TabUnidadMuestreo unidad, long tipoSuperficie,String usuario) throws Exception {
		
		obtenerCurvas();
		
        if(!areaValida(unidad.getArea(), tipoSuperficie)) {
        	if(tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_PAV_FLEXIBLE || tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_CONCRETO || tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_ARCILLA) {
        		throw new AreaUnidadInvalidaException(unidad.getIdUnidadMuestreo(),unidad.getArea());
        	}else {
        		throw new CantidadLosasUnidadInvalidaException(unidad.getIdUnidadMuestreo(),unidad.getArea());
        	}
        }
        List<TabFalla> falla = (unidad.getTabFallaList() == null) ? new ArrayList<TabFalla>() : unidad.getTabFallaList();
        FallaPci[] fallasAgrupadas = agruparFallas(toArrayFallaPci(falla,tipoSuperficie,  usuario));
		Double[] valoresDeducidos = obtenerValoresDeducidos(unidad.getArea().doubleValue(),fallasAgrupadas);
		
		int vdMinimo = CDV_REDUCT;
		
		if(Arrays.stream(valoresDeducidos).filter(x -> x > vdMinimo).toArray().length < 2) {
			double tdv = 0;
			for (Double vd : valoresDeducidos) {
				tdv += vd.doubleValue();
			}
			return (int) Math.round(100d - tdv);
		}
		
		double[] minValoresDeducidos = obtenerMinValoresDeducidos(valoresDeducidos);
		
		return aplicarCorreccion(minValoresDeducidos,tipoSuperficie);
		
	}
	
	/**
	 * Agrupa las fallas que tienen el mismo id y severidad sumando sus cantidades.
	 * @param fallasPci arreglo de objetos de la clase FallaPci que van a ser agrupadas.
	 * @return array con las fallas agrupadas.
	 * @see FallaPci
	 */
	private static FallaPci[] agruparFallas(FallaPci[] fallasPci) {
		ArrayList<FallaPci> resultado = new ArrayList<>();
		
		for (FallaPci falla : fallasPci) {
			if(falla.getIdPci() == ID_FALLA_SIN_DATO) { //excluye del calculo las fallas con id = 0
				continue;
			}
			boolean sinAgrupar = true;
			for (int i=0 ; i<resultado.size() ; i++) {
				if(resultado.get(i).getIdPci().equals(falla.getIdPci()) && resultado.get(i).getSeveridad().equals(falla.getSeveridad())) {
					resultado.get(i).setMedida(resultado.get(i).getMedida()+falla.getMedida());
					sinAgrupar = false; 
				}
			}
			if(sinAgrupar) {
				resultado.add(new FallaPci(falla.getIdPci(), falla.getSeveridad(), falla.getMedida())); //clona la falla
			}
		}
		
		return resultado.toArray(new FallaPci[resultado.size()]);
		
	}
	
	/**
	 * Obtiene los valores deducidos de un conjunto de fallas en una
	 * unidad de muestreo.
	 * @param medidaUnidadMuestreo para pavimento flexible es el area de la unidad de muestreo en la que estan las fallas, para pavimento rigido es la cantidad de losas que componen la unidad de muestreo.
	 * @param fallasAg arreglo con <b><font color="red">fallas agrupadas</font></b>, si las fallas no estan 
	 *                 agrupadas se obtendra una salida incorrecta que afectará
	 *                 el proceso de obtención del índice PCI.
	 * @return Arreglo con los valores deducidos de las fallas.
	 * @throws SeveridadNoExisteException 
	 */
	private static Double[] obtenerValoresDeducidos(double medidaUnidadMuestreo, FallaPci[] fallasAg) throws FallaNoExisteException, SeveridadNoExisteException {
		ArrayList<Double> valoresDeducidos = new ArrayList<>();
		
		for (FallaPci falla : fallasAg) {
		
			FuncionVd func = (FuncionVd) curvasPci.get(falla.getIdPci());
			
			if(func == null) {
				throw new FallaNoExisteException(falla.getIdPci());
			}
				
			Double medidaFalla = falla.getMedida();
			if(falla.getIdPci().equals(ID_HUECOS)) {
				medidaFalla /= AREA_HUECO_EQUIVALENTE;
			}
			
			Double densidad = (medidaFalla/medidaUnidadMuestreo)*100;
			
			double vd = 0;
			try {
				if(densidad > 0) {
					vd = func.calcularValor(falla.getSeveridad(), densidad);
				}
			}catch(NullPointerException e) {
				throw new SeveridadNoExisteException(falla.getSeveridad(),falla.getIdPci());
			}
			if(vd > 0) {
	        	valoresDeducidos.add(Double.valueOf(vd));	
	        }
			
		}
		
		return valoresDeducidos.toArray(new Double[valoresDeducidos.size()]);
	}
	
	/**
	 * Obtiene los valores deducidos a tener en cuenta como consigna el método PCI.
     * 
	 * @param valoresDeducidos arreglo con valores deducidos.
	 * @return Arreglo con los valores deducidos a tener en cuenta ordenados
     *         de mayor a menor.
	 */
	private static double[] obtenerMinValoresDeducidos (Double[] valoresDeducidos) {
		Arrays.sort(valoresDeducidos,Collections.reverseOrder());
		double m = 1 + ((9d/98d) * (100 - valoresDeducidos[0]));
		double[] resultado;
		int lenRespuesta = 0;
		if(m < valoresDeducidos.length ) {
			
			int pEntera = (int) m;
			double pFraccional = m - pEntera;
			if(pFraccional > 0) {
				valoresDeducidos[pEntera] *= pFraccional;
				lenRespuesta = pEntera+1;
			}else {
				lenRespuesta = pEntera;
			}
			
		}else {
			lenRespuesta = valoresDeducidos.length;
		}
		resultado = new double[lenRespuesta];
		for(int i=0 ; i<lenRespuesta ; i++) {
			resultado[i] = valoresDeducidos[i].doubleValue();
		}
		return resultado;
	}
	
	/**
	 * Realiza el proceso de corrección de valores deducidos para obtener el índice pci.
     * 
	 * @param valoresDeducidos arreglo con valores deducidos.
	 * @return indice pci asociado a los valores deducidos.
	 */
	private static int aplicarCorreccion (double[] valoresDeducidos, long idTipoSuperficie) {
		int vdMinimo = CDV_REDUCT;
		int q = Arrays.stream(valoresDeducidos).filter(x -> x > vdMinimo).toArray().length;
		double[] cdvs = new double[q];
		
		while(q > 0) {
			double tdv = DoubleStream.of(valoresDeducidos).sum();
		
			cdvs[q-1] = obtenerCDV(tdv,q,idTipoSuperficie);
			double[] m2 = Arrays.stream(valoresDeducidos).filter(x -> x > vdMinimo).toArray();
			double vReduct = m2[m2.length-1]; //valor que se debe reducir a 2 
			
			for(int i=valoresDeducidos.length - 1; i >= 0;i--){
				if(valoresDeducidos[i]==vReduct) {
					valoresDeducidos[i] = 2.0d;
					break;
				}
			}
			q -= 1;
		}
		
		return (int) Math.round((100 - Arrays.stream(cdvs).max().orElse(0)));
	}
	
	private static double obtenerCDV(double tdv, int q, long idTipoSuperficie ) {
		String idCurvasCDV = null;
		if(idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_PAV_FLEXIBLE) {
			idCurvasCDV = ID_CURVAS_CDV;
		}else if (idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_PAV_RIGIDO) {
			idCurvasCDV = ID_CURVAS_CDV_RIGIDO;
		}else if (idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_CONCRETO || idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_ARCILLA) {
			idCurvasCDV = ID_CURVAS_CDV_ARTICULADO;
		}
		FuncionCdv func = (FuncionCdv) curvasPci.get(idCurvasCDV);
		int idCurvaCDV = 1;
		if(idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_PAV_FLEXIBLE || idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_CONCRETO || idTipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_ARCILLA) {
			idCurvaCDV = q > 7?7:q;
			return func.calcularValor(String.valueOf(idCurvaCDV), tdv);
		} else{
			switch(q) {
				case 5:
					return (func.calcularValor(String.valueOf(4), tdv)+func.calcularValor(String.valueOf(6), tdv))/2d; // (q4+q6)/2 
					
				case 7: 
					return (2d/3)*(func.calcularValor(String.valueOf(6), tdv)+(func.calcularValor(String.valueOf(9), tdv)/2)); //(2/3)*(q6+(q9/2))
					
				case 8:
					return (func.calcularValor(String.valueOf(6), tdv) + (2d*func.calcularValor(String.valueOf(9), tdv)))/3d; //(q6 + (2d*q9))/3
				default:
					break;
			}
			idCurvaCDV = q > 9?9:q;
			
			return func.calcularValor(String.valueOf(idCurvaCDV), tdv);
		}
		
	}
	/**
	 * Obtiene las curvas del método pci para pavimentos flexibles.
     * 
	 * @return HashMap en el cual las llaves son las identificaciones de las
	 *         fallas que da el método PCI, en el caso de las curvas de corrección
	 *         el identificador es "q", y sus valores son las funciones de valor 
	 *         deducido o severidad correspondientes, estas funciones estan 
	 *         representadas con objetos de la clase FuncionVd y FuncionCdv.
	 * 
	 * @see    FabricaCurvas
	 * @see    FuncionCdv
	 * @see    FuncionVd
	 */
	private static void obtenerCurvas() throws IOException {
		if(curvasPci == null) {
			curvasPci = new HashMap<>(FabricaCurvas.obtenerCurvasPCI());
		}
	}
	
	/**
	 * Convierte una lista de fallas de la clase TabFallaVO a un array de fallas de la clase FallaPci.
	 * @param fallas lista de fallas a ser convertidas.
	 * @return array con fallas de tipo FallaPci.
	 * @throws Exception 
	 */
	
	private static FallaPci[] toArrayFallaPci(List<TabFalla> fallas, long tipoSuperficie,String usuario) throws Exception {
		TabFalla[] fallasArray = fallas.toArray(new TabFalla[fallas.size()]);
		FallaPci[] resultado = new FallaPci[fallas.size()];
		for(int i=0;i<fallasArray.length;i++) {
			resultado[i] = toFallaPci(fallasArray[i], tipoSuperficie, usuario);
		}
		return resultado;
	}
	
	/**
	 * Convierte un objeto de la clase TabFallaVO a un objeto de la clase FallaPci.
	 * @param falla Falla a ser convertida
	 * @return falla de la clase FallaPci
	 * @throws Exception 
	 */
	private static FallaPci toFallaPci(TabFalla falla, long tipoSuperficie, String usuario) throws Exception 
	{
		
		Map<Long,String> mapeoIdFallas = CargaMapeoPci.getMapeoIdFallas( usuario);
		Map<Long, String> mapeoSeveridades = CargaMapeoPci.getMapeoSeveridades( usuario);
		System.out.println("TIPO SUPERFICIE ES: " + tipoSuperficie);
		if(mapeoIdFallas.size() == 0 || mapeoSeveridades.size() == 0) //RSG es necesario validar que al pasar por pasarela se obtenga el resultado correcto.
		{
			throw new Exception("No se pudo obtener los dominios desde caliope");
		}
		
		String idFalla = mapeoIdFallas.get(falla.getIdTipoFalla());
		String severidad = mapeoSeveridades.get(falla.getIdTipoSeveridad());
				
		Double medida;
		if(tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_PAV_FLEXIBLE) {
			if(java.util.Arrays.asList(FALLAS_LONGITUD_FLEXIBLE).indexOf(idFalla) > -1) {
				medida = falla.getLongitud().doubleValue();
			}else {
				medida = falla.getArea().doubleValue();
			}
		}else if(tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_CONCRETO || tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_ARCILLA) {
			if(java.util.Arrays.asList(FALLAS_LONGITUD_ARTICULADO).indexOf(idFalla) > -1) {
				medida = falla.getLongitud().doubleValue();
			}else {
				medida = falla.getArea().doubleValue();
			}
		}
		else {
			System.out.println("PASE POR AHI");
			medida = (falla.getNumeroLosas() == null) ? null : falla.getNumeroLosas().doubleValue();
		}
		System.out.println("MEDIDA " + medida + " SEVERIDAD " +severidad + "Id Falla" + idFalla);
		return new FallaPci(idFalla,severidad,medida);
	}
	

	
	private static boolean areaValida(BigDecimal area, long tipoSuperficie) {
		if(area.doubleValue() <= 0d) {
			return false;
		}else
		if((tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_PAV_FLEXIBLE || tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_CONCRETO || tipoSuperficie == CalculoPciMantenimiento.SUPERFICIE_ARTICULADO_ARCILLA) && area.doubleValue() > MAX_AREA_UNIDAD_MUESTREO_FLEXIBLE) {
			return false;
		}else
		if(tipoSuperficie == 1l && area.doubleValue() > MAX_LOSAS_UNIDAD_MUESTREO_RIGIDO) {
			return false;
		}
		return true;
	}
}

