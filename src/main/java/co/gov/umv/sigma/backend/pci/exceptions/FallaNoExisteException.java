package co.gov.umv.sigma.backend.pci.exceptions;

public class FallaNoExisteException extends Exception{
	/**
	 * Indica que una unidad de muestreo posee un area no válida que es igual o menor que cero.
	 * 
	 * @author      Ferney.Moreno
	 */
	
	private static final long serialVersionUID = 719412209903369642L;
	
	public FallaNoExisteException(String idFalla) {
		super("ERROR: No se encontraron curvas de valor deducido para la falla con id "+ idFalla );
	}
}
