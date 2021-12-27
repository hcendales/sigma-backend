package co.gov.umv.sigma.backend.pci.articulados;

import java.util.List;
import java.util.Map;
import java.util.Set;

import co.gov.umv.sigma.backend.comun.entidad.TabFalla;
import co.gov.umv.sigma.backend.comun.entidad.TabUnidadMuestreo;
import co.gov.umv.sigma.backend.mejoramiento.cbo.MantenimientoVialOE;
import co.gov.umv.sigma.backend.pci.CargaMapeoPci;
import co.gov.umv.sigma.backend.pci.articulados.calculo.CalculadorICP;
import co.gov.umv.sigma.backend.pci.articulados.calculo.Constantes;
import co.gov.umv.sigma.backend.pci.articulados.entidades.deterioros.Deterioro;
import co.gov.umv.sigma.backend.pci.exceptions.SinUnidadesException;

/**
 * Clase encargada de calcular el indice de condición del pavimento para superficies articuladas.
 * Se cambió el metodo de calculo por el estandar de ASTM
 * @author ferney.moreno
 * @deprecated 
 */
public class CalculoPciArticulados {
	
	/**
	 * Constructor privado para que la clase a sea usada de manera estática.
	 */
	private CalculoPciArticulados() {
		
	}

	/**
	 * Calcula el indice de condición del pavimento para un mantenimiento vial.
	 * @param mantenimiento 
	 * @return objeto de tipo MantenimientoVialOE que se ingresa en el parametro pero con los valores de PCI incluidos.
	 * @throws Exception 
	 */
	
	
	public static MantenimientoVialOE calcularPci(MantenimientoVialOE mantenimiento, String usuario) throws Exception 
	{
		Map<Long,Long> map =  CargaMapeoPci.getMapeoTipoSuperficie(usuario);
		
		if(map.size() > 0)
		{
			long tipoSuperficie =map.get(mantenimiento.getMantenimientovial().getIdTipoSuperficie());
			
			if(tipoSuperficie == Constantes.SUPERFICIE_ADOQUIN_ARCILLA || tipoSuperficie == Constantes.SUPERFICIE_ADOQUIN_CONCRETO) {
				System.out.println("Calculando PCI Articulados..");
				
				double totalAreas = 0;
				double totalPonderados = 0;
				
				for(TabUnidadMuestreo u : mantenimiento.getMantenimientovial().getTabUnidadMuestreoList()) 
				{
					totalAreas += u.getArea().doubleValue();
					Double pci =  CalculadorICP.CalcularIcp(toArrayDeterioro(u.getTabFallaList(), usuario),
								mantenimiento.getMantenimientovial().getAreaPk().doubleValue());
					u.setPci(pci.longValue());
					totalPonderados += u.getArea().doubleValue()*u.getPci();
				}
				
				if(totalAreas == 0) {
					throw new SinUnidadesException(mantenimiento.getMantenimientovial().getIdMantenimientoVial(),mantenimiento.getMantenimientovial().getCiv());
				}else {
					Long pciMantenimeinto = Math.round(totalPonderados/totalAreas);
					System.out.println("PCI: " + pciMantenimeinto );
					mantenimiento.getMantenimientovial().setPci(pciMantenimeinto);
					mantenimiento.getMantenimientovial().setIdTipoCalificacionPci(null);
					return mantenimiento;
				}
				
				
			}
			
			return mantenimiento;
		}
		else
			throw new Exception("No se pudo obtener los dominios desde caliope");
	}
	
	
	/**
	 * Convierte un array de objetos de la clase TabFalla a un array de objetos de la clase Deterioro
	 * @param fallas Lista de fallas a ser convertidas
	 * @return
	 */
	private static  Deterioro[] toArrayDeterioro(List<TabFalla> fallas, String usuario) {
		TabFalla[] fallasArray = fallas.toArray(new TabFalla[fallas.size()]);
		Deterioro[] resultado = new Deterioro[fallas.size()];
		for(int i=0;i<fallasArray.length;i++) {
			resultado[i] = toDeterioro(fallasArray[i],  usuario);
		}
		return resultado;
	}
	
	/**
	 * Convierte un objeto de la clase TabFalla a un objeto de la clase Deterioro
	 * @param f
	 * @return
	 */
	private static Deterioro toDeterioro(TabFalla f, String usuario) {

		String nombreFalla = MapeoArticulados.getMapeoIdFallas(usuario).get(f.getIdTipoFalla());
		String severidad = MapeoArticulados.getMapeoSeveridades(usuario).get(f.getIdTipoSeveridad());
		Double medida = null;
		if(nombreFalla.equals(Constantes.FALLA_DESPLAZAMIENTO_BORDES) || nombreFalla.equals(Constantes.FALLA_FRACTURAMEINTO_CONFINAMIENTOS_EXTERNOS)) {
			medida = f.getLongitud().doubleValue() * 0.6;
		}else {
			medida = f.getArea().doubleValue();
		}

		return new Deterioro(nombreFalla,severidad,medida);
	}
		
		
}
