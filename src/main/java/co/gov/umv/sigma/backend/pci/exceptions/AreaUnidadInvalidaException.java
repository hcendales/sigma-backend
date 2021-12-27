package co.gov.umv.sigma.backend.pci.exceptions;

import java.math.BigDecimal;

public class AreaUnidadInvalidaException extends Exception {
	/**
	 * Indica que una unidad de meustreo posee un area no válida que es igual o menor que cero.
	 * 
	 * @author      Ferney.Moreno
	 */
	private static final long serialVersionUID = 1031321226986431003L;

	public AreaUnidadInvalidaException(long consecUnidad, BigDecimal areaUnidad) {
		super("ERROR: la unidad "+ consecUnidad + " tiene un área no válida (" + areaUnidad + "m2)");
	}
}
