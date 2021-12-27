package co.gov.umv.sigma.backend.pci.articulados.exceptions;

public class SinUnidadesException extends Exception {
	/**
	 * Indica que una calzada no tiene unidades de muestreo, ya que sin unidades de muestreo
	 * el índice PCI no puede ser calculado.
	 * 
	 * @author      Ferney.Moreno
	 */
	private static final long serialVersionUID = -2495292191017112510L;

	public SinUnidadesException(long idCalzada, String CIV) {
		super("ERROR: el area total de las unidades en el mantenimiento +"+idCalzada+" con CIV "+CIV+"es igual a cero o no contiene ninguna unidad.");
	}

}
