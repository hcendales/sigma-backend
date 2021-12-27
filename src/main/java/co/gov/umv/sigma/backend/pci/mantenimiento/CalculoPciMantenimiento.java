package co.gov.umv.sigma.backend.pci.mantenimiento;

import java.util.Map;

import co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialEventoOE;
import co.gov.umv.sigma.backend.pci.CargaMapeoPci;
import co.gov.umv.sigma.backend.pci.exceptions.SinUnidadesException;
import co.gov.umv.sigma.backend.pci.unidadMuestreo.MetodoPci;
/**
 * Clase encargada de realizar el calculo del índice pci
 * para un mantenimiento
 * 
 * @author      Ferney.Moreno
 */
public class CalculoPciMantenimiento {
	public static final long SUPERFICIE_PAV_RIGIDO = 1l;
	public static final long SUPERFICIE_PAV_FLEXIBLE = 2l;
	public static final long SUPERFICIE_ARTICULADO_CONCRETO = 4l;
	public static final long SUPERFICIE_ARTICULADO_ARCILLA = 5l;
	/**
     * Constructor privado para promover el uso estático de la clase.
     */
	private CalculoPciMantenimiento() {
		super();
	}
	
	/**
	 * Calcula el índice pci de un mantenimiento vial obteniendo el indice de sus unidades de muestreo
	 * y obteniendo el promedio ponderado por el area de los indices pci de las unidades de muestreo.
	 * 
	 * @param mantenimiento objeto de tipo MantenimientoVialOE del cual será calculado el PCI.
	 * @return objeto de tipo MantenimientoVialOE que se ingresa en el parametro pero con los valores de PCI incluidos.
	 * @throws Exception 
	 */
	
	
	public static MantenimientoVialEventoOE calcularPci(MantenimientoVialEventoOE mantenimiento) throws Exception {
		
		Map<Long,Long> map = CargaMapeoPci.getMapeoTipoSuperficie(mantenimiento.getUsuario());
		if(map.size() > 0) //RSG:Es necesario validar que si pueda traer los dominios porque ahora pasan por pasarela y son desde caliope
		{
			
			long tipoSuperficie = map.get(mantenimiento.getMantenimientoVialEvento().getIdTipoSuperficie());
			
			
			if(tipoSuperficie == SUPERFICIE_PAV_RIGIDO || tipoSuperficie == SUPERFICIE_PAV_FLEXIBLE || tipoSuperficie == SUPERFICIE_ARTICULADO_CONCRETO || tipoSuperficie == SUPERFICIE_ARTICULADO_ARCILLA ) {
				double totalAreas = 0;
				double totalPonderados = 0;
				
				for (TabUnidadMuestreo unidad : mantenimiento.getMantenimientoVialEvento().getTabUnidadMuestreoList()) 
				{
					totalAreas += unidad.getArea().doubleValue();
					unidad.setPci((long)MetodoPci.calcularPci(unidad,tipoSuperficie, mantenimiento.getUsuario()));
					totalPonderados += unidad.getArea().doubleValue()*unidad.getPci();
				}
				
				if(totalAreas == 0) 
				{
					throw new SinUnidadesException(mantenimiento.getMantenimientoVialEvento().getIdMantenimientoVial().getIdMantenimientoVial(), 
						 mantenimiento.getMantenimientoVialEvento().getIdMantenimientoVial().getCiv());
				}
				else 
				{
					mantenimiento.getMantenimientoVialEvento().setPci(Math.round(totalPonderados/totalAreas));
					//mantenimiento.getMantenimientoVialEvento().getIdMantenimientoVial().setIdTipoCalificacionPci(null); 
					return mantenimiento;
				}
				
			}else {
				return mantenimiento;
			}
		}		
		else
			throw new Exception("No se pudo obtener los dominios desde caliope");
	}
}

